package com.Ufkillsh0t.tutorial.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin {

	public static Tutorial tutorial;

	@Override
	public void onEnable() {
		tutorial = this;
		
		CommandHandler ch = new CommandHandler();
		ch.init();
		getCommand("tutorial").setExecutor(ch);
	}

	@Override
	public void onDisable() {

	}

	public static Tutorial getPlugin() {
		return tutorial;
	}

}
