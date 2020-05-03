package com.github.evanluo42;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;

import static com.github.evanluo42.BanPlayerAccount.muteAmount;

public class DirtyWordWarning implements Listener {
    YamlConfiguration config = new YamlConfiguration();
    ConfigurationSection cs = config.getConfigurationSection("dirty_words");
    HashMap<String, Integer> dirtyWords = new HashMap<>();
    @EventHandler
    public void dirtyWordWarning(AsyncPlayerChatEvent event) {
        for(String keys : cs.getKeys(false)) {
            if(event.getMessage().contains((CharSequence) cs.get(keys))) {
                int amount=dirtyWords.get(event.getPlayer().getName());
                if(amount<3) {
                    int e = dirtyWords.get(event.getPlayer().getName());
                    dirtyWords.put(event.getPlayer().getName(), e + 1);
                    event.getPlayer().sendMessage("[ReduceDirtyWords] 不要说脏话!");
                } else {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"mute" + event.getPlayer().getName() + "1h");
                    dirtyWords.put(event.getPlayer().getName(), 0);
                    int d=muteAmount.get(event.getPlayer().getName());
                    muteAmount.put(event.getPlayer().getName(), d+1);
                    event.getPlayer().sendMessage("[ReduceDirtyWords] 你因为说脏话太多被禁言了!");
                }
            }
        }
    }
}
