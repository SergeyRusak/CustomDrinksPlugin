package com.animatik.CustomDrinks;


import org.bukkit.event.Listener;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {



    static public void Consoleinfo(String m) {
        PreLoad.plugin.getLogger().info(m);
    }



    @Override
    public void onDisable() {
        super.onDisable();
        PreLoad.Finish(this);
        Consoleinfo("Custon drinks is disabled");
    }

    @Override
    public void onEnable() {
        super.onEnable();
        PreLoad.Startup(this);
        Consoleinfo("Custon drinks is enabled");
    }


}
