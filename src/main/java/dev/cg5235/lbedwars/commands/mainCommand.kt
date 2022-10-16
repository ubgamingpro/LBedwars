package dev.cg5235.lbedwars.commands

import dev.cg5235.lbedwars.LBedwars
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class mainCommand(private val plugin: LBedwars?) : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<String?>?): Boolean {
        if (sender is Player) {
            val player = sender as Player?
            if (args!!.size > 0) {
                if (args!!.size == 1) {
                    if (args!!.get(0).equals("reload", ignoreCase = true)) {
                        plugin!!.reloadConfig()
                        player!!.sendMessage(ChatColor.YELLOW.toString() + "reloaded Bedwars!")
                    } else if (args!!.get(0).equals("help", ignoreCase = true)) {
                        player!!.sendMessage(ChatColor.DARK_AQUA.toString() + "[" + ChatColor.AQUA + "B" + ChatColor.GREEN + "W" + "] " + ChatColor.YELLOW + "Running Bedwars v1.0-SNAPSHOT!")
                        player!!.sendMessage(ChatColor.DARK_AQUA.toString() + "> " + ChatColor.GREEN + "/bedwars help " + ChatColor.WHITE + "- " + ChatColor.GRAY + "shows this help message")
                        player!!.sendMessage(ChatColor.DARK_AQUA.toString() + "> " + ChatColor.GREEN + "/bedwars reload " + ChatColor.WHITE + "- " + ChatColor.GRAY + "reloads the plugin")
                        player!!.sendMessage(ChatColor.DARK_AQUA.toString() + "> " + ChatColor.GREEN + "/setspawn " + ChatColor.WHITE + "- " + ChatColor.GRAY + "set the spawn to the location you are standing at")
                        player!!.sendMessage(ChatColor.DARK_AQUA.toString() + "> " + ChatColor.GREEN + "/spawn " + ChatColor.WHITE + "- " + ChatColor.GRAY + "teleports you to spawn")
                    }
                } else if (args.size == 2 || args.size > 1) {
                    player!!.sendMessage(ChatColor.DARK_AQUA.toString() + "[" + ChatColor.AQUA + "B" + ChatColor.GREEN + "W" + "] " + ChatColor.YELLOW + "Running Bedwars v1.0-SNAPSHOT!")
                    player!!.sendMessage(ChatColor.DARK_AQUA.toString() + "[" + ChatColor.AQUA + "B" + ChatColor.GREEN + "W" + "] " + ChatColor.YELLOW + "use " + ChatColor.GREEN + "/bedwars help " + ChatColor.YELLOW + "to view available commands!")
                }
            } else {
                player!!.sendMessage(ChatColor.DARK_AQUA.toString() + "[" + ChatColor.AQUA + "B" + ChatColor.GREEN + "W" + "] " + ChatColor.YELLOW + "Running Bedwars v1.0-SNAPSHOT!")
                player!!.sendMessage(ChatColor.DARK_AQUA.toString() + "[" + ChatColor.AQUA + "B" + ChatColor.GREEN + "W" + "] " + ChatColor.YELLOW + "use " + ChatColor.GREEN + "/bedwars help " + ChatColor.YELLOW + "to view available commands!")
            }
        } else {
            if (args!!.size > 0) {
                if (args!!.size == 1) {
                    if (args.get(0).equals("reload", ignoreCase = true)) {
                        plugin!!.reloadConfig()
                        println(ChatColor.YELLOW.toString() + "reloaded Bedwars!")
                    } else if (args.get(0).equals("help", ignoreCase = true)) {
                        println(ChatColor.DARK_AQUA.toString() + "[" + ChatColor.AQUA + "B" + ChatColor.GREEN + "W" + "] " + ChatColor.YELLOW + "Running Bedwars v1.0-SNAPSHOT!")
                        println(ChatColor.DARK_AQUA.toString() + "> " + ChatColor.GREEN + "/bedwars help " + ChatColor.WHITE + "- " + ChatColor.GRAY + "shows this help message")
                        println(ChatColor.DARK_AQUA.toString() + "> " + ChatColor.GREEN + "/bedwars reload " + ChatColor.WHITE + "- " + ChatColor.GRAY + "reloads the plugin")
                    }
                } else if (args.size == 2 || args.size > 1) {
                    println(ChatColor.DARK_AQUA.toString() + "[" + ChatColor.AQUA + "B" + ChatColor.GREEN + "W" + "] " + ChatColor.YELLOW + "Running Bedwars v1.0-SNAPSHOT!")
                    println(ChatColor.DARK_AQUA.toString() + "[" + ChatColor.AQUA + "B" + ChatColor.GREEN + "W" + "] " + ChatColor.YELLOW + "use " + ChatColor.GREEN + "/bedwars help " + ChatColor.YELLOW + "to view available commands!")
                }
            } else {
                println(ChatColor.DARK_AQUA.toString() + "[" + ChatColor.AQUA + "B" + ChatColor.GREEN + "W" + "] " + ChatColor.YELLOW + "Running Bedwars v1.0-SNAPSHOT!")
                println(ChatColor.DARK_AQUA.toString() + "[" + ChatColor.AQUA + "B" + ChatColor.GREEN + "W" + "] " + ChatColor.YELLOW + "use " + ChatColor.GREEN + "/bedwars help " + ChatColor.YELLOW + "to view available commands!")
            }
        }
        return true
    }
}