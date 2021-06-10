package com.animatik.test.commands;


import com.animatik.test.coctails.Coctail;
import com.animatik.test.coctails.CoctailBook;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;


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
