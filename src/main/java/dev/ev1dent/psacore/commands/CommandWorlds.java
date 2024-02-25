package dev.ev1dent.psacore.commands;

import dev.ev1dent.psacore.utilities.InventoryManager;
import dev.ev1dent.psacore.utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandWorlds implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, String[] args) {
        if(!(sender instanceof Player player)) {
            sender.sendMessage("Cannot run from console.");
            return true;
        }
        Utils Utils = new Utils();
        InventoryManager im = new InventoryManager();
        player.sendMessage(Utils.formatMM("<red>Opening Menu..."));
        player.openInventory(im.worldSwitchGUI(player));

        return false;
    }
}
