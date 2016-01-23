package com.Ufkillsh0t.tutorial.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Message extends AbstractCommand {

	public Message(){
		super("Allows the player to message another, ", "/tutorial message <player>", "msg");
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(Player player, String[] args) {
		if (args.length == 0) {
			player.sendMessage(ChatColor.RED + "You must enter a valid player who you wish to message");
			return true;
		}

		if (args.length == 1) {
			player.sendMessage(ChatColor.RED
					+ "You must enter valid message arguments when trying to message a player! " + super.getUsage());
			return true;
		}

		Player player2 = null;
		try {
			player2 = Bukkit.getPlayer(args[0]);
		} catch (Exception e) {

		}

		if (player2 == null) {
			player.sendMessage(ChatColor.RED + "The player you entered (" + ChatColor.YELLOW + args[0] + ChatColor.RED
					+ ") is invalid");
			return true;
		}
		
		if(player2.getName().equalsIgnoreCase(player.getName())){
			player.sendMessage(ChatColor.RED + "You can't send yourself a message!");
			return true;
		}

		StringBuilder message = new StringBuilder(); //Voor het maken van eens tring bestaande uit argumenten.
		
		for(int i = 0; i < args.length; i++){ //Loopt door alle argumenten heen na "message <Player>" argumenten en stopt die in de stringbuilder.
			message.append(args[i]).append(" ");
		}
		
		player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "You" + ChatColor.DARK_GRAY + "]"
				+ ChatColor.GRAY + "--->" + ChatColor.DARK_GRAY + "[" + ChatColor.RED + player2.getName()
				+ ChatColor.DARK_GRAY + "]" + ChatColor.RESET + message);

		player2.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + player.getName() + ChatColor.DARK_GRAY + "]"
				+ ChatColor.GRAY + "--->" + ChatColor.DARK_GRAY + "[" + ChatColor.RED + "You" 
				+ ChatColor.DARK_GRAY + "]" + ChatColor.RESET + message);
		
		return false;
	}

}
