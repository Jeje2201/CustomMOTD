package fr.MrJeje_.CustomMOTD;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class LesCommandes implements CommandExecutor {
	
	private CustomMOTD pl;
	private FileConfiguration config;
	
	public LesCommandes(CustomMOTD CustomMOTD) {
		this.pl = CustomMOTD;
		this.config = pl.getConfig();
		}	
	
	int compteurjoueur = 0;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player){
			
			Player p = (Player)sender;
			 
			if(cmd.getName().equalsIgnoreCase("CustomMOTD")){
				
				if(args.length == 0){
					
					if(p.hasPermission("CustomMOTD.help")){
						
						p.sendMessage(
								"§e§l--- §fPlayerTag Info §e§l---"
								+ "\n§7Below is a list of all Tag commands:§f"
								+ "\n§e§l----"
								);
						
					}
					
					else {
						p.sendMessage((config.getString("Message.PluginName") + config.getString("Message.NoPerm")).replace("&", "§"));
					}
				}
						
				if(args.length == 1){
					
					if(args[0].equalsIgnoreCase("custom")){
						if (p.hasPermission("CustomMOTD.custom")){
							p.sendMessage("");
						}
						else{
							p.sendMessage((config.getString("Message.PluginName") + config.getString("Message.NoPerm")).replace("&", "§"));
						}
					}
				}
				
				if (!args[0].equalsIgnoreCase("custom")){
					p.sendMessage((config.getString("Message.PluginName")+config.getString("Message.ErrorCommand")).replace("&", "§"));
				}
		}
	}
		return false;
	}
}
