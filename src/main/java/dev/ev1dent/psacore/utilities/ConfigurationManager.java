package dev.ev1dent.psacore.utilities;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigurationManager {

    private final File file;
    private FileConfiguration fileConfiguration;

    public ConfigurationManager(Plugin plugin) {
        String fileName = "config.yml";
        this.file = new File(plugin.getDataFolder(), fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Bukkit.getLogger().warning(String.format("Unable to create config. \n%s", e.getMessage()));
            }
        }
        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public void reload() {
        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public void save() {
        try {
            this.fileConfiguration.save(file);
        } catch (IOException e) {
            Bukkit.getLogger().warning(String.format("Unable to save config. \n%s", e.getMessage()));
        }
    }

    public FileConfiguration getConfig() {
        return this.fileConfiguration;
    }

}