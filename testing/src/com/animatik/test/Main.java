package com.animatik.test;


import com.animatik.test.coctails.CoctailBook;
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

public class Main extends JavaPlugin implements Listener {
    public CoctailBook coctailBook;
    public static Plugin plugin;
    public static CoctailBook book;
    List<ShapelessRecipe> recipes;
    public  void AdelhydeCraft(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"Adelhyde is one of the ingredients used to make drinks");
        lore.add(ChatColor.WHITE+"It's the sweet component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the sweet section have Adelhyde in them.");
        ingredientCraft( Material.RED_DYE,ChatColor.RED+"Adelhyde",lore,"adelhyde",Material.MELON_SLICE);
    }
    public  void Bronson_ExtractCraft(){
       List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the bitter component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the bitter section have bronson extract in them.");
        ingredientCraft(Material.YELLOW_DYE,ChatColor.YELLOW+"Bronson Extract",lore,"bronson_extract",Material.DEAD_BUSH);
    }
    public  void FlanergideCraft(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the spicy component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the spicy section have flanergide in them.");
        ingredientCraft(Material.LIME_DYE,ChatColor.GREEN+"Flanergide",lore, "flanergide", Material.CACTUS);
    }
    public  void Powered_DeltaCraft(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the sour component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the sour section have bronson extract in them.");
        ingredientCraft(Material.BLUE_DYE,ChatColor.BLUE+"Powered_Delta",lore, "powered_delta", Material.WHEAT_SEEDS);

    }
    public  void KarmotrineCraft(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"Karmotrine is an alcoholic component and ");
        lore.add(ChatColor.WHITE+"can make clients drunk if served on big amounts.");
        lore.add(ChatColor.WHITE+"Some drinks can have optional Karmotrine so");
        lore.add(ChatColor.WHITE+"bartender should not add it if he wants to keep drink non-alcoholic.");

        ingredientCraft(Material.WHITE_DYE,ChatColor.WHITE+"Karmotrine",lore, "karmotrine",Material.SUGAR);

    }

    public  void ingredientCraft(Material output,String name,List<String> lore,String key,Material ingridient){
        ItemStack adel = new ItemStack(output,1);
        adel.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(name);

        meta.setLore(lore);
        adel.setItemMeta(meta);
        ShapelessRecipe recept = new ShapelessRecipe(NamespacedKey.minecraft(key), adel);
        recept.addIngredient(ingridient);
        recept.addIngredient(Material.GLASS_BOTTLE);
        Bukkit.addRecipe(recept);
    }



    static public  void Consoleinfo(String m) {
        plugin.getLogger().info(m);
    }
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();

        plugin = this;




        Listeners events = new Listeners();
        getServer().getPluginManager().registerEvents(events,this);
         coctailBook = new CoctailBook();
        getCommand("aout").setExecutor(new About(coctailBook));
        AdelhydeCraft();
        Bronson_ExtractCraft();
        FlanergideCraft();
        Powered_DeltaCraft();
        KarmotrineCraft();



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
