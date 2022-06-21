package com.snat.gun.Listeners;

import com.snat.gun.Effects.GunEffectTask;
import com.snat.gun.Utils;
import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.Set;


public class AK47Listener implements Listener {


    private final GunEffectTask task;

    public AK47Listener(GunEffectTask task) {
        this.task = task;
    }

    Utils utils = new Utils();


    @EventHandler
    public void shootEvent(PlayerInteractEvent e) {
        Player player = e.getPlayer();


            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(utils.color("&b&lAK-47")) && player.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_HOE)) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    Location start = player.getEyeLocation();
                    Location location = start.clone();
                    Vector direction = location.getDirection().normalize();
                    int i = 0;
                    while (i < 15 && !location.getBlock().getType().isSolid()) {
                        // cam be swapped to Player#spawnParticle if only shooter should see particles
                        location.getWorld().spawnParticle(Particle.REDSTONE, location.add(direction), 1, new Particle.DustOptions(Color.BLACK, 1));
                        i++;
                    }
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 0.7F, 1);

                    Set<Entity> hit = new HashSet<>();
                    hit.add(player); // ignore the shooter
                    RayTraceResult result;
                    while ((result = start.getWorld().rayTrace(
                            start,
                            direction,
                            15,
                            FluidCollisionMode.NEVER,
                            true,
                            0.0D,
                            entity -> !hit.contains(entity) && (entity instanceof Zombie || entity instanceof Player ))) != null
                            && result.getHitBlock() == null) {
                        Entity entity = result.getHitEntity();
                        hit.add(entity);
                        task.addEffect(entity);
                        ((Damageable) entity).damage(4);
                    }
                }
            }




        }
}
