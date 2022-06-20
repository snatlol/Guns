package com.snat.gun.CustomItems;

import com.snat.gun.ItemBuilder;
import com.snat.gun.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Gernade {

    Utils utils = new Utils();

    public Gernade() {

    }

    ItemStack gernade = new ItemBuilder(Material.GREEN_WOOL, 1).setDisplayName(utils.color("&2&lGernade")).setLore("", utils.color("&7&l┃ &2A Gernade"), "").build();

    public void createGernade(Player player) {
        player.getInventory().addItem(gernade);
    }

}
