package com.animatik.test.coctails;

import com.animatik.test.Main;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import java.util.List;

public class Coctail{
    private String name;
    private List<String> lore;
    private int[] color;
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
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setColor(Color.fromRGB(color[0],color[1],color[2]));
        if (Karmotrine > 0) meta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION,2*20*Karmotrine, Karmotrine-1, false,false,false),true);
        potion.setItemMeta(meta);
        return potion;
    }

    public String getName() {
        return name;
    }

    public List<String> getLore() {
        return lore;
    }

    public int[] getColor() {
        return color;
    }

    public int getAdelhyde() {
        return Adelhyde;
    }

    public int getBronson_Extract() {
        return Bronson_Extract;
    }

    public int getFlanergide() {
        return Flanergide;
    }

    public int getPowered_Delta() {
        return Powered_Delta;
    }

    public int getKarmotrine() {
        return Karmotrine;
    }

    public boolean isNeed_rocks() {
        return need_rocks;
    }

    public boolean isNeed_wait() {
        return need_wait;
    }

    public boolean isNeed_blend() {
        return need_blend;
    }

    public Coctail(String name, int[] color, int adelhyde, int flanergide, int bronson_Extract,  int powered_Delta, int karmotrine, boolean need_rocks, boolean need_wait, boolean need_blend) {
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

    public boolean comapareHard(Coctail coctail){
        return  this.Adelhyde == coctail.Adelhyde &&
                this.Flanergide == coctail.Flanergide &&
                this.Bronson_Extract == coctail.Bronson_Extract &&
                this.Powered_Delta == coctail.Powered_Delta &&
                this.Karmotrine == coctail.Karmotrine &&
                this.need_blend == coctail.need_blend &&
                this.need_wait == coctail.need_wait &&
                this.need_rocks == coctail.need_rocks;
    }

    public int compare(int adel,int flane,int bronson, int delta, int karm, boolean ice, boolean wait, boolean blend) {

        if (ice==need_rocks && wait==need_wait && blend == need_blend) {
            if( adel ==Adelhyde &&
                flane == Flanergide &&
                bronson == Bronson_Extract &&
                delta == Powered_Delta)
            {
             if(Karmotrine == -1 || Karmotrine == karm)
                 if (GetCount() >10)
                     return 2;
                 else
                     return 1;
            }
            else if ( adel ==Adelhyde * 2 &&
                    flane == Flanergide * 2 &&
                    bronson == Bronson_Extract * 2 &&
                    delta == Powered_Delta * 2)
            {
                if(Karmotrine == -1 || Karmotrine * 2 == karm)
                    return 2;
            }




        }
        return 0;
    }


    public void setKarmotrine(int karmotrine) {
        Karmotrine = karmotrine;
    }

    public int GetCount(){
        return Adelhyde+Flanergide+Bronson_Extract+Powered_Delta+((Karmotrine ==-1)?(0):(Karmotrine));
    }
}
