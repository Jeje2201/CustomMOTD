package fr.MrJeje_.CustomMOTD;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

	private CustomMOTD pl;
	private FileConfiguration config;

	public Join(CustomMOTD CustomMOTD) {
		this.pl = CustomMOTD;
		this.config = pl.getConfig();
		}	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
	Player p = e.getPlayer();
	
		if(config.getString("Enable") == "true")
		{
			if (p.hasPermission("CustomMOTD.Player"))
			{
				String message = config.getString("Message.IsPlayer").replace("&", "§");
				String[] messageSplit = message.split("\n");
				p.sendMessage(messageSplit);
			}
			
			else if (p.hasPermission("CustomMOTD.Staff"))
			{
				String message = config.getString("Message.IsStaff").replace("&", "§");
				String[] messageSplit = message.split("\n");
				p.sendMessage(messageSplit);
			}
			
			else if ((p.hasPermission("CustomMOTD.Player")) && (p.hasPermission("CustomMOTD.Staff")))//if is op show staff
			{
				String message = config.getString("Message.IsStaff").replace("&", "§");
				String[] messageSplit = message.split("\n");
				p.sendMessage(messageSplit);
			}
			else
			{
				p.sendMessage("Look like theire is an error with you");
			}
		}
	}
}