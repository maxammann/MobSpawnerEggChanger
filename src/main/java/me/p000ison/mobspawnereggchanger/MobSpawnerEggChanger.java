package me.p000ison.MobSpawnerEggChanger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Simply Changes the Spawnertype
 *
 * @author p000ison
 */
public class MobSpawnerEggChanger extends JavaPlugin {

    public void onDisable() {
    }

    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new SECPlayerListener(), this);
    }
    
    public void sendSpawnerMessage(Player player, String entity){
    	player.sendMessage(ChatColor.RED + "[SEC]" + ChatColor.DARK_GRAY + "Spawnertype changed to " + entity.toLowerCase() + ".");
    }
}