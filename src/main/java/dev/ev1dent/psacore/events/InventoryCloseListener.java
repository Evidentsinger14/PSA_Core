package dev.ev1dent.psacore.events;

import dev.ev1dent.psacore.utilities.InventoryManager;
import dev.ev1dent.psacore.utilities.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryCloseListener implements Listener {
    InventoryManager im = new InventoryManager();
    Utils Utils = new Utils();
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        if(im.isSelector(event.getInventory())){
            event.getPlayer().sendMessage(Utils.formatMM("<green>run <underlined>/worlds</underlined> to access the world menu!"));
        }
    }
}
