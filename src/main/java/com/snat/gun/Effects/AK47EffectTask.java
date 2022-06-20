package com.snat.gun.Effects;

import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AK47EffectTask extends BukkitRunnable {

    private final Map<Entity, AK47Effect> ak47Effects = new HashMap<>();

    public void addEffect(Entity entity) {
        if (ak47Effects.containsKey(entity)) {
            ak47Effects.get(entity).renew();
            return;
        }
        ak47Effects.put(entity, new AK47Effect(entity));
    }

    public void removeEffect(Entity entity) {
        AK47Effect effect;
        if ((effect = ak47Effects.get(entity)) != null) {
            effect.remove();
            ak47Effects.remove(entity);
        }
    }

    public void removeAll() {
        ak47Effects.values().forEach(ak47Effects::remove);
        ak47Effects.clear();
    }

    @Override
    public void run() {
        for (Map.Entry<Entity, AK47Effect> entry : new HashSet<>(ak47Effects.entrySet())) {
            AK47Effect effect = entry.getValue();
            // the second part of the check is because
            // if the player holds right click, he could hit
            // the entity after the death event was called
            // resulting in a new effect to spawn for 5 seconds
            if (effect.isExpired() || entry.getKey().isDead()) {
                effect.remove();
                ak47Effects.remove(entry.getKey());
            }
        }
    }
}

