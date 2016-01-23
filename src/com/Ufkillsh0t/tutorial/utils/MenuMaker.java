package com.Ufkillsh0t.tutorial.utils;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.Ufkillsh0t.tutorial.exceptions.InvalidNumberException;

public class MenuMaker {

	private String displayName;
	private String headerLeft;
	private String headerRight;
	private String endLeft;
	private String endRight;
	private int perPage;
	private ChatColor chatColor;
	
	private ArrayList<String> entries = new ArrayList<String>();
	
	public MenuMaker(String displayName, int perPage, ChatColor chatColor) throws InvalidNumberException {
		this.displayName = displayName;
		this.perPage = perPage;
		this.chatColor = chatColor;
		this.headerLeft = "=======[";
		this.headerRight = "]=======";
		this.endLeft = "=======[";
		this.endRight = "]=======";
		
		if(perPage < 1){
			throw new InvalidNumberException("Number must be greater than 0.");
		}
	}
	
	public MenuMaker(String displayName, int perPage, ChatColor chatColor, String headerLeft, String headerRight, String endLeft, String endRight) throws InvalidNumberException {
		this.displayName = displayName;
		this.perPage = perPage;
		this.chatColor = chatColor;
		this.headerLeft = headerLeft;
		this.headerRight = headerRight;
		this.endLeft = endLeft;
		this.endRight = endRight;
		
		if(perPage < 1){
			throw new InvalidNumberException("Number must be greater than 0.");
		}
	}
	
	public void addEntry(String entry){
		entries.add(entry);
	}
	
	public int size(){
		return entries.size();
	}
	
	public void showPage(CommandSender cs, int page)throws InvalidNumberException {
		if( page < 1){
			throw new InvalidNumberException("Page must be greater than 0.");
		}
		int maxPages = (entries.size() / perPage) + 1;
		
		if(page > maxPages){
			throw new InvalidNumberException("Page number greater then max pages.");
		}
		
		int start = perPage * (page - 1);
		String pageDisplay = " (" + page + " / " + maxPages + ") ";
		String pageHeader = "  ";
		
		for(int i = 0; i < pageDisplay.length(); i++){
			pageHeader = pageHeader + " ";
		}
		
		cs.sendMessage(chatColor + headerLeft + ChatColor.RESET
				+ displayName + chatColor + pageHeader + headerRight);
		
		for(int i = 0; i < perPage; i++){
			int entry = i + start;
			if(entry >= entries.size()){
				break;
			}
			cs.sendMessage(entries.get(entry));
		}
		
		cs.sendMessage(chatColor + endLeft + ChatColor.RESET
				+ displayName + ChatColor.GRAY + pageDisplay + chatColor + endRight);
	}

}
