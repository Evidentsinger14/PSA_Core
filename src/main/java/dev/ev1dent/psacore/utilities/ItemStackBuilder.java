package dev.ev1dent.psacore.utilities;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder {
    Utils Utils = new Utils();

    private Material material;
    private String displayName;
    private final List<String> lore;

    public ItemStackBuilder() {
        lore = new ArrayList<>();
    }

    public ItemStackBuilder withMaterial(Material material) {
        this.material = material;
        return this;
    }

    public ItemStackBuilder withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ItemStackBuilder addLoreLine(String line) {
        this.lore.add(line);
        return this;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.displayName(Utils.formatMM(displayName));
            meta.lore().add(Utils.formatMM(lore.toString()));
            itemStack.setItemMeta(meta);
        }
        return itemStack;
    }
}