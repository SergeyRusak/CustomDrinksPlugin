package com.animatik.test.coctails;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


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


        int r,g,b,ingr;
        ingr = recept.getAdelhyde()+recept.getPowered_Delta()+ recept.getFlanergide()+ recept.getBronson_Extract();
        ingr = (ingr==0)?(1):(ingr);
        r = (recept.getAdelhyde()+ recept.getBronson_Extract())*255/ingr;
        g = (recept.getFlanergide()+recept.getBronson_Extract())*255/ingr;
        b = recept.getPowered_Delta()*255/ingr;



        meta.setColor(Color.fromRGB(r,g,b));
        if (recept.getKarmotrine() > 0) meta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION,2*20*recept.getKarmotrine(), recept.getKarmotrine(), false,false,false),true);
        potion.setItemMeta(meta);
        return potion;
    }


    public CoctailRecept getRecept() {
        return recept;
    }

    public Coctail(String name, CoctailRecept recept) {
        this.name = name;
        this.recept = recept;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }
}
