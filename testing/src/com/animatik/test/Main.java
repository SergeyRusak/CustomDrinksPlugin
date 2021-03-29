package com.animatik.test;


import com.animatik.test.commands.About;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        getCommand("about").setExecutor(new About());

        this.getLogger().info("Оно работает?");

    }
}
