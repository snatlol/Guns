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

public class GrenadeListener implements Listener {

    Utils utils = new Utils();
    List<FallingBlock> throwGrenade = new ArrayList<>();



    @EventHandler
    public void onThrow(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Location playerLoc = e.getPlayer().getEyeLocation();

        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(utils.color("&2&lGrenade")) && player.getInventory().getItemInMainHand().getType().equals(Material.GREEN_WOOL)) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                FallingBlock grenade = e.getPlayer().getWorld().spawnFallingBlock(playerLoc, Material.GREEN_WOOL, (byte) 0);
                grenade.setDropItem(false);
                throwGrenade.add(grenade);
                grenade.setVelocity(e.getPlayer().getLocation().getDirection().multiply(3));
                player.getInventory().remove(Material.GREEN_WOOL);
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onLand(EntityChangeBlockEvent e) {
        if (e.getEntity() instanceof  FallingBlock) {
            if(throwGrenade.contains(e.getEntity())) {
                e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 3, false, false);
                e.setCancelled(true);
                e.getEntity().remove();
                throwGrenade.remove(e.getEntity());
            }
        }
    }


}
