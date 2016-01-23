package com.Ufkillsh0t.tutorial.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Hello extends AbstractCommand {
	
	public Hello(){
		super("Greets the player!", "/tutorial hello", "hi");
		
	}

	@Override
	public boolean onCommand(Player p, String[] args) {
		p.sendMessage(ChatColor.GREEN + "Hello, " + p.getName());
		return true;
	}
	
}
