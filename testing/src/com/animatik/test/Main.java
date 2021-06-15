package com.animatik.test;


import org.bukkit.event.Listener;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {



    static public void Consoleinfo(String m) {
        PreLoad.plugin.getLogger().info(m);
    }



    @Override
    public void onDisable() {
        Consoleinfo("Custon drinks is disabled");
        PreLoad.Finish(this);
        super.onDisable();
    }

    @Override
    public void onEnable() {
        Consoleinfo("Custon drinks is enabled");
        super.onEnable();
        PreLoad.Startup(this);
    }


}
