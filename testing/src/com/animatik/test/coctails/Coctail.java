package com.animatik.test.coctails;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.List;

public class Coctail {
    private String name;
    private List<String> lore;
    private Color color;
    private CoctailRecept recept;



    public ItemStack GetCoctail(){
        ItemStack potion = new ItemStack(Material.POTION, 1);

        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        meta.setColor(color);
        if (recept.getKarmotrine() > 0) meta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION,2*20*recept.getKarmotrine(), recept.getKarmotrine(), false,false,false),true);
        potion.setItemMeta(meta);
        return potion;
    }

    public void setRecept(CoctailRecept recept) {
        this.recept = recept;
    }

    public CoctailRecept getRecept() {
        return recept;
    }

    public Coctail(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }
}
