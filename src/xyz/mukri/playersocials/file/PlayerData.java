package xyz.mukri.playersocials.file;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import xyz.mukri.playersocials.PlayerSocial;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 10:57:44 AM 
 */

public class PlayerData {
	
	String uuid;
	String name;
	File file;
	FileConfiguration config;
	
	public PlayerData(String name, String uuid) {
		this.name = name;
		this.uuid = uuid;
		
		file = new File(PlayerSocial.getInstance().getDataFolder() + "/data/" + name + ".yml");
		config = YamlConfiguration.loadConfiguration(file);
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
	
	public void createPlayer(Player p) {
		try {
			
			if(!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			
			file.createNewFile();
			
			config.set("Name", p.getName());
			config.set("Level", 0);
			config.set("Exp", 0);
			config.set("Data.Commands", 0);
			config.set("Data.Chats", 0);
			config.set("Data.Join-Time", 0);
			config.set("Profile.NickName", "none");
			config.set("Profile.Twitter", "@none");
			config.set("Profile.Youtube", "none");
			config.set("Profile.Twitch", "none");
			config.set("Profile.Small-Desc", "none");
			
			save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getLevelInt() {
		return config.getInt("Level");
	}
	
	public int getExpInt() {
		return config.getInt("Exp");
	}

	public int getCommandsInt() {
		return config.getInt("Data.Commands");
	}
	
	public int getChatsInt() {
		return config.getInt("Data.Chats");
	}
	
	public int getJoinTimeInt() {
		return config.getInt("Data.Join-Time");
	}
	
	public void setLevelInt(int i) {
		config.set("Level", i);
	}
	
	public void setExpInt(int i) {
		config.set("Exp", i);
	}
	
	public void setCommandsInt(int i) {
		config.set("Data.Commands", i);
	}
	
	public void setChatsInt(int i) {
		config.set("Data.Chats", i);
	}
	
	public void setJoinTimeInt(int i) {
		config.set("Data.Join-Time", i);
	}
}
