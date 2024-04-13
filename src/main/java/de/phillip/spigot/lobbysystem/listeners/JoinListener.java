package de.phillip.spigot.lobbysystem.listeners;

import de.phillip.spigot.lobbysystem.LobbySystem;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(!LobbySystem.getInstance().getLocationUtil().getCfg().contains("location.spawn")){
            p.sendMessage(LobbySystem.PREFIX + "§cEs wurde kein Spawn gesetzt!");
            return;
        }

        p.teleport(LobbySystem.getInstance().getLocationUtil().getLocation("location.spawn"));
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 10);

        e.setJoinMessage("§8[§a+§8] §6" + p.getName());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage("§8[§c-§8] §6" + p.getName());
    }
}
