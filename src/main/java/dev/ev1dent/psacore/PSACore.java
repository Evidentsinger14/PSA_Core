package dev.ev1dent.psacore;

import dev.ev1dent.psacore.commands.CommandPSA;
import dev.ev1dent.psacore.commands.CommandWorlds;
import dev.ev1dent.psacore.events.InventoryCloseListener;
import dev.ev1dent.psacore.events.PlayerLoginListener;
import dev.ev1dent.psacore.utilities.InventoryManager;
import net.luckperms.api.LuckPerms;
import org.bukkit.plugin.java.JavaPlugin;

public final class PSACore extends JavaPlugin {
    public PSACore plugin;
    private LuckPerms luckPerms;

    @Override
    public void onEnable() {
        plugin = this;
        this.luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        registerEvents();
        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands(){
        this.getCommand("worlds").setExecutor(new CommandWorlds());
        this.getCommand("psa").setExecutor(new CommandPSA(this.luckPerms));
    }
    public void registerEvents(){
        this.getServer().getPluginManager().registerEvents(new InventoryManager(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerLoginListener(this), this);
        this.getServer().getPluginManager().registerEvents(new InventoryCloseListener(), this);
    }
}
