package de.phillip.spigot.lobbysystem.utils;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LocationUtil {

    private File file = new File("plugins/LobbySystem/locations.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void setLocation(String path, Object value){
        try {
            cfg.set(path, value);
            cfg.save(file);
        } catch (Exception e){
        }
    }

    public Location getLocation(String path){
        return cfg.getLocation(path);
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getCfg() {
        return cfg;
    }
}
