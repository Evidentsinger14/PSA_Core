package dev.ev1dent.psacore.events;

import dev.ev1dent.psacore.PSACore;
import dev.ev1dent.psacore.utilities.InventoryManager;
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
        InventoryManager im = new InventoryManager();
        new BukkitRunnable(){
            @Override
            public void run(){
                if(!event.getPlayer().hasPermission("psacore.auto-open")) return;
                event.getPlayer().openInventory(im.worldSwitchGUI(event.getPlayer()));
            }
        }.runTaskLater(plugin, 20 * 5);
    }
}
