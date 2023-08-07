package net.xpvp.www.worlddeleteplugin;

import org.apache.commons.lang3.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.java.JavaPlugin;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;

public final class World_delete_plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        File homeFolder = this.getServer().getWorldContainer();
        File worldFolder = new File(homeFolder, "world");
        if(!worldFolder.exists()){
            Bukkit.getLogger().log(Level.WARNING, "[world-delete-plugin] No world found to delete");
            return;
        }
        Bukkit.getLogger().log(Level.INFO, "[world-delete-plugin] Deleting world data");
        for (File file: Objects.requireNonNull(worldFolder.listFiles())) {
            if (!file.getName().equals("datapacks")) {
                try {
                    FileUtils.forceDelete(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
