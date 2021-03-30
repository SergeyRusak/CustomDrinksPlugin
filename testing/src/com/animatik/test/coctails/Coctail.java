package com.animatik.test.coctails;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import java.util.List;

public class Coctail{
    private String name;
    private List<String> lore;
    private Color color;
    private int Adelhyde;
    private int Bronson_Extract;
    private int Flanergide;
    private int Powered_Delta;
    private int Karmotrine;
    private boolean need_rocks;
    private boolean need_wait;
    private boolean need_blend;



    public ItemStack GetCoctail(){
        ItemStack potion = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        meta.setColor(color);
        if (Karmotrine > 0) meta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION,2*20*Karmotrine, Karmotrine, false,false,false),true);
        potion.setItemMeta(meta);
        return potion;
    }



    public Coctail(String name,Color color, int adelhyde, int bronson_Extract, int flanergide, int powered_Delta, int karmotrine, boolean need_rocks, boolean need_wait, boolean need_blend) {
        this.name = name;
        this.color = color;
        Adelhyde = adelhyde;
        Bronson_Extract = bronson_Extract;
        Flanergide = flanergide;
        Powered_Delta = powered_Delta;
        Karmotrine = karmotrine;
        this.need_rocks = need_rocks;
        this.need_wait = need_wait;
        this.need_blend = need_blend;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }


    public int compare(int adel,int flane,int bronson, int delta, int karm, boolean ice, boolean wait, boolean blend) {


        if(ice == need_rocks && wait==need_wait && blend == need_blend) {

            if (adel == Adelhyde * 2 && flane == Flanergide * 2 && bronson == Bronson_Extract * 2 && delta == Powered_Delta * 2)
                if (!(Karmotrine < 0))
                    if (karm == Karmotrine * 2) return 2;
                    else {
                        return 2;
                    }
            if (adel == Adelhyde && flane == Flanergide && bronson == Bronson_Extract && delta == Powered_Delta)
                if (!(Karmotrine <0))
                    if (karm == Karmotrine) return 1;
                    else {
                        return 1;
                    }


        }
        return 0;
    }
}
