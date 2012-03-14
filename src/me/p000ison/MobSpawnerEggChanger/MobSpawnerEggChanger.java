package me.p000ison.MobSpawnerEggChanger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

/**
 * Simply Changes the Spawnertype
 *
 * @author p000ison
 */
public class MobSpawnerEggChanger extends JavaPlugin {

    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
    	System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled!" );
    }

    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new SECPlayerListener(), this);
        
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }
    
    public void sendSpawnerMessage(Player player, String entity){
    	player.sendMessage(ChatColor.RED + "[SEC]" + ChatColor.DARK_GRAY + "Spawnertype changed to " + entity.toLowerCase() + ".");
    }
}