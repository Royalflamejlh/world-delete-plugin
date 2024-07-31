package net.xpvp.www.worlddeleteplugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;

public final class WorldDelete extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        File homeFolder = this.getServer().getWorldContainer();

        for (String worldName : config.getConfigurationSection("worlds-to-delete").getKeys(false)) {
            File worldFolder = new File(homeFolder, worldName);
            if (!worldFolder.exists()) {
                Bukkit.getLogger().log(Level.WARNING, "[WorldDelete] No world found with the name: " + worldName);
                continue;
            }
            Bukkit.getLogger().log(Level.INFO, "[WorldDelete] Deleting world data for: " + worldName);
            Map<String, Object> deleteSettings = config.getConfigurationSection("worlds-to-delete." + worldName).getValues(false);

            for (Map.Entry<String, Object> entry : deleteSettings.entrySet()) {
                String name = entry.getKey();
                boolean shouldDelete = Boolean.parseBoolean(entry.getValue().toString());
                if (shouldDelete) {
                    deleteFile(new File(worldFolder, name), worldName);
                }
            }
        }
    }

    private void deleteFile(File file, String worldName) {
        if (file.exists()) {
            try {
                FileUtils.forceDelete(file);
                Bukkit.getLogger().log(Level.INFO, "[WorldDelete] Deleted file/folder: " + file.getName() + " for world: " + worldName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            Bukkit.getLogger().log(Level.WARNING, "[WorldDelete] No file/folder found: " + file.getName() + " for world: " + worldName);
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().log(Level.INFO, "[WorldDelete] Shutting down...");
    }
}
