package fr.MrJeje_.CustomMOTD;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
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
			for (Player s : Bukkit.getOnlinePlayers())
			{
				if (s.hasPermission("CustomMOTD.Player"))
				{
					s.sendMessage(" LeTest1 " + config.getString("Message.IsPlayer"));
				}
				
				else
				{
					s.sendMessage(" LeTest2 " + config.getString("Message.IsStaff"));
				}
			}
		}
			
			}
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//This is for mrjeje, just to get a popup when someone mine a diamond, don't need to flood the console and other staff don't want to get spam of this, so to not bother anyone, popup mrjeje only to find xray players 
		@EventHandler
	    public void onBlockBreak(BlockBreakEvent e) {
	        Player c = e.getPlayer();
	        Block b = e.getBlock();
	        Player m = Bukkit.getServer().getPlayer("MrJeje_");
	       
	        if ((m != null) && (b.getType() == Material.DIAMOND_ORE) ){
	        	m.sendMessage( "[§cAlert§f] \""+c.getDisplayName() + "\" mine du §bdiamand");
	        }
					
    	}

}

