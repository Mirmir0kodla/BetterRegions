# BetterRegions

![Java](https://img.shields.io/badge/Java-21-orange)
![Spigot](https://img.shields.io/badge/Platform-Paper%2FSpigot-lightgrey)
![License](https://img.shields.io/badge/License-MIT-blue)

**BetterRegions** is a lightweight Spigot/Paper plugin that acts as a bridge between **WorldGuard** and **PlaceholderAPI**. It allows you to display custom, formatted names for your WorldGuard regions using placeholders.

## 🌟 Features

- **Custom Region Names**: Map technical WorldGuard region IDs (e.g., `spawn_point_1`) to beautiful, formatted names (e.g., `&aSpawn &7Area`).
- **PlaceholderAPI Support**: Seamlessly integrate with any plugin that supports PAPI (scoreboards, tab lists, chat, etc.).
- **Lightweight**: Optimized to have minimal impact on server performance.

## 📦 Dependencies

To use BetterRegions, ensure you have the following plugins installed:

- [WorldGuard](https://dev.bukkit.org/projects/worldguard) (v7.0.0+)
- [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/)

## 🛠️ Installation

1. Download the `BetterRegions.jar` file.
2. Place it in your server's `plugins` folder.
3. Restart your server.
4. Edit the `config.yml` to set up your region names.
5. Run `/papi reload` and `/bregions reload` (if applicable) or restart.

## ⚙️ Configuration

The configuration is simple. Just map your WorldGuard region ID to the text you want to display.

`config.yml`:
```yaml
regions:
  # region_id: "Display Name"
  spawn: "&aSpawn &7Area"
  pvp: "&cPvP &7Arena"
  market: "&6Marketplace"
  wild: "&2Wilderness"
```

## 🧩 Placeholders

| Placeholder | Description |
| :--- | :--- |
| `%bregions_name%` | Displays the configured name of the region the player is currently standing in. |

## 🚀 Usage Types

- **Scoreboards**: Show "Current Zone: Spawn" on your sidebar.
- **Chat**: Add the region name as a prefix to player chat.
- **Tablist**: Display player location in the tab list.

---
*Developed with ❤️ using Paper API.*
