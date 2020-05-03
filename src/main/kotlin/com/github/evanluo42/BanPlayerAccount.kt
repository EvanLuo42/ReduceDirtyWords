package com.github.evanluo42

import org.bukkit.BanList
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class BanPlayerAccount : Listener {
    @EventHandler
    fun ban(event: AsyncPlayerChatEvent) {
        if (muteAmount[event.player.name]!! > 2) {
            Bukkit.getBanList(BanList.Type.NAME).addBan(event.player.name, "口吐芬芳，屡教不改", null, null)
        }
    }

    companion object {
        val muteAmount = HashMap<String, Int>()
    }
}
