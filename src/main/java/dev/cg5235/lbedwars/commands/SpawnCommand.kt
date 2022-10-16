package dev.cg5235.lbedwars.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

import dev.cg5235.lbedwars.LBedwars
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import dev.cg5235.lbedwars.events.SpawnBack
import dev.cg5235.lbedwars.commands.spawnCommand
import dev.cg5235.lbedwars.commands.setSpawnCommand
import dev.cg5235.lbedwars.commands.mainCommand
import dev.cg5235.lbedwars.commands.joinBWNPC

class spawnCommand(plugin: LBedwars?) : CommandExecutor {
    private val plugin: LBedwars?

    init {
        this.plugin = plugin
    }

    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<String?>?): Boolean {
        if (sender is Player) {
            val player = sender as Player?
            val loc = Location(Bukkit.getWorld(plugin!!.getConfig().getString("spawn.world")),
                    plugin!!.getConfig().getDouble("spawn.x"),
                    plugin.getConfig().getInt("spawn.y").toDouble(),
                    plugin.getConfig().getDouble("spawn.z"),
                    plugin.getConfig().getInt("spawn.yaw").toFloat(),
                    plugin.getConfig().getInt("spawn.pitch").toFloat())
            player!!.teleport(loc)
            player!!.sendMessage(ChatColor.YELLOW.toString() + "Sent you to spawn!")
        } else {
            println(ChatColor.RED.toString() + "Only players can use this command!")
        }
        return true
    }
}