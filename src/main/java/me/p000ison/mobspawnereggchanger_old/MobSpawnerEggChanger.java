package me.p000ison.mobspawnereggchanger;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Simply Changes the Spawnertype
 *
 * @author p000ison
 */
public class MobSpawnerEggChanger extends JavaPlugin {

    private static final Logger logger = Logger.getLogger("Minecraft");
    private File file;
    private FileConfiguration config;
    private int SpawnerEggs;
    private String SpawnerMesssage;
    private String NotEnoughSpawnerEggs;
    private String FailedSpawnerEggs;
    private boolean perMobPermissions;

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new SECPlayerListener(this), this);

        file = new File(this.getDataFolder(), "config.yml");
        config = getConfig();
        load();

        try {
            MetricsLite metrics = new MetricsLite(this);
            metrics.start();
        } catch (IOException e) {
            logger.log(Level.WARNING, "Could not send Plugin-Stats: " + e.getMessage());
        }
    }

    public void load() {
        boolean exists = (file).exists();

        if (exists) {
            try {
                this.getConfig().options().copyDefaults(true);
                getConfig().load(file);
            } catch (Exception ex) {
                logger.log(Level.WARNING, "Loading the config failed!: " + ex.getMessage());
            }
        } else {
            getConfig().options().copyDefaults(true);

        }

        SpawnerEggs = config.getInt("Global.AmountOfSpawnerEggsYouNeed");
        SpawnerMesssage = config.getString("Messages.ChangeSpawner");
        NotEnoughSpawnerEggs = config.getString("Messages.NotEnoughSpawnerEggs");
        FailedSpawnerEggs = config.getString("Messages.FailedSpawnerEggs");
        perMobPermissions = config.getBoolean("Global.perMobPermissions");

        save();
    }

    public void save() {
        try {
            getConfig().save(file);
        } catch (IOException ex) {
            logger.log(Level.WARNING, "Saving the config failed!: " + ex.getMessage());
        }
    }

    /**
     * @return the SpawnerEggs
     */
    public int getSpawnerEggs() {
        return SpawnerEggs;
    }

    /**
     * @return the SpawnerMesssage
     */
    public String getSpawnerMesssage() {
        return SpawnerMesssage;
    }

    /**
     * @return the NotEnoughSpawnerEggs
     */
    public String getNotEnoughSpawnerEggs() {
        return NotEnoughSpawnerEggs;
    }

    /**
     * @return the FailedSpawnerEggs
     */
    public String getFailedSpawnerEggs() {
        return FailedSpawnerEggs;
    }

    /**
     * @return the perMobPermissions
     */
    public boolean isPerMobPermissions()
    {
        return perMobPermissions;
    }
}

