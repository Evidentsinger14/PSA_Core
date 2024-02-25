package dev.ev1dent.psacore.events;

import dev.ev1dent.psacore.PSACore;
import dev.ev1dent.psacore.utilities.InventoryManager;
import dev.ev1dent.psacore.utilities.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerLoginListener implements Listener {

    PSACore plugin;
    public PlayerLoginListener(PSACore plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event){
        Utils Utils = new Utils();
        InventoryManager im = new InventoryManager();
        new BukkitRunnable(){
            @Override
            public void run(){
                event.getPlayer().openInventory(im.worldSwitchGUI(event.getPlayer()));
            }
        }.runTaskLater(plugin, 20 * 5);
    }
}
