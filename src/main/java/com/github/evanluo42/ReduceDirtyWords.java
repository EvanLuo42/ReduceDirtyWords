package com.github.evanluo42;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ReduceDirtyWords extends JavaPlugin {
    private static ReduceDirtyWords instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("[ReduceDirtyWords] The plugin has been loaded!");
        Bukkit.getPluginManager().registerEvents(new BanPlayerAccount(), this);
        Bukkit.getPluginManager().registerEvents(new DirtyWordWarning(), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("[ReduceDirtyWords] The plugin has been closed!");
        saveConfig();
    }

    public static ReduceDirtyWords getInstance() {
        return instance;
    }
}
