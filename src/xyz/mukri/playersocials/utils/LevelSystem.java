package xyz.mukri.playersocials.utils;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import xyz.mukri.playersocials.PlayerSocial;
import xyz.mukri.playersocials.file.PlayerData;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 6:58:51 PM 
 */

public class LevelSystem {
	
	public static void addExp(Player p) {
		PlayerData data = new PlayerData(p.getName(), p.getUniqueId().toString());
		
		if(data.isExists()) {
			Random r = new Random();
			
			int lvl = data.getLevelInt();
			int exp = data.getExpInt();
			int expRan = r.nextInt(10);
			
			data.setExpInt(exp + expRan);
			exp = exp + expRan;
			
			if(exp > (lvl * 20)) {
				//LEVEL UP
				data.setLevelInt(lvl + 1);
				
				for(String line : PlayerSocial.getInstance().cfgData.getConfig().getStringList("Msg.Lebel-Up")) {
					line = ChatColor.translateAlternateColorCodes('&', line);
					line.replace("{LEVEL}", String.valueOf(lvl + 1));
					
				}
			}
			
			data.save();
			
		} else {
			
		}
	}

}
