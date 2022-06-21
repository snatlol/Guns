package com.snat.gun;

import com.snat.gun.Commands.GetCommand;
import com.snat.gun.Commands.GetTab;
import com.snat.gun.Effects.GunEffectTask;
import com.snat.gun.Listeners.AK47EffectListener;
import com.snat.gun.Listeners.AK47Listener;
import com.snat.gun.Listeners.GrenadeListener;
import com.snat.gun.Listeners.ShotgunListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Guns extends JavaPlugin {


    private final GunEffectTask task = new GunEffectTask();

    @Override
    public void onEnable() {

        this.getCommand("get").setExecutor(new GetCommand());
        this.getCommand("get").setTabCompleter(new GetTab());

        getServer().getPluginManager().registerEvents(new AK47Listener(task), this);
        getServer().getPluginManager().registerEvents(new AK47EffectListener(task), this);

        getServer().getPluginManager().registerEvents(new GrenadeListener(), this);

        getServer().getPluginManager().registerEvents(new ShotgunListener(task), this);

        task.runTaskTimer(this, 0, 1);
    }

    @Override
    public void onDisable() {
        task.removeAll();
    }





}
