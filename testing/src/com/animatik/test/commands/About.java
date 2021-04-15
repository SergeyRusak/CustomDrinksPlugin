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






        return false;
    }
}
