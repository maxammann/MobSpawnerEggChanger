package me.p000ison.MobSpawnerEggChanger;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SECPlayerListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack iih = event.getItem();
        Block block = event.getClickedBlock();
        MobSpawnerEggChanger main = new MobSpawnerEggChanger();

        if (iih != null && block != null && event.getAction() != null && block.getType() != null) {
            if (player.isSneaking()) {
                if (player.hasPermission("sec.spawnerchange")) {
                    if (block.getType() == Material.MOB_SPAWNER && event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && iih.getType() == Material.MONSTER_EGG) {
                        if (iih.getDurability() == 50) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.CREEPER);
                            main.sendSpawnerMessage(player, "Creeper");
                        }
                        if (iih.getDurability() == 51) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.SKELETON);
                            main.sendSpawnerMessage(player, "Skeleton");
                        }
                        if (iih.getDurability() == 52) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.SPIDER);
                            main.sendSpawnerMessage(player, "Spider");
                        }
                        if (iih.getDurability() == 54) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.ZOMBIE);
                            main.sendSpawnerMessage(player, "Zombie");
                        }
                        if (iih.getDurability() == 55) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.SLIME);
                            main.sendSpawnerMessage(player, "Slime");
                        }
                        if (iih.getDurability() == 56) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.GHAST);
                            main.sendSpawnerMessage(player, "Ghast");
                        }
                        if (iih.getDurability() == 57) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.PIG_ZOMBIE);
                            main.sendSpawnerMessage(player, "Pig Zombie");
                        }
                        if (iih.getDurability() == 58) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.ENDERMAN);
                            main.sendSpawnerMessage(player, "Enderman");
                        }
                        if (iih.getDurability() == 59) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.CAVE_SPIDER);
                            main.sendSpawnerMessage(player, "Cave Spider");
                        }
                        if (iih.getDurability() == 60) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.SILVERFISH);
                            main.sendSpawnerMessage(player, "Silverfish");
                        }
                        if (iih.getDurability() == 61) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.BLAZE);
                            main.sendSpawnerMessage(player, "Blaze");
                        }
                        if (iih.getDurability() == 62) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.MAGMA_CUBE);
                            main.sendSpawnerMessage(player, "Magma Cube");
                        }
                        if (iih.getDurability() == 90) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.PIG);
                            main.sendSpawnerMessage(player, "Pig");
                        }
                        if (iih.getDurability() == 91) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.SHEEP);
                            main.sendSpawnerMessage(player, "Sheep");
                        }
                        if (iih.getDurability() == 92) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.COW);
                            main.sendSpawnerMessage(player, "Cow");
                        }
                        if (iih.getDurability() == 93) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.CHICKEN);
                            main.sendSpawnerMessage(player, "Chicken");
                        }
                        if (iih.getDurability() == 94) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.SQUID);
                            main.sendSpawnerMessage(player, "Squid");
                        }
                        if (iih.getDurability() == 95) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.WOLF);
                            main.sendSpawnerMessage(player, "Wolf");
                        }
                        if (iih.getDurability() == 96) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.MUSHROOM_COW);
                            main.sendSpawnerMessage(player, "Mushroom Cow");
                        }
                        if (iih.getDurability() == 98) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.OCELOT);
                            main.sendSpawnerMessage(player, "Ocelot");
                        }
                        if (iih.getDurability() == 120) {
                            ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.VILLAGER);
                            main.sendSpawnerMessage(player, "Villager");
                        }
                        event.setCancelled(true);
                        block.getState().update();
                    }
                }
            }
        }
    }
}