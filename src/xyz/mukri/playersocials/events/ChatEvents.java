package xyz.mukri.playersocials.events;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import xyz.mukri.playersocials.PlayerSocial;
import xyz.mukri.playersocials.utils.LevelSystem;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 7:16:56 PM 
 */

public class ChatEvents implements Listener {
	
	public PlayerSocial main;
	public Map<String, Long> cooldown = new HashMap<>();
	
	public ChatEvents(PlayerSocial main) {
		this.main = main;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		int cooldowntime = PlayerSocial.getInstance().cfgData.getConfig().getInt("Selections.Cooldown-Exp");
		
		if(cooldown.containsKey(p.getName())) {
			long left = ((cooldown.get(p.getName()) / 1000) + cooldowntime) - (System.currentTimeMillis() / 1000);
			
			if(left > 0) {
				//To do something
				return;
			}
			
		} else {
			cooldown.put(p.getName(), System.currentTimeMillis());
			LevelSystem.addExp(p);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
				
				@Override
				public void run() {
					if(cooldown.containsKey(p.getName())) {
						cooldown.remove(p.getName());
						}
					
				}
			});
		}
	}

}
