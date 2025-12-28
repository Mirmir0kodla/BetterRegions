package org.ai.betterRegions;

import org.bukkit.plugin.java.JavaPlugin;

public final class BetterRegions extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new RegionPlaceholder(this).register();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
