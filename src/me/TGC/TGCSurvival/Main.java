package me.TGC.TGCSurvival;

import java.util.HashMap;
import java.util.Map;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	Map<String, Long> tpaCooldown = new HashMap<String, Long>();
	Map<String, String> currentRequest = new HashMap<String, String>();
	
	SettingsManager settings = SettingsManager.getInstance();
	
	public static Economy econ = null;
	
	//Enable

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		
        SettingsManager settings = SettingsManager.getInstance();
    	
        settings.setup(this);
		
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		
		hrecipe();
		brecipe();
		rrecipe();
		rerecipe();
		trecipe();
		flatrecipe();
		
        registerEvents(this, new Crafting(), new Chat(), new NoShow(), new Rename());
        getCommand("rename").setExecutor(new Rename());
	}
	
    private boolean setupEconomy() {
    if (getServer().getPluginManager().getPlugin("Vault") == null) {
        return false;
    }
    RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
    if (rsp == null) {
        return false;
    }
    econ = rsp.getProvider();
    return econ != null;
}
    
    //Crafting Recipies
	
	   private void hrecipe() {
	        ItemStack lhammer1 = new ItemStack(Material.GOLD_AXE, 1);
	        ItemMeta meta = lhammer1.getItemMeta();
	        meta.setDisplayName(ChatColor.GOLD + "Lightning Hammer" + ChatColor.RESET);
	        lhammer1.setItemMeta(meta);
	       
	        ShapedRecipe hrecipe = new ShapedRecipe(lhammer1);
	        hrecipe.shape(
	        				"## ",
	                        "#& ",
	                        " & ");
	        hrecipe.setIngredient('#', Material.GOLD_BLOCK);
	        hrecipe.setIngredient('&', Material.STICK);
	        Bukkit.getServer().addRecipe(hrecipe);

	}
	    
	    private void brecipe() {
	        ItemStack lhammer2 = new ItemStack(Material.BLAZE_ROD, 1);
	        ItemMeta meta = lhammer2.getItemMeta();
	        meta.setDisplayName(ChatColor.GOLD + "Fire Staff" + ChatColor.RESET);
	        lhammer2.setItemMeta(meta);
	       
	        ShapedRecipe brecipe = new ShapedRecipe(lhammer2);
	        brecipe.shape(
	        				" # ",
	                        " & ",
	                        " & ");
	        brecipe.setIngredient('#', Material.EYE_OF_ENDER);
	        brecipe.setIngredient('&', Material.BLAZE_ROD);
	        Bukkit.getServer().addRecipe(brecipe);

	}
	    
	    private void flatrecipe() {
	        ItemStack lhammer = new ItemStack(Material.BOW, 1);
	        ItemMeta meta = lhammer.getItemMeta();
	        meta.setDisplayName(ChatColor.GOLD + "Arrow Rider" + ChatColor.RESET);
	        meta.addEnchant(Enchantment.DURABILITY, 1, true);
	        lhammer.setItemMeta(meta);
	       
	        ShapedRecipe flatrecipe = new ShapedRecipe(lhammer);
	        flatrecipe.shape(
	        				" $&",
	                        "$ &",
	                        " $&");
	        flatrecipe.setIngredient('$', Material.ENDER_PEARL);   
	        flatrecipe.setIngredient('&', Material.STRING);
	        Bukkit.getServer().addRecipe(flatrecipe);

	}

	    
	    private void rrecipe() {
	        ItemStack lhammer3 = new ItemStack(Material.ARROW, 1);
	        ItemMeta meta = lhammer3.getItemMeta();
	        meta.setDisplayName(ChatColor.GOLD + "Dagger" + ChatColor.RESET);
	        lhammer3.setItemMeta(meta);
	       
	        ShapedRecipe rrecipe = new ShapedRecipe(lhammer3);
	        rrecipe.shape(
	        				" # ",
	                        " & ",
	                        " & ");
	        rrecipe.setIngredient('#', Material.ARROW);
	        rrecipe.setIngredient('&', Material.STICK);
	        Bukkit.getServer().addRecipe(rrecipe);

	}
	    
	    private void trecipe() {
	        ItemStack lhammer = new ItemStack(Material.STONE_AXE, 1);
	        ItemMeta meta = lhammer.getItemMeta();
	        meta.setDisplayName(ChatColor.GOLD + "LumberJack Axe" + ChatColor.RESET);
	        meta.addEnchant(Enchantment.DURABILITY, 2, true);
	        lhammer.setItemMeta(meta);
	       
	        ShapedRecipe trecipe = new ShapedRecipe(lhammer);
	        trecipe.shape(
	        				"## ",
	                        "#& ",
	                        " & ");
	        trecipe.setIngredient('#', Material.IRON_BLOCK);
	        trecipe.setIngredient('&', Material.STICK);
	        Bukkit.getServer().addRecipe(trecipe);

	}
	    
	    private void rerecipe() {
	        ItemStack lhammer = new ItemStack(Material.STICK, 1);
	        ItemMeta meta = lhammer.getItemMeta();
	        meta.setDisplayName(ChatColor.GOLD + "Fly Rod" + ChatColor.RESET);
	        meta.addEnchant(Enchantment.DURABILITY, 1, true);
	        lhammer.setItemMeta(meta);
	       
	        ShapedRecipe rerecipe = new ShapedRecipe(lhammer);
	        rerecipe.shape(
	        				"$#$",
	                        " & ",
	                        " * ");
	        rerecipe.setIngredient('#', Material.FEATHER);
	        rerecipe.setIngredient('$', Material.ENDER_PEARL);   
	        rerecipe.setIngredient('&', Material.STICK);
	        rerecipe.setIngredient('*', Material.BLAZE_ROD);
	        Bukkit.getServer().addRecipe(rerecipe);

	}

	//Multiple Class Support
	    
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
    
    //Commands
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (!(sender instanceof Player)) {
			
		    if (cmd.getName().equalsIgnoreCase("shout")) {
	            if (args.length == 0) {
	                    sender.sendMessage(ChatColor.RED + "Please specify a message!");
	                    return true;
	            }
	            StringBuilder str = new StringBuilder();
	            for (int i = 0; i < args.length; i++) {
	                    str.append(args[i] + " ");
	            }
	            String motd = str.toString();
	            Bukkit.getServer().broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Alert" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET + motd);
	            return true;
	    }
		    
			sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "This command is for players only!");
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("s")) {
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Type \"/s help\" for help.");
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("help")) {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Survival Help");
					p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "Traveller Commands:");
					p.sendMessage(ChatColor.GRAY + "/s help - Shows the survival help info");
					p.sendMessage(ChatColor.GRAY + "/s create <group> - Create a new group");
					p.sendMessage(ChatColor.GRAY + "/s join <group> - Request to join a group");
					p.sendMessage(ChatColor.GRAY + "/s info <player> - Request to join a group");
					p.sendMessage(ChatColor.GRAY + "/s top - Shows you the top 10 most powerful groups");
					p.sendMessage(ChatColor.GRAY + "/tpa <player> - Request to teleport to a player");
					p.sendMessage(ChatColor.GRAY + "/tpaccept - Accept a tp request");
					p.sendMessage(ChatColor.GRAY + "/tpdeny - Deny a tp request");
					p.sendMessage("");
					p.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Pesent Commands:");
					p.sendMessage(ChatColor.GRAY + "/s leave - Leave the group you are currently in");
					p.sendMessage(ChatColor.GRAY + "/s spawn - Teleport to your group's spawn");
					p.sendMessage(ChatColor.GRAY + "/sethome - Sets your home");
					p.sendMessage(ChatColor.GRAY + "/home - Takes you to your home");
					p.sendMessage(ChatColor.GRAY + "/delhome - Deletes your home");
					p.sendMessage("");
					p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Knight Commands:");
					p.sendMessage(ChatColor.GRAY + "/s kit <kit> - Gives you kits");
					p.sendMessage(ChatColor.GRAY + "/s world <world> - Takes you to a world");
					p.sendMessage("");
					p.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Noble Commands:");
					p.sendMessage(ChatColor.GRAY + "/s invite <player> - invite a player to the group");
					p.sendMessage(ChatColor.GRAY + "/s kick <player> - kicks a player from the group");
					p.sendMessage(ChatColor.GRAY + "/s claim <public | resident> - claims the chunk as public or resident");
					p.sendMessage("");
					p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "King Commands:");
					p.sendMessage(ChatColor.GRAY + "/s remove - removes the group forever (a long time)");
					p.sendMessage(ChatColor.GRAY + "/s ally <group> - flag another group as a ally");
					p.sendMessage(ChatColor.GRAY + "/s foe <group> - flag another group as a foe");
					p.sendMessage(ChatColor.GRAY + "/s settings <fire_spread | mob_spawning | mob_griefing | tnt_block_damage | housing_plot or public_plots> - Sets the chunk settings");
					p.sendMessage(ChatColor.GRAY + "/s tax <amount | off> - Sets the tax features");
					p.sendMessage(ChatColor.GRAY + "/s setspawn - Sets the land spawn");
					if (p.hasPermission("chat.traveller")) {
						p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Your rank is: " + ChatColor.GRAY + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Traveller");
					} else if (p.hasPermission("chat.pesent")) {
						p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Your rank is: " + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Pesent");
					} else if (p.hasPermission("chat.knight")) {
						p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Your rank is: " + ChatColor.GREEN + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Knight");
					} else if (p.hasPermission("chat.noble")) {
						p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Your rank is: " + ChatColor.BLUE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Noble");
					} else {
						p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Your rank is: " + ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "King");
					}
					p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Scroll up for full help command list");
				} else if (args[0].equalsIgnoreCase("create")) {
				p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "/s create " + ChatColor.RED + "" + ChatColor.BOLD + "<group>");
				} else if (args[0].equalsIgnoreCase("join")) {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "/s join " + ChatColor.RED + "" + ChatColor.BOLD + "<group>");
				} else if (args[0].equalsIgnoreCase("info")) {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "/s info " + ChatColor.RED + "" + ChatColor.BOLD + "<player>");
				} else if (args[0].equalsIgnoreCase("top")) {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Here are the top groups");
					p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "1. " + ChatColor.GREEN + "" + ChatColor.BOLD + "Ambitia");
					p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "2. " + ChatColor.GREEN + "" + ChatColor.BOLD + "BrecertPlays");
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "3. " + ChatColor.GREEN + "" + ChatColor.BOLD + "SniperClan");
					p.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "4. " + ChatColor.GREEN + "" + ChatColor.BOLD + "OGMudBone");
					p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "5. " + ChatColor.GREEN + "" + ChatColor.BOLD + "NoobsTown");
					p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "6. " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "TeamCrafted");
					p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "7. " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "TeamMVG");
					p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "8. " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MLPFTW");
					p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "9. " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Averad");
					p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "10. " + ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "PepsiCraft");
				} else if (args[0].equalsIgnoreCase("leave")) {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "You have left your group, you are now a " + ChatColor.GRAY + "" + ChatColor.BOLD + "Traveller");
				} else if (args[0].equalsIgnoreCase("spawn")) {
					p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "DONT MOVE " + ChatColor.YELLOW + "" + ChatColor.BOLD + "for 5 seconds or the teleport will be canceled.");
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "You have moved, teleportation " + ChatColor.RED + "" + ChatColor.BOLD + "canceled!");
					p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Teleported you to spawn!");
				} else if (args[0].equalsIgnoreCase("kit")) {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "/s kit " + ChatColor.RED + "" + ChatColor.BOLD + "<kit>");
				} else if (args[0].equalsIgnoreCase("world")) {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "/s world " + ChatColor.RED + "" + ChatColor.BOLD + "<world>");
				} else if (args[0].equalsIgnoreCase("invite")) {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "/s invite " + ChatColor.RED + "" + ChatColor.BOLD + "<player>");
				} else if (args[0].equalsIgnoreCase("kick")) {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "/s kick " + ChatColor.RED + "" + ChatColor.BOLD + "<player>");
				} else if (args[0].equalsIgnoreCase("claim")) {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "/s claim " + ChatColor.RED + "" + ChatColor.BOLD + "<public | resident>");
				}
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("create")) {
					if (p.hasPermission("chat.traveller")) {
						if (args[1].length() > 17) {
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "The group name must be 16 letters or less, sorry for the inconvinience :(");
						} else {
									p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Creating group " + args[1] + "...");
									p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Sucessfuly" + ChatColor.YELLOW + "" + ChatColor.BOLD + " created group " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1] + ChatColor.YELLOW + "" + ChatColor.BOLD +"!");
									p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "the name " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1] + ChatColor.YELLOW + "" + ChatColor.BOLD +" is already taken :(");
						}
					} else {
						if (p.hasPermission("chat.king")) {
							p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You already own a group!");
						} else {
							p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You are already in a group!");
						}
					}
				} else if (args[0].equalsIgnoreCase("join")) {
					if (p.hasPermission("chat.traveller")) {
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Requesting to join group " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1] + ChatColor.YELLOW + "" + ChatColor.BOLD + "!");
						p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Congradulations " + ChatColor.GOLD + "" + ChatColor.BOLD + p.getDisplayName() + ChatColor.YELLOW + "" + ChatColor.BOLD + ", you are now part of the group " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1] + ChatColor.YELLOW + "" + ChatColor.BOLD +"!");
						p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "could not find group " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1] + ChatColor.YELLOW + "" + ChatColor.BOLD +"!");
		} else {
			if (p.hasPermission("chat.king")) {
				p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You are already in a group!");
			} else {
				p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You are already in a group!");
			}
		}
	} else if (args[0].equalsIgnoreCase("info")) {
		p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Here is the info for: " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1]);
		p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Group: " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "NONE");
		p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Rank: " + ChatColor.GRAY + "" + ChatColor.BOLD + "Traveller");
		p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Kills: " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "NONE");
		p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Money: " + ChatColor.GOLD + "" + ChatColor.BOLD + econ.getBalance(args[1]));
					
				} else if (args[0].equalsIgnoreCase("kit")) {
					if (args[1].equalsIgnoreCase("list")) {
						p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Here is a list of kits:");
					} else {
						p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "could not find the kit " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1] + ChatColor.YELLOW + "" + ChatColor.BOLD + ", type " + ChatColor.GOLD + "" + ChatColor.BOLD + "\"/s kit list\"" + ChatColor.YELLOW + "" + ChatColor.BOLD + " for a list of kits");
					}
				} else if (args[0].equalsIgnoreCase("world")) {
					if (args[1].equalsIgnoreCase("list")) {
						p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Here is a list of worlds:");
						p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Main");
						p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Market");
						p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Mining");
						p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Nether");
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "End");
					} else {
						p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "could not find the world " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1] + ChatColor.YELLOW + "" + ChatColor.BOLD + ", type " + ChatColor.GOLD + "" + ChatColor.BOLD + "\"/s world list\"" + ChatColor.YELLOW + "" + ChatColor.BOLD + " for a list of worlds");
					}
				} else if (args[0].equalsIgnoreCase("invite")) {
					Player player = Bukkit.getPlayerExact(args[1]);
					
					if (args[1].equalsIgnoreCase(sender.getName())) {
						sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You cannot send an invite to yourself");
					} else {
					if (player != null) {
					player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "You have been invited to a group by " + ChatColor.GOLD + "" + ChatColor.BOLD + sender.getName() + ChatColor.YELLOW + "" + ChatColor.BOLD + ", to accept type " + ChatColor.GOLD + "" + ChatColor.BOLD + "\"/s join <group>\"");
					sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Sent a request to " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1]);
					sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Sent a request to " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1]);
					} else {
						sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "could not find the player " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1] + ChatColor.YELLOW + "" + ChatColor.BOLD + ", are they on the server?");
						}
					}
				} else if (args[0].equalsIgnoreCase("kick")) {
					Player player = Bukkit.getPlayerExact(args[1]);
					if (args[1].equalsIgnoreCase(sender.getName())) {
						sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "I thing you have the wrong command, try " + ChatColor.GOLD + "" + ChatColor.BOLD + "\"/s leave\"");
					} else {
						
						if (player != null) {
							if (player.hasPermission("chat.king")) {
								sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You cannot kick the king!");
							} else if (player.hasPermission("chat.noble")) {
								sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You cannot kick someone the same rank as you!");
							} else {
							player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "You have been kick from your group, you are once again a " + ChatColor.GRAY + "" + ChatColor.BOLD + "Traveller");
							sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Kicked " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1] + ChatColor.GREEN + "" + ChatColor.BOLD + " from the group, May they do well on their own");
							}
						} else {
								sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Kicked " + ChatColor.GOLD + "" + ChatColor.BOLD + args[1] + ChatColor.GREEN + "" + ChatColor.BOLD + " from the group, May they do well on their own");
								sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + args[1] + " is not in your group!");
						}
					}
				} else if (args[0].equalsIgnoreCase("claim")) {
					if (args[1].equalsIgnoreCase("public")) {
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Region claimed as " + ChatColor.GOLD + "" + ChatColor.BOLD + "public");
						p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, that region is invalid!");
					} else if (args[1].equalsIgnoreCase("resident")) {
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Region claimed as " + ChatColor.GOLD + "" + ChatColor.BOLD + "resident");
						p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, that region is invalid!");
					} else {
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "/s claim <" + ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.BOLD + "public " + ChatColor.YELLOW + "" + ChatColor.BOLD + "| " + ChatColor.RED + "" + ChatColor.BOLD + "resident" + ChatColor.YELLOW + "" + ChatColor.BOLD + ">");
					}
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("survival")) {
			
		}
		
		if (cmd.getName().equalsIgnoreCase("head")) {
			Player p = (Player) sender;
			
			if (p.getItemInHand().getType() == Material.SKULL_ITEM) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "/head <name>");
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("list")) {
						p.sendMessage("skeleton");
						p.sendMessage("wither");
						p.sendMessage("zombie");
						p.sendMessage("creeper");
						p.sendMessage("player");
					} else if (args[0].equalsIgnoreCase("skeleton")) {
						ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.SKELETON.ordinal());
						p.getInventory().setItemInHand(skull);
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "The head your are holding has been set to a " + ChatColor.GOLD + "" + ChatColor.BOLD + "skeleton head");
					} else if (args[0].equalsIgnoreCase("wither")) {
						ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.WITHER.ordinal());
						p.getInventory().setItemInHand(skull);
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "The head your are holding has been set to a " + ChatColor.GOLD + "" + ChatColor.BOLD + "wither head");
					} else if (args[0].equalsIgnoreCase("creeper")) {
						ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.CREEPER.ordinal());
						p.getInventory().setItemInHand(skull);
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "The head your are holding has been set to a " + ChatColor.GOLD + "" + ChatColor.BOLD + "creeper head");
					} else if (args[0].equalsIgnoreCase("zombie")) {
						ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.ZOMBIE.ordinal());
						p.getInventory().setItemInHand(skull);
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "The head your are holding has been set to a " + ChatColor.GOLD + "" + ChatColor.BOLD + "zombie head");
					} else if (args[0].equalsIgnoreCase("player")) {
						ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
						p.getInventory().setItemInHand(skull);
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "The head your are holding has been set to a " + ChatColor.GOLD + "" + ChatColor.BOLD + "player head");
					} else {
                ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
                
                SkullMeta meta = (SkullMeta) skull.getItemMeta();
                meta.setOwner(args[0]);
                meta.setDisplayName(ChatColor.AQUA + args[0] + "'s Head");
                skull.setItemMeta(meta);
                
                p.getInventory().setItemInHand(skull);
                p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "The head your are holding has been set to a " + ChatColor.GOLD + "" + ChatColor.BOLD + args[0] + "'s head");
					}
				} else {
					p.sendMessage(ChatColor.RED + "/head <name>");
				}
			} else {
				p.sendMessage("You must be holding a head/skull in your hand");
			}
		}
		
	    if (cmd.getName().equalsIgnoreCase("shout")) {
            if (args.length == 0) {
                    sender.sendMessage(ChatColor.RED + "Please specify a message!");
                    return true;
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                    str.append(args[i] + " ");
            }
            String motd = str.toString();
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Alert" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET + motd);
            return true;
    }
		
		if (cmd.getName().equalsIgnoreCase("tpa")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (p.hasPermission("tpa.overridecooldown")) {
					
				} else {
					int cooldown = 5;
					if (tpaCooldown.containsKey(p.getName())) {
						long diff = (System.currentTimeMillis() - tpaCooldown.get(sender.getName())) / 1000;
						if (diff < cooldown) {
							p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "You must wait " + ChatColor.GOLD + "" + ChatColor.BOLD + cooldown + ChatColor.YELLOW + "" + ChatColor.BOLD + " seconds in between teleport requests!");
							return false;
						}
					}
				}
				
				if (args.length > 0) {
					final Player target = getServer().getPlayer(args[0]);
					long keepAlive = 30 * 20;
					
					if (target == null) {
						sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "could not find player " + ChatColor.GOLD + "" + ChatColor.BOLD + args[0] + ChatColor.YELLOW + "" + ChatColor.BOLD + ", are they on the server?");
						return false;
					}
					
					if (target == p) {
						sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Hmm, looks like you are already here!");
						return false;
					}
					
					sendRequest(p, target);
					
					getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run() {
							killRequest(target.getName());
						}
					}, keepAlive);
					
					tpaCooldown.put(p.getName(), System.currentTimeMillis());
				} else {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "/tpa " + ChatColor.RED + "" + ChatColor.BOLD + "<player>");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Error: The console can't teleport to people, silly!");
				return false;
			}
			return true;
			}
		
		if (cmd.getName().equalsIgnoreCase("sethome")) {
			Player p = (Player) sender;
			if (args.length == 0) {
            settings.getData().set(p.getName() + ".home.world", p.getLocation().getWorld().getName());
            settings.getData().set(p.getName() + ".home.x", p.getLocation().getX());
            settings.getData().set(p.getName() + ".home.y", p.getLocation().getY());
            settings.getData().set(p.getName() + ".home.z", p.getLocation().getZ());
            settings.saveData();
			p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You have succesfully set your home!");
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("1")) {
					if (p.hasPermission("sethome.1")) {
			            settings.getData().set(p.getName() + ".home.world", p.getLocation().getWorld().getName());
			            settings.getData().set(p.getName() + ".home.x", p.getLocation().getX());
			            settings.getData().set(p.getName() + ".home.y", p.getLocation().getY());
			            settings.getData().set(p.getName() + ".home.z", p.getLocation().getZ());
			            settings.saveData();
						p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You have succesfully set your home!");
						} else {
						p.sendMessage("no perm sethome 1");
					}
				} else if (args[0].equalsIgnoreCase("2")) {
					if (p.hasPermission("sethome.2")) {
			            settings.getData().set(p.getName() + ".home.2.world", p.getLocation().getWorld().getName());
			            settings.getData().set(p.getName() + ".home.2.x", p.getLocation().getX());
			            settings.getData().set(p.getName() + ".home.2.y", p.getLocation().getY());
			            settings.getData().set(p.getName() + ".home.2.z", p.getLocation().getZ());
			            settings.saveData();
						p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You have succesfully set your second home!");
						} else {
							p.sendMessage("no perm sethome 2");
					}
				} else if (args[0].equalsIgnoreCase("3")) {
					if (p.hasPermission("sethome.3")) {
			            settings.getData().set(p.getName() + ".home.3.world", p.getLocation().getWorld().getName());
			            settings.getData().set(p.getName() + ".home.3.x", p.getLocation().getX());
			            settings.getData().set(p.getName() + ".home.3.y", p.getLocation().getY());
			            settings.getData().set(p.getName() + ".home.3.z", p.getLocation().getZ());
			            settings.saveData();
						p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You have succesfully set your third home!");
						} else {
							p.sendMessage("no perm sethome 3");
					}
				} else {
					p.sendMessage("/sethome <1 | 2 | 3>");
				}
			} else {
				p.sendMessage("/sethome <1 | 2 | 3>");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("home")) {
			if (args.length == 0) {
			Player p = (Player) sender;
			if ((settings.getData().isSet(p.getName() + ".home.world"))) {
                World w = Bukkit.getServer().getWorld(settings.getData().getString(p.getName() + ".home.world"));
                double x = settings.getData().getDouble(p.getName() + ".home.x");
                double y = settings.getData().getDouble(p.getName() + ".home.y");
                double z = settings.getData().getDouble(p.getName() + ".home.z");
                p.teleport(new Location(w, x, y, z));
            p.teleport(new Location(w, x, y, z));
            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Teleported you to your home!");
				} else {
					p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "You do not have a home, set one with " + ChatColor.GOLD + "" + ChatColor.BOLD + "\"/sethome\"");
					}
				} else {
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("1")) {
							Player p = (Player) sender;
							if ((settings.getData().isSet(p.getName() + ".home.world"))) {
				                World w = Bukkit.getServer().getWorld(settings.getData().getString(p.getName() + ".home.world"));
				                double x = settings.getData().getDouble(p.getName() + ".home.x");
				                double y = settings.getData().getDouble(p.getName() + ".home.y");
				                double z = settings.getData().getDouble(p.getName() + ".home.z");
				                p.teleport(new Location(w, x, y, z));
				            p.teleport(new Location(w, x, y, z));
				            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Teleported you to your home!");
								} else {
									p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "You do not have a home, set one with " + ChatColor.GOLD + "" + ChatColor.BOLD + "\"/sethome 1\"");
									}
								} else if (args[0].equalsIgnoreCase("2")) {
							Player p = (Player) sender;
							if (p.hasPermission("home.2")) {
							if ((settings.getData().isSet(p.getName() + ".home.2"))) {
				                World w = Bukkit.getServer().getWorld(settings.getData().getString(p.getName() + ".home.2.world"));
				                double x = settings.getData().getDouble(p.getName() + ".home.2.x");
				                double y = settings.getData().getDouble(p.getName() + ".home.2.y");
				                double z = settings.getData().getDouble(p.getName() + ".home.2.z");
				                p.teleport(new Location(w, x, y, z));
				            p.teleport(new Location(w, x, y, z));
				            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Teleported you to your home!");
								} else {
									p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "You do not have a home, set one with " + ChatColor.GOLD + "" + ChatColor.BOLD + "\"/sethome 2\"");
									}
								
							} else {
								p.sendMessage("no perm for 2");
							}
						} else if (args[0].equalsIgnoreCase("3")) {
							Player p = (Player) sender;
							if (p.hasPermission("home.3")) {
							//TODO home 3
							if ((settings.getData().isSet(p.getName() + ".home.3"))) {
			                World w = Bukkit.getServer().getWorld(settings.getData().getString(p.getName() + ".home.2.world"));
			                double x = settings.getData().getDouble(p.getName() + ".home.3.x");
			                double y = settings.getData().getDouble(p.getName() + ".home.3.y");
			                double z = settings.getData().getDouble(p.getName() + ".home.3.z");
			                p.teleport(new Location(w, x, y, z));
			            p.teleport(new Location(w, x, y, z));
			            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Teleported you to your home!");
							} else {
								p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "You do not have a home, set one with " + ChatColor.GOLD + "" + ChatColor.BOLD + "\"/sethome 3\"");
								}
							
							} else {
								p.sendMessage("no perm for 3");
							}
						} else {
							Player p = (Player) sender;
							p.sendMessage("home 1, 2, or 3");
						}
					} else {
					Player p = (Player) sender;
					p.sendMessage("/home <1 | 2 | 3>");
					}
				}
			}
		
		if (cmd.getName().equalsIgnoreCase("tpaccept")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (currentRequest.containsKey(p.getName())) {
					
					Player heIsGoingOutOnADate = getServer().getPlayer(currentRequest.get(p.getName()));
					currentRequest.remove(p.getName());
					
					if (!(heIsGoingOutOnADate == null)) {
						heIsGoingOutOnADate.teleport(p);
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Teleporting...");
						heIsGoingOutOnADate.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Teleporting...");
					} else {
						sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "I can't find that player anymore, did they leave?");
						return false;
					}
				} else {
					sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "It doesn't look like you got a request from that person");
					return false;
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Error: The console can't accept teleport requests, silly!");
				return false;
			}
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("tpdeny")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (currentRequest.containsKey(p.getName())) {
					Player poorRejectedGuy = getServer().getPlayer(currentRequest.get(p.getName()));
					currentRequest.remove(p.getName());
					
					if (!(poorRejectedGuy == null)) {
						poorRejectedGuy.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "your tpa request has been denied :(");
						p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "You denied " + ChatColor.GOLD + "" + ChatColor.BOLD + poorRejectedGuy.getName());
						return true;
					}
				} else {
					sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Sorry, " + ChatColor.YELLOW + "" + ChatColor.BOLD + "I can't find that person anymore");
					return false;
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Error: The console can't deny teleport requests, silly!");
				return false;
			}
			return true;
		}
		
		return true;
	}
	
	//Tpa API
	
	public void sendRequest(Player sender, Player recipient) {
		sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Sending a teleport request to " + ChatColor.GOLD + "" + ChatColor.BOLD + recipient.getName() + ChatColor.YELLOW + "" + ChatColor.BOLD + "!");
		
		String sendtpaccept = "";
		String sendtpdeny = "";
		
		if (recipient.hasPermission("tpa.tpaccept")) {
			sendtpaccept = ChatColor.YELLOW + "" + ChatColor.BOLD + " To accept that request, type " + ChatColor.GOLD + "" + ChatColor.BOLD + "\"/tpaccept\"" + ChatColor.YELLOW + "" + ChatColor.BOLD + " easy as that!";
		} else {
			sendtpaccept = "";
		}
		
		if (recipient.hasPermission("tpa.tpdeny")) {
			sendtpdeny = ChatColor.YELLOW + "" + ChatColor.BOLD + " To deny the teleport request, type " + ChatColor.GOLD + "" + ChatColor.BOLD + "\"/tpdeny\"" + ChatColor.YELLOW + "" + ChatColor.BOLD + ", no hard feeling ;)";
		} else {
			sendtpdeny = "";
		}
		
		recipient.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + sender.getName() + ChatColor.YELLOW + "" + ChatColor.BOLD + " has sent a teleport request to you." + sendtpaccept + sendtpdeny);
		currentRequest.put(recipient.getName(), sender.getName());
	}
	
	public boolean killRequest(String key) {
		if (currentRequest.containsKey(key)) {
			Player loser = getServer().getPlayer(currentRequest.get(key));
			if (!(loser == null)) {
				loser.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Your teleport request has timed out!");
			}
			
			currentRequest.remove(key);
			
			return true;
		} else {
			return false;
		}
	}
	
}
