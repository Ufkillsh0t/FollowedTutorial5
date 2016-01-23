package com.Ufkillsh0t.tutorial.utils;

import org.bukkit.ChatColor;

import com.Ufkillsh0t.tutorial.commands.AbstractCommand;
import com.Ufkillsh0t.tutorial.main.CommandHandler;

public class Menus {
	public static MenuMaker getTutorialCommand() {
		try {
			MenuMaker menu = new MenuMaker("Tutorial Commands", 5, ChatColor.GREEN);
			int i = 1;
			for (AbstractCommand command : CommandHandler.cmds) {
				menu.addEntry(ChatColor.YELLOW + " " + i + ChatColor.GRAY + command.getUsage() + ChatColor.YELLOW
						+ " - " + ChatColor.GRAY + command.getMessage());
				i++;
			}
			return menu;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
