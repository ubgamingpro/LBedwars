package dev.cg5235.lbedwars.events

import dev.cg5235.lbedwars.LBedwars
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class SpawnBack(private val plugin: LBedwars?) : Listener {
    @EventHandler
    fun spawnBackToSpawn(event: PlayerJoinEvent?) {
        val player = event?.getPlayer() as Player
        val loc = Location(Bukkit.getWorld(plugin!!.getConfig().getString("spawn.world")),
                plugin!!.getConfig()!!.getDouble("spawn.x"),
                plugin!!.getConfig()!!.getInt("spawn.y")!!.toDouble(),
                plugin!!.getConfig()!!.getDouble("spawn.z"),
                plugin!!.getConfig()!!.getInt("spawn.yaw")!!.toFloat(),
                plugin!!.getConfig()!!.getInt("spawn.pitch")!!.toFloat())
        player.teleport(loc)
    }
}