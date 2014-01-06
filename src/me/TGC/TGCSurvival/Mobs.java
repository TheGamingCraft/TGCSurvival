package me.TGC.TGCSurvival;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Mobs implements Listener {
	
	public static Economy econ = null;
	
	  private boolean setupEconomy()
	  {
	    if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null)
	    {
	      return false;
	    }
	    RegisteredServiceProvider rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
	    if (rsp == null)
	    {
	      return false;
	    }
	    econ = (Economy)rsp.getProvider();
	    return econ != null;
	  }

	@EventHandler
	  public void onEntityDeath(EntityDeathEvent e)
	  {
		
	  }
	
}
