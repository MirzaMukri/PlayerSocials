package xyz.mukri.playersocials;

import org.bukkit.plugin.java.JavaPlugin;

import xyz.mukri.playersocials.file.ConfigData;


/**
 * CopyRighted by DoomGary / Mukri
 * Please do not edit or copy without permissions.
 * Made on: 10:52:42 AM 
 */

public class PlayerSocial extends JavaPlugin {
	
	public static PlayerSocial instance;
	public ConfigData cfgData;
	
	public void onEnable() {
		instance = this;
		cfgData = new ConfigData();
		
		if(!cfgData.isExists()) {
			cfgData.createConfig();
		}
	}
	
	public void onDisable() {
		
	}
	
	public static PlayerSocial getInstance() {
		return instance;
	}

}
