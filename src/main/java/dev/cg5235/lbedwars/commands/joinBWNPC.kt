package dev.cg5235.lbedwars.commands

import dev.cg5235.lbedwars.LBedwars
import net.citizensnpcs.api.CitizensAPI
import net.citizensnpcs.api.event.NPCClickEvent
import net.citizensnpcs.api.event.NPCRightClickEvent
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler

class joinBWNPC(private val plugin: LBedwars?) : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<String?>?): Boolean {
        if (sender is Player) {
            val p = sender as Player?
            if (args!!.size > 0 && args.size < 2) {
                if (args.get(0).equals("solo", ignoreCase = true)) {
                    val registry = CitizensAPI.getNPCRegistry()
                    val soloNPC = registry.createNPC(EntityType.PLAYER, "SOLO")
                    soloNPC.spawn(p!!.getLocation())
                } else {
                    p!!.sendMessage("Only solo mode is available now!")
                }
            } else if (args!!.size > 1) {
                p!!.sendMessage(ChatColor.RED.toString() + "Too much arguments!")
            } else if (args.size < 1) {
                p!!.sendMessage(ChatColor.RED.toString() + "Too less arguments!")
            }
        } else {
            println("Only players can use this comand!")
        }
        return true
    }

    @EventHandler
    fun onClickEvent(e: NPCClickEvent?) {
        if (e!!.getNPC().name.equals("SOLO", ignoreCase = true)) {
            val p = e!!.getClicker()
            p.sendMessage("thats it for today, see you in the next viddio, buh bhaiyya")
        }
    }

    @EventHandler
    fun onRightClickEvent(e: NPCRightClickEvent?) {
        if (e!!.getNPC().name.equals("SOLO", ignoreCase = true)) {
            val p = e!!.getClicker()
            p.sendMessage("thats it for today, see you in the next viddio, buh bhaiyya")
        }
    }
}