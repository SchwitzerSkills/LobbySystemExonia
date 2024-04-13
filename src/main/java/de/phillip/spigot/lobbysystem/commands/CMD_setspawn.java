package de.phillip.spigot.lobbysystem.commands;

import de.phillip.spigot.lobbysystem.LobbySystem;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMD_setspawn implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender cs, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            if (!(cs instanceof Player p)) {
                cs.sendMessage(LobbySystem.noCS);
                return false;
            }
            if (!p.hasPermission("Lobby.setspawn")) {
                p.sendMessage(LobbySystem.noPERMS);
                return false;
            }
            if(args.length == 0){
                LobbySystem.getInstance().getLocationUtil().setLocation("location.spawn", p.getLocation());
                p.sendMessage(LobbySystem.PREFIX + "Du hast den Spawn §agesetzt§8.");
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 10);
                return true;
            }

            p.sendMessage(LobbySystem.PREFIX + "§c/setspawn");
            return false;
        }
        return false;
    }
}
