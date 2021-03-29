package com.animatik.test.commands;

import com.animatik.test.coctails.Coctail;
import com.animatik.test.coctails.CoctailRecept;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

public class About implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(commandSender.getName());
        Coctail srush = new Coctail("ShugarRush", Color.SILVER);
        srush.setRecept(new CoctailRecept(1,0,5,0,5,true,false,false));
        Coctail badTouch = new Coctail(ChatColor.YELLOW + "Bad Touch", Color.GREEN);
        badTouch.setRecept(new CoctailRecept(0,0,0,0,10, true,false,false));

        Player p = (Player) commandSender;

        p.getInventory().addItem(badTouch.GetCoctail());



        return false;
    }
}
