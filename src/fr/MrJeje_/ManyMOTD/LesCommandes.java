package fr.MrJeje_.ManyMOTD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class LesCommandes implements CommandExecutor {
	
	private ManyMOTD pl;
	private FileConfiguration config;
	
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
				
				if(args.length > 0){
						p.sendMessage("ManyMOTD developed by §4§lMrJeje_");
				}
			}
		}
		return false;
	}
}
