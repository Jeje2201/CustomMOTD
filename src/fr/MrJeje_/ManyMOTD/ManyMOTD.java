package fr.MrJeje_.ManyMOTD;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ManyMOTD extends JavaPlugin implements Listener {
	
	public void onEnable(){
		
		System.out.println("[ManyMOTD] Enable! (by MrJeje_)");
		
		getConfig().options().copyDefaults(true); //chargement de la config par defaut
		saveConfig();
		
		getCommand("ManyMOTD").setExecutor(new LesCommandes(this)); //creer la commande avec sa classe 
		getCommand("mmotd").setExecutor(new LesCommandes(this));
		
		PluginManager pm = getServer().getPluginManager(); //Indique qu'il existe d'autres classes a action
		pm.registerEvents(new Join(this), this);
	}
	
	public void onDisable(){
		System.out.println("[ManyMOTD] Disable! (by MrJeje_)");
	}

}