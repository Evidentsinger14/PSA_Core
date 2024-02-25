package dev.ev1dent.psacore.utilities;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager implements Listener {
    Utils Utils = new Utils();
    public Inventory worldSwitchGUI(Player player){
        Inventory gui = Bukkit.createInventory(player, 27, Utils.formatMM("<dark_purple>World Switcher"));
        gui.setItem(11, simptopiaItem());
        gui.setItem(13, lolSimpsItem());
        gui.setItem(15, snapshotItem());
        return gui;
    }

    public ItemStack simptopiaItem(){
        ItemStack item = new ItemStack(Material.PURPLE_WOOL);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Utils.formatMM("<dark_purple>Simptopia"));
        List<Component> lore = new ArrayList<>();
        lore.add(Utils.formatMM("<white>Retired Stream SMP for https://twitch.tv/kenna!"));
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack lolSimpsItem(){
        ItemStack item = new ItemStack(Material.CYAN_WOOL);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Utils.formatMM("<aqua>lolsimps SMP"));
        List<Component> lore = new ArrayList<>();
        lore.add(Utils.formatMM("<white>Retired friend SMP for Evident, kenna, jewely and Friends!"));
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack snapshotItem(){
        ItemStack item = new ItemStack(Material.BLUE_WOOL);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Utils.formatMM("<blue>1.17 Snapshot SMP"));
        List<Component> lore = new ArrayList<>();
        lore.add(Utils.formatMM("<white>1.17 snapshot smp server for Evidents Friends!"));
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @EventHandler
    public void onItemClick(InventoryClickEvent event){
        ItemStack item = event.getCurrentItem();
        if(item == null) return;
        if(item.equals(simptopiaItem())){
            Location loc = new Location(Bukkit.getWorld("simptopia"), -45, 69, -37.5, -90, 0);
            event.getWhoClicked().sendMessage(Utils.formatMM("<green>Teleporting to Simptopia World..."));
            event.getWhoClicked().teleportAsync(loc);
            event.setCancelled(true);


        } else if (item.equals(lolSimpsItem())){
            Location loc = new Location(Bukkit.getWorld("lolsimps"), 327, 64, -1547, 90, -15);
            event.getWhoClicked().sendMessage(Utils.formatMM("<green>Teleporting to lolsimps World..."));
            event.getWhoClicked().teleportAsync(loc);
            event.setCancelled(true);

        } else if(item.equals(snapshotItem())){
            Location loc = new Location(Bukkit.getWorld("snapshotsmp"), 1505, 64.5, 466, -180, 0);
            event.getWhoClicked().sendMessage(Utils.formatMM("<green>Teleporting to the 1.17 Snapshot World..."));
            event.getWhoClicked().teleportAsync(loc);
            event.setCancelled(true);
        }

    }

    public boolean isSelector(Inventory inventory){
        boolean isSelector = true;
        if(!inventory.contains(lolSimpsItem())){
            isSelector = false;
        } else if (!inventory.contains(snapshotItem())) {
            isSelector = false;
        } else if (!inventory.contains(simptopiaItem())){
            isSelector = false;
        }
        return isSelector;
    }
}
