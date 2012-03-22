package me.p000ison.mobspawnereggchanger;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Simply Changes the Spawnertype
 *
 * @author p000ison
 */
public class MobSpawnerEggChanger extends JavaPlugin {

    private static final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new SECPlayerListener(), this);
        
        try {
            MetricsLite metrics = new MetricsLite(this);
            metrics.start();
        } catch (IOException e) {
            logger.log(Level.WARNING, "Could not send Plugin-Stats: " + e.getMessage());
        }
    }

    public void sendSpawnerMessage(Player player, String entity) {
        player.sendMessage(ChatColor.RED + "[MSEC]" + ChatColor.GRAY + "Spawnertype changed to " + entity.toUpperCase() + ".");
    }
}