package com.animatik.CustomDrinks;

import com.animatik.CustomDrinks.coctails.BookRecipe;
import com.animatik.CustomDrinks.coctails.CoctailBook;
import com.animatik.CustomDrinks.coctails.CoctailLocations;
import com.animatik.CustomDrinks.tech.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class PreLoad {

    public static ItemStack RecipeBook;
    public static ItemStack Adelhyde,Bronson_Extract,Flanergide,Powered_Delta,Karmotrine, forRock, forAged, forBlend, forDrink;
    public static CoctailBook Coctailbook;

    public static  Plugin plugin;



    private static void RecipeBook(){
        ShapelessRecipe recept = new ShapelessRecipe(NamespacedKey.minecraft("recbook"), BookRecipe.GetBook());
        recept.addIngredient(Material.WRITABLE_BOOK);
        recept.addIngredient(Material.GLASS_BOTTLE);
        RecipeBook = BookRecipe.GetBook();
        Bukkit.addRecipe(recept);
    }
    private static void AdelhydeCraft(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"Adelhyde is one of the ingredients used to make drinks");
        lore.add(ChatColor.WHITE+"It's the sweet component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the sweet section have Adelhyde in them.");
        Adelhyde = IngrToItem(Material.RED_DYE,ChatColor.RED+"Adelhyde",lore);
        ingredientCraft( Adelhyde,"adelhyde",Material.MELON_SLICE);
    }
    private static void Bronson_ExtractCraft(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the bitter component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the bitter section have bronson extract in them.");
        Bronson_Extract = IngrToItem(Material.YELLOW_DYE,ChatColor.YELLOW+"Bronson Extract",lore);
        ingredientCraft(Bronson_Extract,"bronson_extract",Material.DEAD_BUSH);
    }
    private static void FlanergideCraft(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the spicy component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the spicy section have flanergide in them.");
        Flanergide = IngrToItem(Material.LIME_DYE,ChatColor.GREEN+"Flanergide",lore);
        ingredientCraft(Flanergide, "flanergide", Material.CACTUS);
    }
    private static void Powered_DeltaCraft(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"It's the sour component in drinks.");
        lore.add(ChatColor.WHITE+"All drinks in the sour section have bronson extract in them.");
        Powered_Delta = IngrToItem(Material.BLUE_DYE,ChatColor.BLUE+"Powered Delta",lore);
        ingredientCraft(Powered_Delta, "powered_delta", Material.WHEAT_SEEDS);

    }
    private static void KarmotrineCraft(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"Karmotrine is an alcoholic component and ");
        lore.add(ChatColor.WHITE+"can make clients drunk if served on big amounts.");
        lore.add(ChatColor.WHITE+"Some drinks can have optional Karmotrine so");
        lore.add(ChatColor.WHITE+"bartender should not add it if he wants to keep drink non-alcoholic.");

        Karmotrine = IngrToItem(Material.WHITE_DYE,ChatColor.WHITE+"Karmotrine",lore);
        ingredientCraft(Karmotrine, "karmotrine",Material.SUGAR);

    }
    private static ItemStack IngrToItem(Material output,String name,List<String> lore){
        ItemStack adel = new ItemStack(output,1);
        adel.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(name);

        meta.setLore(lore);
        adel.setItemMeta(meta);

        return adel;
    }

    private  static void ingredientCraft(ItemStack item, String key, Material ingridient){


        ShapelessRecipe recept = new ShapelessRecipe(NamespacedKey.minecraft(key), item);
        recept.addIngredient(ingridient);
        recept.addIngredient(Material.GLASS_BOTTLE);
        Bukkit.addRecipe(recept);
    }

    private static void preloadIng(){
        AdelhydeCraft();
        FlanergideCraft();
        Bronson_ExtractCraft();
        Powered_DeltaCraft();
        KarmotrineCraft();

        forBlend = new ItemStack(Material.IRON_SHOVEL);
        forAged = new ItemStack(Material.CLOCK);
        forRock = new ItemStack(Material.ICE);
        forDrink = new ItemStack(Material.GLASS_BOTTLE);



    }

    private static  void Coctail_book(){
        Coctailbook = new CoctailBook();
        Coctailbook.GenBook();
    }


    private static void Listenering(Plugin plug){
        plugin = plug;
        Listeners events = new Listeners();
        getServer().getPluginManager().registerEvents(events,plug);
    }

// init

    public static void Startup(Plugin plugin){
        Coctail_book();
        RecipeBook();
        preloadIng();
        CoctailLocations.importing();
        Sounds.PreLoadSounds();
    }

    public static void Finish(Plugin plugin){

        CoctailLocations.exporting();
    }

}
