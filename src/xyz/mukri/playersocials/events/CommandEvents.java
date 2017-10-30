package xyz.mukri.playersocials.events;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import xyz.mukri.playersocials.PlayerSocial;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 9:02:54 AM 
 */

public class CommandEvents implements Listener {
	
	public PlayerSocial main;
	public Map<String, Long> cooldown = new HashMap<>();
	
	public CommandEvents(PlayerSocial main) {
		this.main = main;
	}
	
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		int cooldowntime = 5;
		
		if(cooldown.containsKey(p.getName())) {
			long left = ((cooldown.get(p.getName()) / 1000) + cooldowntime) - (System.currentTimeMillis() / 1000);
			
			if(left > 0) {
				
				return;
			}
			
		} else {
			cooldown.put(p.getName(), System.currentTimeMillis());
			
			
		}
	}

}
