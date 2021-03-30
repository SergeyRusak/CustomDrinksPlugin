package com.animatik.test.coctails;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;


public class CoctailBook{
    List<Coctail> book;
    Gson gson = new Gson();


    public CoctailBook(){
        Gson gson = new Gson();

        Type type = new TypeToken<List<Coctail>>(){}.getType();
        try {
            book = gson.fromJson(new FileReader("plugins/test/Coctail.json"),type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    public List<Coctail> getBook() {
        return book;
    }
}
