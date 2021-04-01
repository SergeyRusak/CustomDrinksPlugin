package com.animatik.test.commands;


import com.animatik.test.coctails.Coctail;
import com.animatik.test.Main;
import com.animatik.test.coctails.CoctailBook;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class About implements CommandExecutor {

    CoctailBook book;

    public About(CoctailBook book) {
        this.book = book;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(commandSender.getName());


        Player p = (Player) commandSender;
        for (Coctail i :book.getBook()
             ) { p.getInventory().addItem(i.GetCoctail());

        }
        ItemStack adel = new ItemStack(Material.WHITE_DYE,1);
        adel.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = adel.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.WHITE+"Karmotrine");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"One of the five main ingredients for drinks.");
        lore.add(ChatColor.WHITE+"Karmotrine is an alcoholic component and ");
        lore.add(ChatColor.WHITE+"can make clients drunk if served on big amounts.");
        lore.add(ChatColor.WHITE+"Some drinks can have optional Karmotrine so");
        lore.add(ChatColor.WHITE+"bartender should not add it if he wants to keep drink non-alcoholic.");

        meta.setLore(lore);
        adel.setItemMeta(meta);
        p.getInventory().addItem(adel);





        return false;
    }
}
