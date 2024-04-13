package de.phillip.spigot.lobbysystem.listeners;

import de.phillip.spigot.lobbysystem.utils.ItemBuilder;
import eu.thesimplecloud.api.CloudAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class NavigatorListener implements Listener {


    private ArrayList<String> description = new ArrayList<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        try{
            Player p = e.getPlayer();

            if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
                if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cNavigator")) {
                    if(e.getItem().getType() == Material.COMPASS){
                        Inventory inv = Bukkit.createInventory(null, 9*4, "§8» §cNavigator");

                        for(int i = 0; i < inv.getSize(); i++){
                            inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").toItemStack());
                        }

                        int cbPlayerCount = CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("CityBuild-1").getOnlineCount();
                        int cbMaxPlayerCount = CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("CityBuild-1").getMaxPlayers();
                        int cbOldPlayerCount = CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("CBOld-1").getOnlineCount();
                        int cbOldMaxPlayerCount = CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("CBOld-1").getMaxPlayers();

                        description.clear();
                        description.add("§cVersion§8: §c1.20.4");
                        description.add("§cSpieler§8: §c" + cbPlayerCount + "§8/§c" + cbMaxPlayerCount);
                        inv.setItem(13, new ItemBuilder(Material.GRASS_BLOCK).setName("§8» §c§lCityBuild §8[§cNEW§8]").setLore(description).toItemStack());

                        description.clear();
                        description.add("§cVersion§8: §c1.20.2");
                        description.add("§cSpieler§8: §c" + cbOldPlayerCount + "§8/§c" + cbOldMaxPlayerCount);
                        inv.setItem(14, new ItemBuilder(Material.MYCELIUM).setName("§8» §c§lCityBuild §8[§cOLD§8]").setLore(description).toItemStack());

                        p.openInventory(inv);
                    }
                }
            }
        } catch (Exception e1){
        }
    }
}
