package com.github.evanluo42

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import java.util.*
import java.util.regex.Pattern

class DirtyWordWarning : Listener {
    val cs: List<String> = ReduceDirtyWords.getInstance().config.getStringList("dirty_words")
    val dirtyWords = HashMap<String, Int>()

    @EventHandler
    fun dirtyWordWarning(event: AsyncPlayerChatEvent) {

        val find = cs.parallelStream().anyMatch { s -> event.message.contains(Regex(s)) }

        var amount = dirtyWords[event.player.name]!!
        if (amount < 3) {
            dirtyWords[event.player.name]?.plus(1)
            event.player.sendMessage("[ReduceDirtyWords] 不要说脏话!")
        } else {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mute " + event.player.name + " 1h")
            dirtyWords[event.player.name] = 0
            val d = BanPlayerAccount.muteAmount[event.player.name]!!
            BanPlayerAccount.muteAmount[event.player.name]?.plus(1)
            event.player.sendMessage("[ReduceDirtyWords] 你因为说脏话太多被禁言了!")
        }
    }
}
