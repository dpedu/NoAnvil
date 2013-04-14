package me.dpedu.noanvil;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;

public class NoAnvil extends JavaPlugin implements Listener {
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents( this, this );
	}
	
	@EventHandler( priority=EventPriority.HIGHEST )
	public void onInventoryOpenEvent(InventoryOpenEvent ioe) {
		if(ioe.getInventory().getType() == InventoryType.ANVIL ) {
			ioe.setCancelled(true);
			((Player) ioe.getPlayer()).sendMessage( ChatColor.RED +"Sorry, anvils are temporarily disabled as a security measure.");
			System.out.println("[NoAnvil] prevented "+((Player) ioe.getPlayer()).getName() +" from opening an Anvil");
		}
	}
}
