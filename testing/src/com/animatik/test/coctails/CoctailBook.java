package com.animatik.test.coctails;

import com.animatik.test.Main;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CoctailBook{
    static List<Coctail> book;
    Gson gson = new Gson();



    public static void GenBook(){
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
    public static Coctail getCoctailfromBook(int Adelhyde,int Flanergide,int Bronson_Extract,int Powered_Delta,int Karmotrine, boolean rocks, boolean wait, boolean blend){
        if (book.get(0) == null) GenBook();


        Main.Consoleinfo("Adelhyde:"+Adelhyde);
        Main.Consoleinfo("Flanergide:"+Flanergide);
        Main.Consoleinfo("Bronson_Extract:"+Bronson_Extract);
        Main.Consoleinfo("Powered_Delta:"+Powered_Delta);
        Main.Consoleinfo("Karmotrine:"+Karmotrine);
        Main.Consoleinfo("Rocks:"+ rocks);
        Main.Consoleinfo("Aged:"+wait);
        Main.Consoleinfo("Blend:"+blend);
        for (Coctail c:book) {

            Main.Consoleinfo(c.getName());
            int size =c.compare(Adelhyde,Flanergide,Bronson_Extract,Powered_Delta, Karmotrine,rocks,wait,blend);
            Main.Consoleinfo(c.getName()+" "+ size);
            if (size != 0){
                Coctail coctail;
                coctail = new Coctail(c.getName()+ ((size==2)?("-(BIG)"):("")),c.getColor(), c.getAdelhyde(), c.getFlanergide(),c.getBronson_Extract(),c.getPowered_Delta(), c.getKarmotrine(),c.isNeed_rocks(),c.isNeed_wait(), c.isNeed_blend());

                coctail.setLore(c.getLore());
                coctail.setKarmotrine(Karmotrine);
                return  coctail;


            }


        }
        int[] color =  {0,0,0};
        List<String> lore = new ArrayList<>();
        lore.add("You get this drink when the creation process is disrupted.");
        lore.add("Follow the directions strictly to get a normal drink.");
        Coctail co =  new Coctail("Messed up drink",color,Adelhyde,Bronson_Extract,Flanergide,Powered_Delta,Karmotrine,rocks,wait,blend);
        co.setLore(lore);

        return  co;
    }

    public static void CheckConflicts(){
        int collides = 0;
        for (int i = 0; i < book.size(); i++) {
            for (int j = i; j < book.size() ; j++) {
                if (book.get(i).comapareHard(book.get(j))){
                    collides++;
                    Main.Consoleinfo("Warning! Same drinks: " + book.get(i).getName() + " and " +book.get(j).getName());
                }
            }
        }
        if (collides != 0) Main.Consoleinfo("Recipe Conflicts:" + collides);


    }

}
