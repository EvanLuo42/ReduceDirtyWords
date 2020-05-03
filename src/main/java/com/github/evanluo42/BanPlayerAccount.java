package com.github.evanluo42;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;

public class BanPlayerAccount implements Listener {
    public static HashMap<String, Integer> muteAmount = new HashMap<>();
    @EventHandler
    public void ban(AsyncPlayerChatEvent event) {
        if(muteAmount.get(event.getPlayer().getName())>2) {
            Bukkit.getBanList(BanList.Type.NAME).addBan(event.getPlayer().getName(),"口吐芬芳，屡教不改",null,null);
        }
    }
}
