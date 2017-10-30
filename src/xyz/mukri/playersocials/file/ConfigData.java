package xyz.mukri.playersocials.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import xyz.mukri.playersocials.PlayerSocial;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 7:08:27 PM 
 */

public class ConfigData {

	File file;
	FileConfiguration config;
	
	public ConfigData() {
		file = new File(PlayerSocial.getInstance().getDataFolder(), "config.yml");
		config = YamlConfiguration.loadConfiguration(file);
	}

	public FileConfiguration getConfig() {
		return config;
	}
	
	public boolean isExists() {
		return file.exists();
	}
	
	public void save() {
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createConfig() {
		try {
			
			if(!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			
			file.createNewFile();
			
			/*
			 * MSG:- 
			 * -- LEVEL UP (List)
			 * -- 
			 * 
			 * BOOLEAN:-
			 * -- COMMANDS GAIN EXP
			 * -- CHAT GAIN EXP
			 * -- JOIN GAIN EXP
			 * 
			 * INT:-
			 * -- COOLDOWN ON GETTING EXP (Players do command -> get exp -> cooldown -> repeat)
			 * 
			 * OTHERS:-
			 * -- LVL REACH DO COMMANDS
			 * 
			 * 
			 * 1 2 3 4 5 6 7 
			 * 
			 */
			
			List<String> lvlUpMsg = new ArrayList<String>();
			lvlUpMsg.add("-------------------------");
			lvlUpMsg.add("&cLevel up to {LEVEL}!");
			lvlUpMsg.add("-------------------------");
			
			//MSG
			config.set("Msg.Lebel-Up", lvlUpMsg);
			
			//BOOLEAN
			config.set("Selections.Command-Gain", true);
			config.set("Selections.Chat-Gain", true);
			config.set("Selections.Join-Gain", true);
			
			//INTEGER
			config.set("Selections.Cooldown-Exp", 5);
			
			
		} catch (Exception e) {
			
		}
	}
	
}


