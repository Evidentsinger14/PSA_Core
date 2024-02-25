package dev.ev1dent.psacore.commands;

import dev.ev1dent.psacore.utilities.InventoryManager;
import dev.ev1dent.psacore.utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPSA implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Cannot run from console.");
            return true;
        }
        Utils Utils = new Utils();
        InventoryManager im = new InventoryManager();
        Player player = (Player) sender;
        player.sendMessage(Utils.formatMM("<red>Opening Menu..."));
        player.openInventory(im.worldSwitchGUI(player));
        return false;
    }
}
