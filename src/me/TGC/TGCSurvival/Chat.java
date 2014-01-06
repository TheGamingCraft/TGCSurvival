package me.TGC.TGCSurvival;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if (p.hasPermission("chat.traveller")) {
			e.setFormat(ChatColor.GRAY + "" + ChatColor.BOLD + "Traveller " + ChatColor.RESET + "%s" + ": " + "%s");
		} else if (p.hasPermission("chat.pesent")) {
			
			//they are in a group if they have the following perms
			
			e.setFormat(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Pesent " + ChatColor.RESET + "[Group] " + "%s" + ": " + "%s");
		} else if (p.hasPermission("chat.knight")) {
			e.setFormat(ChatColor.GREEN + "" + ChatColor.BOLD + "Knight " + ChatColor.RESET + "[Group] " + "%s" + ": " + "%s");
		} else if (p.hasPermission("chat.noble")) {
			e.setFormat(ChatColor.BLUE + "" + ChatColor.BOLD + "Noble " + ChatColor.RESET + "[Group] " + "%s" + ": " + "%s");
		} else if (p.hasPermission("chat.king")) {
			e.setFormat(ChatColor.GOLD + "" + ChatColor.BOLD + "King " + ChatColor.RESET + "[Group] " + "%s" + ": " + "%s");
		}
	}
}
