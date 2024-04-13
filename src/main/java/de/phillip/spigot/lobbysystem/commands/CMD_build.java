package de.phillip.spigot.lobbysystem.commands;

import de.phillip.spigot.lobbysystem.LobbySystem;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMD_build implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender cs, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("build")) {
            if (!(cs instanceof Player p)) {
                cs.sendMessage(LobbySystem.noCS);
                return false;
            }
            if (!p.hasPermission("Lobby.build")) {
                p.sendMessage(LobbySystem.noPERMS);
                return false;
            }
            if(args.length == 0){
                if(LobbySystem.getInstance().getBuild().contains(p)){
                    LobbySystem.getInstance().getBuild().remove(p);
                    p.sendMessage(LobbySystem.PREFIX + "§7Du bist nicht mehr im §cBuild-Modus");
                    p.setGameMode(GameMode.ADVENTURE);
                    p.getInventory().clear();
                    LobbySystem.getInstance().getItemsUtil().setDefaultItems(p);
                } else {
                    LobbySystem.getInstance().getBuild().add(p);
                    p.sendMessage(LobbySystem.PREFIX + "§7Du bist im §cBuild-Modus");
                    p.setGameMode(GameMode.CREATIVE);
                    p.getInventory().clear();
                }

                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 10);

                return true;
            }

            p.sendMessage(LobbySystem.PREFIX + "§c/build");
            return false;
        }
        return false;
    }
}
