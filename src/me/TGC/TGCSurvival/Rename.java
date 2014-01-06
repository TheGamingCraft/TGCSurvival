package me.TGC.TGCSurvival;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Rename implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("rename")) {
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("/rename <name>");
			} else {
				String msg = "";
				for (String entry : args){
					msg=msg+" "+entry;
				}
				msg=msg.substring(1);
				
				ItemStack hand = p.getItemInHand();
				if (hand!=null&&hand.getType()!=Material.AIR) {
					
					ItemMeta meta = hand.getItemMeta();
					
					meta.setDisplayName(msg);
					
					hand.setItemMeta(meta);
					
					p.updateInventory();
					p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "The item name has been set to " + ChatColor.YELLOW + "" + ChatColor.BOLD + msg + ChatColor.GREEN + "" + ChatColor.BOLD + "!");
					
				} else {
					p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Please hold a item!");
				}
			}
		}
		return true;
	}

	
	
}
