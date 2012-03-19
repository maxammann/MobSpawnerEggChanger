package me.p000ison.MobSpawnerEggChanger;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private static final Logger logger = Logger.getLogger("Minecraft");

    public void onDisable() {
    }

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
        player.sendMessage(ChatColor.RED + "[SEC]" + ChatColor.DARK_GRAY + "Spawnertype changed to " + entity.toLowerCase() + ".");
    }
}