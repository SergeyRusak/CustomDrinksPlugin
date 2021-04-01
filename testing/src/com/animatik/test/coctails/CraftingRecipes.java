package com.animatik.test.coctails;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;


public class CraftingRecipes {
    List<ShapedRecipe> recipes;





    public  void AdelhydeCraft(){
      ItemStack adel = new ItemStack(Material.RED_DYE,1);
      adel.addEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.RED+"Adelhyde");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"Adelhyde is one of the ingredients used to make drinks");
        lore.add(ChatColor.WHITE+"It's the sweet component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the sweet section have Adelhyde in them.");

        meta.setLore(lore);
        adel.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey((Plugin) this, "adelhyde");
        ShapedRecipe recept = new ShapedRecipe(key, adel);

        recept.shape("xy");
        recept.setIngredient('x',Material.MELON_SLICE);
        recept.setIngredient('y',Material.GLASS_BOTTLE);

        recipes.add(recept);
    }
    public  void Bronson_ExtractCraft(){
        ItemStack adel = new ItemStack(Material.YELLOW_DYE,1);
        adel.addEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.YELLOW+"Bronson Extract");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the bitter component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the bitter section have bronson extract in them.");

        meta.setLore(lore);
        adel.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey((Plugin) this, "bronson_extract");
        ShapedRecipe recept = new ShapedRecipe(key, adel);

        recept.shape("xy");
        recept.setIngredient('x',Material.DEAD_BUSH);
        recept.setIngredient('y',Material.GLASS_BOTTLE);

        recipes.add(recept);
    }
    public  void FlanergideCraft(){
        ItemStack adel = new ItemStack(Material.LIME_DYE,1);
        adel.addEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.GREEN+"Flanergide");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the spicy component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the spicy section have flanergide in them.");

        meta.setLore(lore);
        adel.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey((Plugin) this, "flanergide");
        ShapedRecipe recept = new ShapedRecipe(key, adel);

        recept.shape("xy");
        recept.setIngredient('x',Material.CACTUS);
        recept.setIngredient('y',Material.GLASS_BOTTLE);

        recipes.add(recept);
    }
    public  void Powered_DeltaCraft(){
        ItemStack adel = new ItemStack(Material.BLUE_DYE,1);
        adel.addEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.BLUE+"Powered_Delta");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the sour component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the sour section have bronson extract in them.");

        meta.setLore(lore);
        adel.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey((Plugin) this, "powered_delta");
        ShapedRecipe recept = new ShapedRecipe(key, adel);

        recept.shape("xy");
        recept.setIngredient('x',Material.WHEAT_SEEDS);
        recept.setIngredient('y',Material.GLASS_BOTTLE);

        recipes.add(recept);
    }
    public  void KarmotrineCraft(){
        ItemStack adel = new ItemStack(Material.WHITE_DYE,1);
        adel.addEnchantment(Enchantment.DURABILITY, 1);
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
        NamespacedKey key = new NamespacedKey((Plugin) this, "karmotrine");
        ShapedRecipe recept = new ShapedRecipe(key, adel);

        recept.shape("xy");
        recept.setIngredient('x',Material.SUGAR);
        recept.setIngredient('y',Material.GLASS_BOTTLE);

        recipes.add(recept);
    }


    public CraftingRecipes(){
        recipes = new ArrayList<>();
        AdelhydeCraft();
        Bronson_ExtractCraft();
        FlanergideCraft();
        Powered_DeltaCraft();
        KarmotrineCraft();
    }

    public List<ShapedRecipe> getRecipes() {
        return recipes;
    }
}
