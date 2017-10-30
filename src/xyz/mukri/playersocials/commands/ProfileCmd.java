package xyz.mukri.playersocials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 12:20:21 PM 
 */

public class ProfileCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String leabel,
			String[] args) {
		
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("profile")) {
			
		}
		
		return false;
	}
	
}
