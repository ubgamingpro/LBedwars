package dev.cg5235.lbedwars

import dev.cg5235.lbedwars.commands.joinBWNPC
import dev.cg5235.lbedwars.commands.mainCommand
import dev.cg5235.lbedwars.commands.setSpawnCommand
import dev.cg5235.lbedwars.commands.spawnCommand
import dev.cg5235.lbedwars.events.SpawnBack
import org.bukkit.plugin.java.JavaPlugin


class LBedwars : JavaPlugin() {
    var spawnBackOnJoin: SpawnBack? = null
    override fun onEnable() {
        // Plugin startup logic
        logger.info("Loading Lopixel Bedwars...")
        server.pluginManager.registerEvents(SpawnBack(this), this)
        config.options().copyDefaults()
        saveDefaultConfig()
        spawnBackOnJoin = SpawnBack(this)
        getCommand("spawn").executor = spawnCommand(this)
        getCommand("setspawn").executor = setSpawnCommand(this)
        getCommand("bedwars").executor = mainCommand(this)
        getCommand("joinnpc").executor = joinBWNPC(this)
        logger.info("Loaded Lopixel Bedwars!)
    }

    override fun onDisable() {
        // Plugin shutdown logic
        println("Shutting down Lopixel Bedwars...")
    }
}
