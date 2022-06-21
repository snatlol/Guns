package com.snat.gun.Listeners;

import com.snat.gun.Effects.GunEffectTask;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ShotgunEffectListener {


    private final GunEffectTask task;

    public ShotgunEffectListener(GunEffectTask task) {
        this.task = task;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        task.removeEffect(event.getPlayer());
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Zombie || entity instanceof Player) {
            task.removeEffect(entity);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityTeleport(EntityTeleportEvent event) {
        task.removeEffect(event.getEntity());
    }





}
