package fr.MrJeje_.ManyMOTD;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class LesCommandes implements CommandExecutor {
	
	private ManyMOTD pl;
	private FileConfiguration config;
	private String Error = "§4[Error!] Your command is wrong, please refer to /mmotd help";
	
	public LesCommandes(ManyMOTD ManyMOTD) {
		this.pl = ManyMOTD;
		this.config = pl.getConfig();
		}	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player){
			
			Player p = (Player)sender;
			 
			if(cmd.getName().equalsIgnoreCase("ManyMOTD")){
				
				if(args.length == 0){
					
					//is player
					if ( !p.hasPermission("ManyMOTD.Staff"))
					{
						String message = config.getString("Message.IsPlayer").replace("&", "§");
						String[] messageSplit = message.split("\n");
						p.sendMessage(messageSplit);
					}
					
					//is staff or op
					if (p.hasPermission("ManyMOTD.Staff"))
					{
						String message = config.getString("Message.IsStaff").replace("&", "§");
						String[] messageSplit = message.split("\n");
						p.sendMessage(messageSplit);
					}
					
				}
				
				if(args.length == 1){ //1 argument
					
					if(args[0].equalsIgnoreCase("player")){ 
						String message = config.getString("Message.IsPlayer").replace("&", "§");
						String[] messageSplit = message.split("\n");
						p.sendMessage(messageSplit);
					}
					
					else if(args[0].equalsIgnoreCase("help")){ 
						p.sendMessage(
								"§e§l--- §fManyMOTD Help §e§l---"
								+ "\n§7Below is a list of all MMOTD commands:§f"
								+ "\n§6/mmotd: Show the current MOTD base on your rank"
								+ "\n§6/mmotd player: Show the player MOTD"
								+ "\n§6/mmotd help: Give you a list of ManyMOTD commands"
								+ "\n§7(ManyMOTD developed by MrJeje_)"
								+ "\n§e§l----"
								);
					}
					
					else{
						p.sendMessage(Error);
					}
				}
				/*
				if(args.length == 2){//2 argument
					p.sendMessage(config.getString("Message.ErrorCommand").replace("&", "§"));
				}
				if(args.length == 3){ //3 argument
					
					if(args[0].equalsIgnoreCase("set")){
						String rank = args[1];
						String NewMOTD = args[2];
						
						if((rank.equalsIgnoreCase("Player"))||(rank.equalsIgnoreCase("Staff"))){
							pl.getConfig().set("Message.Is"+rank, NewMOTD);
							p.sendMessage("New MOTD for "+rank+" just applied!");	
						}
						else{
							p.sendMessage("§4Rank inscrit: "+rank);
							p.sendMessage("§MOTD inscrit: "+NewMOTD);
							p.sendMessage("§4Nom du rank incorrect!");
						}
						
					}
						
					else{
						p.sendMessage(config.getString("Message.ErrorCommand").replace("&", "§"));
					}
				}
				*/
				
				if(args.length >= 2){
						p.sendMessage(Error);
				}
			}
		}
		return false;
	}
}
