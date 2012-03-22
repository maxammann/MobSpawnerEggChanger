package me.p000ison.mobspawnereggchanger;

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

    MobSpawnerEggChanger main = new MobSpawnerEggChanger();

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack iih = event.getItem();
        Block block = event.getClickedBlock();


        if (iih != null && block != null && event.getAction() != null && block.getType() != null) {
            if (player.isSneaking()) {
                if (player.hasPermission("sec.spawnerchange")) {
                    if (block.getType() == Material.MOB_SPAWNER && event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && iih.getType() == Material.MONSTER_EGG) {
                        int dur = iih.getDurability();
                        changeSpawer(dur, block, player);
                        event.setCancelled(true);
                        block.getState().update();
                    }
                }
            }
        }
    }

    public void changeSpawer(int dur, Block block, Player player) {
        ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.fromId(dur));
        main.sendSpawnerMessage(player, EntityType.fromId(dur).toString());
    }
}