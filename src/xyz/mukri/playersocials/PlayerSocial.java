package xyz.mukri.playersocials;

import org.bukkit.plugin.java.JavaPlugin;

import xyz.mukri.playersocials.commands.ProfileCmd;
import xyz.mukri.playersocials.events.CommandEvents;
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
		
		listen();
		commands();
	}
	
	public void onDisable() {
		
	}
	
	public void listen() {
		getServer().getPluginManager().registerEvents(new CommandEvents(this), this);
	}
	
	public void commands() {
		getCommand("profile").setExecutor(new ProfileCmd());
	}
	
	public static PlayerSocial getInstance() {
		return instance;
	}

}
