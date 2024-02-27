package dev.ev1dent.psacore.utilities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryManager implements Listener {
    Utils Utils = new Utils();
    public Inventory worldSwitchGUI(Player player){
        Inventory gui = Bukkit.createInventory(player, 27, Utils.formatMM("<dark_purple>World Switcher"));
        gui.setItem(4, spawnItem);
        gui.setItem(11, simptopiaItem);
        gui.setItem(13, lolSimpsItem);
        gui.setItem(15, snapshotItem);
        return gui;
    }

    ItemStack simptopiaItem = new ItemStackBuilder()
            .withMaterial(Material.PURPLE_WOOL)
            .withDisplayName("<dark_purple>Simptopia")
            .addLore("<white>Retired Stream SMP for https://twitch.tv/kenna!")
            .build();

    ItemStack lolSimpsItem = new ItemStackBuilder()
            .withMaterial(Material.CYAN_WOOL)
            .withDisplayName("<aqua>lolsimps SMP")
            .addLore("<white>Retired Stream SMP for https://twitch.tv/kenna!")
            .build();

    ItemStack snapshotItem = new ItemStackBuilder()
            .withMaterial(Material.BLUE_WOOL)
            .withDisplayName("<blue>1.17 Snapshot SMP")
            .addLore("<white>1.17 snapshot smp server for Evidents Friends!")
            .build();

    ItemStack spawnItem = new ItemStackBuilder()
            .withMaterial(Material.BARRIER)
            .withDisplayName("<white>Spawn")
            .addLore("<white>Head back to spawn!")
            .build();

    @EventHandler
    public void onItemClick(InventoryClickEvent event){
        ItemStack item = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();
        if(item == null) return;
        if(item.equals(spawnItem)) {
            String world = "world";
            teleportPlayer(player, world, 9.5, 66.0, 19.5, 0, -10);
            event.setCancelled(true);

        } else if(item.equals(simptopiaItem)){
            String world = "simptopia";
            teleportPlayer(player, world, -45.0, 69.0, -37.5, -90, 0);
            event.setCancelled(true);

        } else if (item.equals(lolSimpsItem)){
            String world = "lolsimps";
            teleportPlayer(player, world, 327.0, 64.0, -1547.0, 90, -15);
            event.setCancelled(true);

        } else if(item.equals(snapshotItem)){
            String world = "snapshotsmp";
            teleportPlayer(player, world, 9.5, 66.0, 19.5, 0, -10);
            event.setCancelled(true);
        }
    }

    public void teleportPlayer(Player player, String world, Double x, Double y, Double z, float yaw, float pitch){
        Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
        player.sendMessage(Utils.formatMM(String.format("<green>Teleporting to %s...", friendlyWorld(world))));
        player.teleportAsync(loc);
    }

    public String friendlyWorld(String world){
        String destinationWorld = "";
        switch (world){
            case "world" -> {destinationWorld = "spawn";}
            case "simptopia" -> {destinationWorld = "SimptopiaSMP";}
            case "lolsimps" -> {destinationWorld = "lolsimpsSMP";}
            case "snapshotsmp" -> {destinationWorld = "The 1.17 Snapshot Server";}
        }
        return destinationWorld;
    }

    public boolean isSelector(Inventory inventory){
        boolean isSelector = true;
        if(!inventory.contains(spawnItem)) {
            isSelector = false;
        } else if(!inventory.contains(lolSimpsItem)){
            isSelector = false;
        } else if (!inventory.contains(snapshotItem)) {
            isSelector = false;
        } else if (!inventory.contains(simptopiaItem)){
            isSelector = false;
        }
        return isSelector;
    }
}