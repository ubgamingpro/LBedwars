package dev.cg5235.lbedwars.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

import dev.cg5235.lbedwars.LBedwars
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import dev.cg5235.lbedwars.events.SpawnBack
import dev.cg5235.lbedwars.commands.spawnCommand
import dev.cg5235.lbedwars.commands.setSpawnCommand
import dev.cg5235.lbedwars.commands.mainCommand
import dev.cg5235.lbedwars.commands.joinBWNPC

class setSpawnCommand(plugin: LBedwars?) : CommandExecutor {
    private val plugin: LBedwars?

    init {
        this.plugin = plugin
    }

    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<String?>?): Boolean {
        if (sender is Player) {
            val player = sender as Player?
            val loc = player!!.getLocation()
            plugin!!.getConfig().set("spawn.world", loc.world.name)
            plugin!!.getConfig().set("spawn.x", loc.x)
            plugin!!.getConfig().set("spawn.y", loc.y)
            plugin!!.getConfig().set("spawn.z", loc.z)
            plugin!!.getConfig().set("spawn.yaw", loc.yaw)
            plugin!!.getConfig().set("spawn.pitch", loc.pitch)
            plugin!!.saveConfig()
            player.sendMessage(ChatColor.YELLOW.toString() + "Set spawn to your current location!")
        } else {
            println(ChatColor.RED.toString() + "Only players can use this command!")
        }
        return true
    }
}