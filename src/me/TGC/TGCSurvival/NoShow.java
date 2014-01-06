package me.TGC.TGCSurvival;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class NoShow implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		if (p.getPlayerListName().equalsIgnoreCase("gamingod")) {
			p.setDisplayName(ChatColor.GOLD + "[Owner] " + p.getPlayerListName() + ChatColor.RESET);
		} else if (p.getPlayerListName().equalsIgnoreCase("OMGUFB")) {
			p.setDisplayName(ChatColor.GOLD + "[Owner] " + p.getPlayerListName() + ChatColor.RESET);
		} else if (p.getPlayerListName().equalsIgnoreCase("cowteal")) {
			p.setDisplayName(ChatColor.GOLD + "[Co-owner] " + ChatColor.DARK_RED + p.getPlayerListName() + ChatColor.RESET);
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
		}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if (e.getDeathMessage().contains("got finished off by")) {
			//[player] got finished off by [player] using [weapon]
			//%player% was defeated by %player% in a battle to the death using a %item%
			e.setDeathMessage(e.getDeathMessage().replace("got finished off by", "was defeated by"));
			e.setDeathMessage(e.getDeathMessage().replace("using", "in a battle to the death using"));
		} else if (e.getDeathMessage().contains("was slain by")) {
			//[player] was slain by [player] using [weapon]
			//%player% was defeated by %player% in a battle to the death using a %item%
			e.setDeathMessage(e.getDeathMessage().replace("was slain by", "was defeated by"));
			e.setDeathMessage(e.getDeathMessage().replace("using", "in a battle to the death using"));
		} else if (e.getDeathMessage().contains("was shot by")) {
			//[player] was shot by [player]
			//%player% was sniped by %player%
			e.setDeathMessage((e.getDeathMessage().replace("was shot by", "was sniped by")));
		} else if (e.getDeathMessage().contains("was killed by")) {
			//[player] was killed by [player] using magic
			//%player% was attacked upon by %player% with dangerous potions
			e.setDeathMessage(e.getDeathMessage().replace("was killed by", "was attacked upon by"));
			e.setDeathMessage((e.getDeathMessage().replace("using magic", "with dangerous potions")));
			}
		}
	}
