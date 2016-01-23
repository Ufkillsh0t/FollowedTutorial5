package com.Ufkillsh0t.tutorial.commands;

import org.bukkit.entity.Player;

public abstract class AbstractCommand {

	private String[] aliases;
	private String message;
	private String usage;
	
	public AbstractCommand(String message, String usage, String... aliases){
		this.message = message;
		this.usage = usage;
		this.aliases = aliases;
	}
	
	public abstract boolean onCommand(Player p, String[] args);
	
	public final String getMessage(){
		return message;
	}

	public final String getUsage(){
		return usage;
	}
	
	public final String[] getAliases(){
		return aliases;
	}
}
