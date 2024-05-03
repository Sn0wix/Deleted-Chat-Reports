package net.sn0wix_;

import net.sn0wix_.linsteners.AsyncPlayerChatEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeletedChatReports extends JavaPlugin {
    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        getServer().getLogger().info("Enabling DeletedChatReports plugin!");

        //config
        config.options().copyDefaults(true);
        saveConfig();

        //listeners
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatEvent(this), this);
    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("Disabling DeletedChatReports plugin!");
    }
}
