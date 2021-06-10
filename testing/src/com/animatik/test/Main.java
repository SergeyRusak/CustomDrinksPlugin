package com.animatik.test;


import com.animatik.test.coctails.BookRecipe;
import com.animatik.test.coctails.CoctailBook;
import com.animatik.test.coctails.CoctailLocations;
import com.animatik.test.commands.About;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static com.animatik.test.PreLoad.RecipeBook;

public class Main extends JavaPlugin implements Listener {



    static public void Consoleinfo(String m) {
        PreLoad.plugin.getLogger().info(m);
    }



    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        PreLoad.Startup(this);
    }


}
