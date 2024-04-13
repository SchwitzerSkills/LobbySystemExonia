package de.phillip.spigot.lobbysystem.listeners;

import de.phillip.spigot.lobbysystem.LobbySystem;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class BuildListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(!LobbySystem.getInstance().getBuild().contains(p)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(!LobbySystem.getInstance().getBuild().contains(p)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        try {
            Player p = (Player) e.getWhoClicked();
            if (!LobbySystem.getInstance().getBuild().contains(p)) {
                e.setCancelled(true);
            }
        } catch (Exception e1){
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        try {
            Player p = e.getPlayer();
            if (!LobbySystem.getInstance().getBuild().contains(p)) {
                e.setCancelled(true);
            }
        } catch (Exception e1){
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e){
        try {
            Player p = e.getPlayer();
            if (!LobbySystem.getInstance().getBuild().contains(p)) {
                e.setCancelled(true);
            }
        } catch (Exception e1){
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        try {
            Player p = (Player) e.getEntity();
            if (!LobbySystem.getInstance().getBuild().contains(p)) {
                e.setCancelled(true);
            }
        } catch (Exception e1){
        }
    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e){
        if(e.getEntity().getType() != EntityType.PLAYER){
            e.getEntity().remove();
            e.setCancelled(true);
        }
    }

}
