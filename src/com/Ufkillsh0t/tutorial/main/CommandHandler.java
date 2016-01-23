package com.Ufkillsh0t.tutorial.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Ufkillsh0t.tutorial.commands.AbstractCommand;
import com.Ufkillsh0t.tutorial.commands.Heal;
import com.Ufkillsh0t.tutorial.commands.Hello;
import com.Ufkillsh0t.tutorial.commands.Message;
import com.Ufkillsh0t.tutorial.utils.MathUtil;
import com.Ufkillsh0t.tutorial.utils.MenuMaker;
import com.Ufkillsh0t.tutorial.utils.Menus;

public class CommandHandler implements CommandExecutor {

	public static ArrayList<AbstractCommand> cmds = new ArrayList<AbstractCommand>();
	
	public void init(){
		cmds.add(new Hello());
		cmds.add(new Message());
		cmds.add(new Heal());
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(!(cs instanceof Player)){
			cs.sendMessage(ChatColor.RED + "You must be a player to execute this command");
			return true;
		}
		
		Player p = (Player) cs;
		if(cmd.getName().equalsIgnoreCase("tutorial")){
			if(args.length == 0){
				MenuMaker mu = Menus.getTutorialCommand();
				try{
					mu.showPage(p, 1);
				}catch(Exception e){
					e.printStackTrace();
				}
				p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Info" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + "make sure to do /tutorial or /tut [page] to see the other pages!");
				return true;
			}
			
			if(args.length == 1 && MathUtil.isNumber(args[0])){
				MenuMaker mu = Menus.getTutorialCommand();
				try{
					mu.showPage(p, Integer.valueOf(args[0]));
				}catch(Exception e){
					p.sendMessage(ChatColor.RED + "You have entered an invalid page number! Which is less than 0 or greater than the max pages!");
				}
				return true;
			}
			
			AbstractCommand command = getCommand(args[0]);
			
			if(command == null){
				p.sendMessage(ChatColor.RED + "That command doesn't exist");
				return true;
			}
			
			Vector<String> a = new Vector<String>(Arrays.asList(args));
			a.remove(0);
			args = a.toArray(new String[a.size()]);
			
			if(command.onCommand(p, args)){
				return true;
			}else{
				p.sendMessage(ChatColor.RED + "The command you tried to execute didn't work please contact the admin!" );
				return false;
			}
		}
		
		
		return true;
	}

	private AbstractCommand getCommand(String string) {
		for(AbstractCommand command : cmds){
			if(command.getClass().getSimpleName().equalsIgnoreCase(string)){
				return command;
			}
			for(String alias : command.getAliases()){
				if(string.equalsIgnoreCase(alias)){
					return command;
				}
			}
		}
		return null;
	}
	
}
