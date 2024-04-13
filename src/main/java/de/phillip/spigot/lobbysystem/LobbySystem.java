package de.phillip.spigot.lobbysystem;

import de.phillip.spigot.lobbysystem.commands.CMD_setspawn;
import de.phillip.spigot.lobbysystem.listeners.JoinListener;
import de.phillip.spigot.lobbysystem.utils.LocationUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbySystem extends JavaPlugin {

    public static String PREFIX = "§cLobby §8| §7";
    public static String noPERMS = PREFIX + "§cDu hast keine Berechtigung!";
    public static String noCS = PREFIX + "§cDu musst ein Spieler sein!";
    public static LobbySystem instance;

    private LocationUtil locationUtil = new LocationUtil();

    @Override
    public void onEnable() {
        instance = this;
        registerListeners(Bukkit.getPluginManager());
        registerCommands();
    }

    public void registerListeners(PluginManager pm){
        pm.registerEvents(new JoinListener(), this);
    }

    public void registerCommands(){
        getCommand("setspawn").setExecutor(new CMD_setspawn());
    }

    public static LobbySystem getInstance() {
        return instance;
    }

    public LocationUtil getLocationUtil() {
        return locationUtil;
    }

    @Override
    public void onDisable() {

    }
}
