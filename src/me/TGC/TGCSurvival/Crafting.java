package me.TGC.TGCSurvival;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Crafting implements Listener  {
	
	/*/Items:
	 * Lightning Hammer = shoots lightning (cooldown)
	 * Fire Staff = shoots fireballs (cooldown)
	 * Dagger = shoots one arrow at people
	 * Lumberjack Axe = makes the entire tree fall down
	 * Flying Rod = Click to fly for 10s (1m cooldown)
	 * Ridable bow = (lose 1 heart every time)
	 */
	
    ItemStack dagger = new ItemStack(Material.ARROW, 1); {
    ItemMeta meta = dagger.getItemMeta();
    meta.setDisplayName(ChatColor.GOLD + "Dagger");
    dagger.setItemMeta(meta); }
    
    ItemStack fstaff = new ItemStack(Material.BLAZE_ROD, 1); {
    ItemMeta meta = fstaff.getItemMeta();
    meta.setDisplayName(ChatColor.GOLD + "Fire Staff");
    fstaff.setItemMeta(meta); }
    
    ItemStack lhammer = new ItemStack(Material.GOLD_AXE, 1); {
    ItemMeta meta = lhammer.getItemMeta();
    meta.setDisplayName(ChatColor.GOLD + "Lightning Hammer");
    lhammer.setItemMeta(meta); }
    
    ItemStack arrowtp = new ItemStack(Material.BOW, 1); {
    ItemMeta meta = arrowtp.getItemMeta();
    meta.setDisplayName(ChatColor.GOLD + "Arrow Rider" + ChatColor.RESET);
    meta.addEnchant(Enchantment.DURABILITY, 1, true); }
	
	    
	    @EventHandler
	    public void onInteract(PlayerInteractEvent event) {
	    	Player player = event.getPlayer();
			if(player.getInventory().getItemInHand().equals(lhammer)) {
				if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
					Block b = player.getTargetBlock(null, 10000);
					
					if (b == null) {
                        player.sendMessage(ChatColor.RED + "You aren't looking at a block!");
                        return;
					} else {
						Location loc = b.getLocation();
						loc.getWorld().strikeLightning(loc);
						player.playSound(loc, Sound.SUCCESSFUL_HIT, 1, 1);
					}
					}
				} else if(player.getInventory().getItemInHand().equals(fstaff)) {
					if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
						Fireball fb = player.getPlayer().launchProjectile(Fireball.class);
						fb.setIsIncendiary(false);
						fb.setYield(0F);
						
						}
					} else if(player.getInventory().getItemInHand().equals(dagger)) {
						if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
							player.getPlayer().launchProjectile(Arrow.class);
							}
						}
				}
}
