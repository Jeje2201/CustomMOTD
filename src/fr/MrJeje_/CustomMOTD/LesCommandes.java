package fr.MrJeje_.CustomMOTD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class LesCommandes implements CommandExecutor {
	
	private CustomMOTD pl;
	private FileConfiguration config;
	
	public LesCommandes(CustomMOTD CustomMOTD) {
		this.pl = CustomMOTD;
		this.config = pl.getConfig();
		}	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player){
			
			Player p = (Player)sender;
			 
			if(cmd.getName().equalsIgnoreCase("CustomMOTD")){
				
				if(args.length == 0){
					
					//is player
					if ( !p.hasPermission("CustomMOTD.Staff"))
					{
						String message = config.getString("Message.IsPlayer").replace("&", "§");
						String[] messageSplit = message.split("\n");
						p.sendMessage(messageSplit);
						return false;
					}
					
					//is staff or op
					if (p.hasPermission("CustomMOTD.Staff"))
					{
						String message = config.getString("Message.IsStaff").replace("&", "§");
						String[] messageSplit = message.split("\n");
						p.sendMessage(messageSplit);
						return false;
					}
					
				}
				
				if(args.length > 0){
						p.sendMessage("CustomMOTD developed by §4§lMrJeje_");
				}
			}
		}
		return false;
	}
}
