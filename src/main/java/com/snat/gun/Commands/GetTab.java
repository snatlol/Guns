package com.snat.gun.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class GetTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> results = new ArrayList<>();

        if (args.length == 1 ) {
            results.add("AK47");
            results.add("Grenade");
            results.add("Shotgun");

        }



        return results;
    }
}
