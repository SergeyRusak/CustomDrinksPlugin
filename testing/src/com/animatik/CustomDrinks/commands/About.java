package com.animatik.CustomDrinks.commands;


import com.animatik.CustomDrinks.coctails.CoctailBook;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class About implements CommandExecutor {

    CoctailBook book;

    public About(CoctailBook book) {
        this.book = book;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(commandSender.getName());

        return false;
    }
}
