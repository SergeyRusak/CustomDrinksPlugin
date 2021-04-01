package com.animatik.test;


import com.animatik.test.coctails.CoctailBook;
import com.animatik.test.commands.About;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    public CoctailBook coctailBook;
    List<ShapelessRecipe> recipes;
    public  void AdelhydeCraft(){
        ItemStack adel = new ItemStack(Material.RED_DYE,1);
        adel.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.RED+"Adelhyde");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"Adelhyde is one of the ingredients used to make drinks");
        lore.add(ChatColor.WHITE+"It's the sweet component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the sweet section have Adelhyde in them.");

        meta.setLore(lore);
        adel.setItemMeta(meta);
        ShapelessRecipe recept = new ShapelessRecipe(NamespacedKey.minecraft("adelhyde"), adel);
        recept.addIngredient(Material.MELON_SLICE);
        recept.addIngredient(Material.GLASS_BOTTLE);
        Bukkit.addRecipe(recept);
    }
    public  void Bronson_ExtractCraft(){
        ItemStack adel = new ItemStack(Material.YELLOW_DYE,1);
        adel.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.YELLOW+"Bronson Extract");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the bitter component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the bitter section have bronson extract in them.");

        meta.setLore(lore);
        adel.setItemMeta(meta);

        ShapelessRecipe recept = new ShapelessRecipe(NamespacedKey.minecraft("bronson_extract"), adel);


        recept.addIngredient(Material.DEAD_BUSH);
        recept.addIngredient(Material.GLASS_BOTTLE);

        Bukkit.addRecipe(recept);
    }
    public  void FlanergideCraft(){
        ItemStack adel = new ItemStack(Material.LIME_DYE,1);
        adel.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.GREEN+"Flanergide");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the spicy component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the spicy section have flanergide in them.");

        meta.setLore(lore);
        adel.setItemMeta(meta);

        ShapelessRecipe recept = new ShapelessRecipe(NamespacedKey.minecraft("flanergide"), adel);

        recept.addIngredient(Material.CACTUS);
        recept.addIngredient(Material.GLASS_BOTTLE);

        Bukkit.addRecipe(recept);
    }
    public  void Powered_DeltaCraft(){
        ItemStack adel = new ItemStack(Material.BLUE_DYE,1);
        adel.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.BLUE+"Powered_Delta");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the sour component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the sour section have bronson extract in them.");

        meta.setLore(lore);
        adel.setItemMeta(meta);

        ShapelessRecipe recept = new ShapelessRecipe(NamespacedKey.minecraft("powered_delta"), adel);


        recept.addIngredient(Material.WHEAT_SEEDS);
        recept.addIngredient(Material.GLASS_BOTTLE);

        Bukkit.addRecipe(recept);
    }
    public  void KarmotrineCraft(){
        ItemStack adel = new ItemStack(Material.WHITE_DYE,1);
        adel.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.WHITE+"Karmotrine");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"Karmotrine is an alcoholic component and ");
        lore.add(ChatColor.WHITE+"can make clients drunk if served on big amounts.");
        lore.add(ChatColor.WHITE+"Some drinks can have optional Karmotrine so");
        lore.add(ChatColor.WHITE+"bartender should not add it if he wants to keep drink non-alcoholic.");

        meta.setLore(lore);
        adel.setItemMeta(meta);
        ShapelessRecipe recept = new ShapelessRecipe(NamespacedKey.minecraft("karmotrine"), adel);


        recept.addIngredient(Material.SUGAR);
        recept.addIngredient(Material.GLASS_BOTTLE);

        Bukkit.addRecipe(recept);
    }






    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
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
