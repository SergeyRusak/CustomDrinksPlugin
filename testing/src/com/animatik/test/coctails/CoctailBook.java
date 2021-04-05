package com.animatik.test.coctails;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CoctailBook{
    List<Coctail> book;
    Gson gson = new Gson();


    public CoctailBook(){
        Gson gson = new Gson();

        Type type = new TypeToken<List<Coctail>>(){}.getType();
        try {
            book = gson.fromJson(new FileReader("plugins/Coctails/Coctails.json"),type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    public List<Coctail> getBook() {
        return book;
    }
    public Coctail getCoctailfromBook(int Adelhyde,int Flanergide,int Bronson_Extract,int Powered_Delta,int Karmotrine, boolean rocks, boolean wait, boolean blend){
        for (Coctail c:book) {
            int size =c.compare(Adelhyde,Flanergide,Bronson_Extract,Powered_Delta, Karmotrine,rocks,wait,blend);
            if (size != 0){
                return c;

            }


        }
        int[] color =  {0,0,0};
        List<String> lore = new ArrayList<>();
        lore.add("you get this drink when the creation process is disrupted.");
        lore.add("Follow the directions strictly to get a normal drink.");
        Coctail co =  new Coctail("Messed up drink",color,Adelhyde,Bronson_Extract,Flanergide,Powered_Delta,Karmotrine,rocks,wait,blend);
        co.setLore(lore);

        return  co;
    }
}
