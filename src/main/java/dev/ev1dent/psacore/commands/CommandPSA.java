package dev.ev1dent.psacore.commands;

import dev.ev1dent.psacore.utilities.Utils;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandPSA implements CommandExecutor {
    private final LuckPerms luckPerms;
    public CommandPSA(LuckPerms luckPerms){
        this.luckPerms =  luckPerms;
    }
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
                Player player = (Player) sender;
                switch (val) {
                    case "on" -> {
                        Node node = Node.builder("psacore.auto-open").value(true).build();
                        this.luckPerms.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {
                            user.data().add(node);
                        });
                    }
                    case "off" -> {
                        Node node = Node.builder("psacore.auto-open").value(false).build();
                        this.luckPerms.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {
                            user.data().add(node);
                        });
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
