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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SECPlayerListener implements Listener {

    private MobSpawnerEggChanger plugin;

    public SECPlayerListener(MobSpawnerEggChanger plugin) {
        this.plugin = plugin;
    }
    MobSpawnerEggChanger main = new MobSpawnerEggChanger();

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack iih = event.getItem();
        Block block = event.getClickedBlock();

        if (iih != null && block != null && event.getAction() != null) {
            if (player.isSneaking()) {
                if (player.hasPermission("sec.spawnerchange")) {
                    if (block.getType() == Material.MOB_SPAWNER && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                        try {
                            changeSpawer(iih.getDurability(), block, player, iih);
                        } catch (Exception ex) {
                            player.sendMessage(color(plugin.getFailedSpawnerEggs(), (short) 0));
                        }
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    public void changeSpawer(short dur, Block block, Player player, ItemStack iih) {
        if (dur != 0) {
            if (!player.hasPermission("sec.bypass")) {
                if (iih.getType() == Material.MONSTER_EGG && iih.getAmount() >= plugin.getSpawnerEggs() && iih.getDurability() == dur) {
                    ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.fromId(dur));
                    player.sendMessage(color(plugin.getSpawnerMesssage(), dur).replace("%entity", EntityType.fromId(dur).toString()));
                    remove(player.getInventory(), new ItemStack(Material.MONSTER_EGG), plugin.getSpawnerEggs(), dur);
                    update(block, player);
                } else {
                    player.sendMessage(color(plugin.getNotEnoughSpawnerEggs(), iih.getDurability()).replace("%entity", EntityType.fromId(dur).toString()));
                }
            } else {
                if (iih.getType() == Material.MONSTER_EGG) {
                    ((CreatureSpawner) block.getState()).setSpawnedType(EntityType.fromId(dur));
                    player.sendMessage(color(plugin.getSpawnerMesssage(), dur).replace("%entity", EntityType.fromId(dur).toString()));
                    update(block, player);
                }
            }
        }
    }

    public void update(Block block, Player player) {
        block.getState().update();
        player.updateInventory();
    }

    public String color(String text, short dur) {
        String color = text.replaceAll("&(?=[0-9a-fA-FkK])", "\u00a7");
        return color;
    }

    /**
     * @author Acrobot
     */
    public static int remove(Inventory inv, ItemStack item, int amount, short durability) {
        amount = (amount > 0 ? amount : 1);
        Material itemMaterial = item.getType();

        int first = inv.first(itemMaterial);
        if (first == -1) {
            return amount;
        }

        for (int slot = first; slot < inv.getSize(); slot++) {
            if (amount <= 0) {
                return 0;
            }

            ItemStack currentItem = inv.getItem(slot);
            if (currentItem == null || currentItem.getType() == Material.AIR) {
                continue;
            }

            if (equals(currentItem, item, durability)) {
                int currentAmount = currentItem.getAmount();
                if (amount == currentAmount) {
                    currentItem = null;
                    amount = 0;
                } else if (amount < currentAmount) {
                    currentItem.setAmount(currentAmount - amount);
                    amount = 0;
                } else {
                    currentItem = null;
                    amount -= currentAmount;
                }
                inv.setItem(slot, currentItem);
            }
        }
        return amount;
    }

    private static boolean equals(ItemStack i, ItemStack item, short durability) {
        return i != null
                && i.getType() == item.getType()
                && (durability == -1 || i.getDurability() == durability);
    }

    class LivingEntityExeption extends Exception {

        public LivingEntityExeption(String ex) {
            super(ex);
        }
    }
}