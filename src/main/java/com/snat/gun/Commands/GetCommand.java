package com.snat.gun.Commands;

import com.snat.gun.CustomItems.AK47;
import com.snat.gun.CustomItems.Grenade;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        AK47 ak47 = new AK47();
        Grenade grenade = new Grenade();

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if(args.length == 1) {

                switch (args[0]) {
                    case "AK47":
                        ak47.createAK47(player);
                        break;

                    case "Grenade":
                        grenade.createGrenade(player);
                        break;

                    default:
                        return true;
                }

            }

        }
        return true;

    }


}
