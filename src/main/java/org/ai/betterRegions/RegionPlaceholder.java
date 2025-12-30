package org.ai.betterRegions;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RegionPlaceholder extends PlaceholderExpansion {

    private final BetterRegions plugin;

    public RegionPlaceholder(BetterRegions plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "bregions";
    }

    @Override
    public @NotNull String getAuthor() {
        return "AI";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) {
            return "";
        }

        if (params.equalsIgnoreCase("name")) {
            return getRegionName(player);
        }

        return null;
    }

    private String getRegionName(Player player) {
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = container.createQuery();
        ApplicableRegionSet set = query.getApplicableRegions(BukkitAdapter.adapt(player.getLocation()));

        for (ProtectedRegion region : set) {
            String configName = plugin.getConfig().getString("regions." + region.getId());
            if (configName != null) {
                return LegacyComponentSerializer.legacySection()
                        .serialize(LegacyComponentSerializer.legacyAmpersand().deserialize(configName));
            }
        }

        return LegacyComponentSerializer.legacySection().serialize(LegacyComponentSerializer.legacyAmpersand()
                .deserialize(plugin.getConfig().getString("default-name", "&7Wilderness")));
    }
}
