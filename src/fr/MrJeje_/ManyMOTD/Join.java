package fr.MrJeje_.ManyMOTD;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

	private ManyMOTD pl;
	private FileConfiguration config;

	public Join(ManyMOTD ManyMOTD) {
		this.pl = ManyMOTD;
		this.config = pl.getConfig();
		}	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
	Player p = e.getPlayer();
	
		if(config.getString("Enable") == "true")
		{
			//is player
			if ( !p.hasPermission("CustomMOTD.Staff"))
			{
				String message = config.getString("Message.IsPlayer").replace("&", "§");
				String[] messageSplit = message.split("\n");
				p.sendMessage(messageSplit);
			}
			
			//is staff or op
			if (p.hasPermission("CustomMOTD.Staff"))
			{
				String message = config.getString("Message.IsStaff").replace("&", "§");
				String[] messageSplit = message.split("\n");
				p.sendMessage(messageSplit);
			}
		}
	}
}