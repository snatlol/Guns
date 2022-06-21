package com.snat.gun.CustomItems;

import com.snat.gun.ItemBuilder;
import com.snat.gun.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Grenade {

    Utils utils = new Utils();

    public Grenade() {

    }

    ItemStack grenade = new ItemBuilder(Material.GREEN_WOOL, 1).setDisplayName(utils.color("&2&lGrenade")).setLore("", utils.color("&7&l┃ &2A Grenade"), "").build();

    public void createGrenade(Player player) {
        player.getInventory().addItem(grenade);
    }

}
