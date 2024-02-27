package dev.ev1dent.psacore.utilities;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder {
    Utils Utils = new Utils();

    private Material material;
    private String displayName;
    private String loreLine;

    public ItemStackBuilder withMaterial(Material material) {
        this.material = material;
        return this;
    }

    public ItemStackBuilder withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ItemStackBuilder addLore(String line) {
        this.loreLine = line;
        return this;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.displayName(Utils.formatMM(displayName));
            List<Component> lore = new ArrayList<>();
            lore.add(Utils.formatMM(loreLine));
            meta.lore(lore);
            itemStack.setItemMeta(meta);
        }
        return itemStack;
    }
}