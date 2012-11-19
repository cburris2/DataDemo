package edu.unca.cburris.Demo;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;

/*
 * This is the main class of the sample plug-in
 */
public class Demo extends JavaPlugin {
	/*
	 * This is called when your plug-in is enabled
	 */
	//NewLogger logger; 
	DemoCommandExecutor ex;
	@Override
	public void onEnable() {
		// save the configuration file
		saveDefaultConfig();
	    //logger = new NewLogger(this);
       // logger.info("Plugin enabled");
		// Create the SampleListener
		new DemoListener(this);
		
        ex = new DemoCommandExecutor(this);
		// set the command executor for sample
		this.getCommand("demo").setExecutor(ex);
		this.getCommand("sword").setExecutor(ex);
	}

	/*
	 * This is called when your plug-in shuts down
	 */
	@Override
	public void onDisable() {
		saveDefaultConfig(); 
		
		//log.info("FirstPlugin has been disabled")
	}
	public void setMetaData(Player player, String key, Object value, Demo plugin){
				
				player.setMetadata(key, new FixedMetadataValue(plugin, value));
				
			
	}
	
	public Object getMetaData(Player player, String key, Demo plugin){
		
				List<MetadataValue> metaValues = player.getMetadata(key);
				for(MetadataValue value : metaValues) {
					if(value.getOwningPlugin().getDescription().getName().equals(plugin.getDescription().getName())){
						
						return (value.asBoolean());
					}
					
					
				}
				return null;
		
	}

}
