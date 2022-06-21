package com.snat.gun.Effects;

import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GunEffectTask extends BukkitRunnable {

    private final Map<Entity, GunEffect> gunEffects = new HashMap<>();

    public void addEffect(Entity entity) {
        if (gunEffects.containsKey(entity)) {
            gunEffects.get(entity).renew();
            return;
        }
        gunEffects.put(entity, new GunEffect(entity));
    }

    public void removeEffect(Entity entity) {
        GunEffect effect;
        if ((effect = gunEffects.get(entity)) != null) {
            effect.remove();
            gunEffects.remove(entity);
        }
    }

    public void removeAll() {
        gunEffects.values().forEach(gunEffects::remove);
        gunEffects.clear();
    }

    @Override
    public void run() {
        for (Map.Entry<Entity, GunEffect> entry : new HashSet<>(gunEffects.entrySet())) {
            GunEffect effect = entry.getValue();
            // the second part of the check is because
            // if the player holds right click, he could hit
            // the entity after the death event was called
            // resulting in a new effect to spawn for 5 seconds
            if (effect.isExpired() || entry.getKey().isDead()) {
                effect.remove();
                gunEffects.remove(entry.getKey());
            }
        }
    }
}

