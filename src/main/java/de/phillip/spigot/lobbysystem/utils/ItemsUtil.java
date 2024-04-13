package de.phillip.spigot.lobbysystem.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ItemsUtil {

    public void setDefaultItems(Player p){
        p.getInventory().clear();
        p.getInventory().setItem(0, new ItemBuilder(Material.COMPASS).setName("§8» §cNavigator").toItemStack());
        p.getInventory().setItem(1, new ItemBuilder(Material.BLAZE_ROD).setName("§8» §cSpieler-Verstecker").toItemStack());
        p.getInventory().setItem(7, new ItemBuilder(Material.NETHER_STAR).setName("§8» §cLobbys").toItemStack());
        p.getInventory().setItem(8, new ItemBuilder(Material.CHEST).setName("§8» §cEinstellungen").toItemStack());
    }
}
