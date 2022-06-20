package com.snat.gun.Commands;

import com.snat.gun.CustomItems.AK47;
import com.snat.gun.CustomItems.Gernade;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GetCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        AK47 ak47 = new AK47();
        Gernade gernade = new Gernade();
        if (sender instanceof Player) {

            Player player = (Player) sender;

            if(args.length == 1) {
                List<String> results = new ArrayList<>();
                results.add("AK47");
                results.add("Gernade");

                switch (args[0]) {
                    case "AK47":
                        ak47.createAK47(player);
                        break;

                    case "Gernade":
                        gernade.createGernade(player);
                        break;

                    default:
                        return true;
                }
            }

        }
        return true;
    }

}
