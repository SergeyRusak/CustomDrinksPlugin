package com.animatik.test;


import com.animatik.test.coctails.CoctailBook;
import com.animatik.test.commands.About;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    public CoctailBook coctailBook;
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        getCommand("about").setExecutor(new About());

        for (File i : this.getDataFolder().listFiles()
             ) {
            this.getLogger().info(i.getName());
        }


    }

    public CoctailBook getCoctailBook() {
        return coctailBook;
    }
}
