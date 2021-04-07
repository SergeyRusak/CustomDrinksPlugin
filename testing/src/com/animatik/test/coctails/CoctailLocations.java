package com.animatik.test.coctails;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Map;


public class CoctailLocations {



    static private Map<Location,Ingridient> mixers;


    public static Ingridient GetMixer(Location loc){
        return mixers.get(loc);
    }
    public static void importing(){


}

    public static boolean Contains(Location loc){
        return mixers.containsKey(loc);
    }
    public  static  void Add(Location loc){
        mixers.put(loc, new Ingridient());

    }


    public static void update(int type, Location loc){
        Ingridient temp = mixers.get(loc);
        switch (type){
            case 1:
                temp.setAdelhyde(temp.getAdelhyde()+1);
                break;
            case 2:
                temp.setBronson_Extract(temp.getBronson_Extract()+1);
                break;
            case 3:
                temp.setFlanergide(temp.getFlanergide()+1);
                break;
            case 4:
                temp.setPowered_Delta(temp.getPowered_Delta()+1);
                break;
            case 5:
                temp.setKarmotrine(temp.getKarmotrine()+1);
                break;

            case 6:
                temp.setRocks(true);
                break;
            case 7:
                temp.setWait(true);
                break;
            case 8:
                temp.setBlend(true);
                break;


        }
        mixers.replace(loc,temp);



    }

    public static int GetCount(Location loc){
        Ingridient temp = mixers.get(loc);
        return temp.getAdelhyde()+temp.getBronson_Extract()+temp.getFlanergide()+temp.getPowered_Delta()+temp.getKarmotrine();
    }
public static void reset(Location loc){
        mixers.replace(loc,new Ingridient());
}




}