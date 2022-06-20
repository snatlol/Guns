package com.snat.gun.CustomItems;

import com.snat.gun.ItemBuilder;
import com.snat.gun.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AK47 {

    Utils utils = new Utils();


    public AK47() {

    }
    ItemStack AK47 = new ItemBuilder(Material.DIAMOND_HOE, 1).setDisplayName(utils.color("&b&lAK-47")).
            setLore( "", utils.color("&7&l┃ &2AK-47")).build();

    public void createAK47(Player player) {
        player.getInventory().addItem(AK47);
    }






}
