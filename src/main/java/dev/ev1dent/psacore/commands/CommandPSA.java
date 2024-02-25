package dev.ev1dent.psacore.commands;

import dev.ev1dent.psacore.utilities.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandPSA implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Utils Utils = new Utils();
        if(args.length == 0){
            returnUsage((Player) sender, Utils);
        }
        String input = args[0].toLowerCase();
        switch (input) {
            case "version" -> {
                returnVersion((Player)sender, Utils);
            }

            case "auto" -> {
                String val = args[1];
                switch (val) {
                    case "on" -> {
                        Player player = (Player) sender;
                        Bukkit.getServer().dispatchCommand(
                                Bukkit.getConsoleSender(),
                                String.format("lp user %s permission unsettemp psacore.auto-open", player.getUniqueId())
                        );
                    }
                    case "off" -> {
                        Player player = (Player) sender;
                        Bukkit.getServer().dispatchCommand(
                                Bukkit.getConsoleSender(),
                                String.format("lp user %s permission settemp psacore.auto-open false 3d", player.getUniqueId())
                        );
                    }
                    default -> {
                    }
                }
            }

            default -> {}
        }

        return false;
    }

    public void returnUsage(Player player, Utils Utils){
        player.sendMessage(Utils.formatMM("Please specify an argument"));
    }

    public void returnVersion(Player player, Utils Utils){
        player.sendMessage(Utils.formatMM("Version: 1.0.0"));
    }

}
