package com.snat.gun;

import com.snat.gun.Commands.GetCommand;
import com.snat.gun.Effects.AK47EffectTask;
import com.snat.gun.Listeners.AK47EffectListener;
import com.snat.gun.Listeners.AK47Listener;
import com.snat.gun.Listeners.GernadeListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Guns extends JavaPlugin {


    private final AK47EffectTask task = new AK47EffectTask();

    @Override
    public void onEnable() {

        this.getCommand("get").setExecutor(new GetCommand());
        getServer().getPluginManager().registerEvents(new AK47Listener(task), this);
        getServer().getPluginManager().registerEvents(new AK47EffectListener(task), this);

        getServer().getPluginManager().registerEvents(new GernadeListener(), this);

        task.runTaskTimer(this, 0, 1);
    }

    @Override
    public void onDisable() {
        task.removeAll();
    }





}
