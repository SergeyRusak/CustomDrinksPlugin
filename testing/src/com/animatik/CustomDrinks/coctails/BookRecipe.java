package com.animatik.CustomDrinks.coctails;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class BookRecipe {

    public static ItemStack GetBook(){
        List<Coctail> recipes = CoctailBook.book;

        ItemStack Book = new ItemStack(Material.WRITTEN_BOOK,1);
        BookMeta meta = (BookMeta) Book.getItemMeta();
        meta.setAuthor("Mr_Animatik_rus");
        meta.setTitle("Coctails Recipes Book");
        ArrayList<String> pages = new ArrayList<String>();
        for ( Coctail i: recipes) {
            String page = "";

            page += ChatColor.BOLD+i.getName()+"\n" + ChatColor.RESET;
            page += "_____\n";
            for (int j = 0; j <i.getLore().size()-1 ; j++) {
                page += i.getLore().get(j) +" ";
            }
            page += ChatColor.BOLD+"\n";
            page += i.getLore().get(i.getLore().size()-1);

            pages.add(page);




            page="";
            page += ChatColor.BOLD+i.getName()+"\n";
            page += "_____\n";
            page += ChatColor.DARK_AQUA+ i.getLore().get(i.getLore().size()-1)+"\"\n\n";
            page +=ChatColor.RED +"Adelhyde: "+ i.getAdelhyde()+"\n";
            page +=ChatColor.GOLD+"Bronson Extract: "+ i.getBronson_Extract()+"\n";
            page +=ChatColor.GREEN +"Flanergyde: "+ i.getFlanergide()+"\n";
            page +=ChatColor.DARK_BLUE +"Powered Delta: "+ i.getPowered_Delta()+"\n";
            page +=ChatColor.DARK_GRAY +"Karmotrine: "+ ((i.getKarmotrine() == -1)?("Optional"):(i.getKarmotrine()))+"\n";
            String prop = ChatColor.BLACK+"";
            if (i.isNeed_rocks()) prop+= "On the rocks";
            if (i.isNeed_rocks()&& i.isNeed_wait())prop+=",";
            if (i.isNeed_wait()) prop+= " Aged";
            if (i.isNeed_rocks()|| i.isNeed_wait())prop+=" and ";
            if (i.isNeed_blend()) prop+= "Blended";
                else prop += "Mixed";
            page += prop+"\n\n";

            pages.add(page);


        }
        meta.setPages(pages);

        Book.setItemMeta(meta);
        return  Book;

    }



}
