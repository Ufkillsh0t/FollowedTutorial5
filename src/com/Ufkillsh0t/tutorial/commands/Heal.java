package com.Ufkillsh0t.tutorial.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Heal extends AbstractCommand {

	public Heal() {
		super("Allows the player to heal themselves and others", "/tutorial heal [player]", "h", "hl", "medic");
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(Player p, String[] args) {
		if (args.length == 0) {
			p.setFireTicks(0);
			p.setFoodLevel(20);
			p.setHealth(20D);

			p.sendMessage(ChatColor.GREEN + "You where healed");
			return true;
		} else {
			Player targetPlayer = null;
			try {
				targetPlayer = Bukkit.getPlayer(args[0]);
			} catch (Exception e) {
				
			}
			
			if(targetPlayer == null){
				p.sendMessage(ChatColor.RED + "That player doesn't exist or is offline!");
				return true;
			}
			
			targetPlayer.setFireTicks(0);
			targetPlayer.setFoodLevel(20);
			targetPlayer.setHealth(20D);

			if(targetPlayer.getName().equalsIgnoreCase(p.getName())){
				p.sendMessage(ChatColor.GREEN + "You where healed");
				return true;
			}
			
			targetPlayer.sendMessage(ChatColor.GREEN + "You have been healed by " + ChatColor.DARK_AQUA + p.getName()
					+ ChatColor.GREEN + "!");
			p.sendMessage(ChatColor.GREEN + "You healed " + ChatColor.DARK_AQUA + targetPlayer.getName()
			+ ChatColor.GREEN + "!");
			
			return true;
		}
	}

}
