package edu.unca.cburris.Demo;

import java.text.MessageFormat;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

/*
 * This is a sample event listener
 */
public class DemoListener implements Listener {
    private final Demo plugin;

    /*
     * This listener needs to know about the plugin which it came from
     */
    public DemoListener(Demo plugin) {
        // Register the listener
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        
        this.plugin = plugin;
    }

    /*
     * Send the sample message to all players that join
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
    	plugin.setMetaData(event.getPlayer(), "sword", false, plugin);
        event.getPlayer().sendMessage(this.plugin.getConfig().getString("sample.message"));
        //Player p = (Player)sender;
        //if(p.getResult() != Result.ALLOWED){
        	//p.setKickMessage("Your player ID is on the ban list for this server");
        	
        //}
    }
    
    /*
     * Another example of a event handler. This one will give you the name of
     * the entity you interact with, if it is a Creature it will give you the
     * creature Id.
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        final EntityType entityType = event.getRightClicked().getType();

        event.getPlayer().sendMessage(MessageFormat.format(
                "You interacted with a {0} it has an id of {1}",
                entityType.getName(),
                entityType.getTypeId()));
    }
   @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
   
   public void demoEvent(PlayerInteractEvent event){
	        	if(event.getAction() == Action.LEFT_CLICK_BLOCK) {
	        		if ((Boolean) plugin.getMetaData(event.getPlayer(), "sword", plugin)) {
	        			//Player k = event.getPlayer();
	        			//int x = event.getClickedBlock().getType().getId();
	        			Block x = event.getPlayer().getLocation().getBlock();
	        			if (x != null){
	        				//Material m = event.getClickedBlock().getType();
	        				//if (m == Material.LOG){
	        						
	        					Location loc = x.getLocation();
	        					//loc.getWorld().createExplosion(loc, 15);
	        					loc.getWorld().strikeLightning(loc);
	        					
	        					x.setType(Material.CAKE);
	        					event.getPlayer().sendMessage("leave my blocks alone!! muahahaha!");
	        					
	        					loc.getWorld().dropItem(loc, new ItemStack(Material.HUGE_MUSHROOM_1, 4)); // drops player a huge mushroom
	        					
	        					event.getPlayer().sendMessage("here's a mushroom to keep you alive");
	        					
	        				}
	        				
	        			}
	        			
	        			
	        		}
	        	}
	   
	   
		//}
}
