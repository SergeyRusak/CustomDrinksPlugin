package com.animatik.test;


import com.animatik.test.coctails.CoctailBook;
import com.animatik.test.coctails.CraftingRecipes;
import com.animatik.test.commands.About;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main extends JavaPlugin {
    public CoctailBook coctailBook;
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        coctailBook = new CoctailBook();
        getCommand("about").setExecutor(new About(coctailBook));

        for (ShapedRecipe i: new CraftingRecipes().getRecipes()
             ) {
            Bukkit.addRecipe(i);
        }



        try {
            this.getLogger().info(String.valueOf(new FileReader("plugins/Coctails/Coctails.json")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public CoctailBook getCoctailBook() {
        return coctailBook;
    }
}
