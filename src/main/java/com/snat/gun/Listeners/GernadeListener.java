package com.snat.gun.Listeners;

import com.snat.gun.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class GernadeListener implements Listener {

    Utils utils = new Utils();
    List<FallingBlock> throwGernade = new ArrayList<>();



    @EventHandler
    public void onThrow(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Location playerLoc = e.getPlayer().getEyeLocation();

        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(utils.color("&2&lGernade")) && player.getInventory().getItemInMainHand().getType().equals(Material.GREEN_WOOL)) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                FallingBlock gernade = e.getPlayer().getWorld().spawnFallingBlock(playerLoc, Material.GREEN_WOOL, (byte) 0);
                gernade.setDropItem(false);
                throwGernade.add(gernade);
                gernade.setVelocity(e.getPlayer().getLocation().getDirection().multiply(3));
                player.getInventory().remove(Material.GREEN_WOOL);
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onLand(EntityChangeBlockEvent e) {
        if (e.getEntity() instanceof  FallingBlock) {
            if(throwGernade.contains(e.getEntity())) {
                e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 3, false, false);
                e.setCancelled(true);
                e.getEntity().remove();
                throwGernade.remove(e.getEntity());
            }
        }
    }


}
