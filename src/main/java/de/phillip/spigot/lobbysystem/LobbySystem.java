package de.phillip.spigot.lobbysystem;

import de.phillip.spigot.lobbysystem.commands.CMD_build;
import de.phillip.spigot.lobbysystem.commands.CMD_setspawn;
import de.phillip.spigot.lobbysystem.listeners.BuildListener;
import de.phillip.spigot.lobbysystem.listeners.JoinListener;
import de.phillip.spigot.lobbysystem.listeners.NavigatorListener;
import de.phillip.spigot.lobbysystem.utils.ItemsUtil;
import de.phillip.spigot.lobbysystem.utils.LocationUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class LobbySystem extends JavaPlugin {

    public static String PREFIX = "§cLobby §8| §7";
    public static String noPERMS = PREFIX + "§cDu hast keine Berechtigung!";
    public static String noCS = PREFIX + "§cDu musst ein Spieler sein!";
    public static LobbySystem instance;

    private LocationUtil locationUtil;

    private ItemsUtil itemsUtil;

    private ArrayList<Player> build = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        registerListeners(Bukkit.getPluginManager());
        registerCommands();

        this.locationUtil = new LocationUtil();
        this.itemsUtil = new ItemsUtil();

        settingWorld();
    }

    public void settingWorld(){
        for (World world : Bukkit.getWorlds()){

            world.setTime(0);
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);

            for(Entity entity : world.getEntities()){
                if(entity.getType() != EntityType.PLAYER){
                    entity.remove();
                }
            }
        }
    }

    public void registerListeners(PluginManager pm){
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new BuildListener(), this);
        pm.registerEvents(new NavigatorListener(), this);
    }

    public void registerCommands(){
        getCommand("setspawn").setExecutor(new CMD_setspawn());
        getCommand("build").setExecutor(new CMD_build());
    }

    public static LobbySystem getInstance() {
        return instance;
    }

    public LocationUtil getLocationUtil() {
        return locationUtil;
    }

    public ItemsUtil getItemsUtil() {
        return itemsUtil;
    }

    public ArrayList<Player> getBuild() {
        return build;
    }

    @Override
    public void onDisable() {

    }
}
