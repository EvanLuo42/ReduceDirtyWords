package com.github.evanluo42;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class ReduceDirtyWords extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[ReduceDirtyWords] The plugin has been loaded!");
        saveDefaultConfig();
        YamlConfiguration config = new YamlConfiguration();
        try{
            config.load(new File("./config.yml"));
        } catch(IOException | InvalidConfigurationException e){
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("[ReduceDirtyWords] The plugin has been closed!");
        saveConfig();
    }
}
