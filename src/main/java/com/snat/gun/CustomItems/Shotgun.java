package com.snat.gun.CustomItems;


import com.snat.gun.ItemBuilder;
import com.snat.gun.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Shotgun {

    Utils utils = new Utils();

    public Shotgun() {

    }

    ItemStack shotgun = new ItemBuilder(Material.IRON_HOE, 1).setDisplayName(utils.color("&c&lShotgun")).setLore("", utils.color("&7&l| &2A Shotgun")).build();

    public void createShotgun(Player player) {
        player.getInventory().addItem(shotgun);
    }




}
