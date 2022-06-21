package com.snat.gun.Effects;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class GunEffect {

    private final ArmorStand effect;
    private long expiration;

    public GunEffect(Entity entity) {
        this.effect = (ArmorStand) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.ARMOR_STAND);
        this.effect.setInvisible(true);
        this.effect.setInvulnerable(true);
        this.effect.getEquipment().setHelmet(new ItemStack(Material.RED_CONCRETE));
        entity.addPassenger(this.effect);
        this.renew();
    }

    public void remove() {
        effect.remove();
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiration;
    }

    public void renew() {
        this.expiration = System.currentTimeMillis() + 5000;
    }


}
