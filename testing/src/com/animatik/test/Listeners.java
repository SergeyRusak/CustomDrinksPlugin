package com.animatik.test;

import com.animatik.test.coctails.CoctailLocations;
import com.animatik.test.tech.ListenerTouchCauldrone;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.List;


public class Listeners implements Listener {


    @EventHandler
    public void TouchCauldron(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK &&
            e.getClickedBlock().getType() == Material.CAULDRON &&
            e.hasItem())  {

            Main.Consoleinfo(e.getPlayer().getInventory().getItem(EquipmentSlot.HAND).getItemMeta().getDisplayName());
            Main.Consoleinfo(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()+ " ----- " +ChatColor.RED+"Adelhyde");




            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED+"Adelhyde")){
                ListenerTouchCauldrone.AddIngredient("Adelhyde",e);

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW+"Bronson Extract")){
                ListenerTouchCauldrone.AddIngredient("Bronson Extract",e);

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN+"Flanergide")){
                ListenerTouchCauldrone.AddIngredient("Flanergide",e);

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE+"Powered_Delta")){
                ListenerTouchCauldrone.AddIngredient("Powered_Delta",e);

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.WHITE+"Karmotrine")){
                ListenerTouchCauldrone.AddIngredient("Karmotrine",e);

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.ICE){
                ListenerTouchCauldrone.AddIngredient("Rock",e,true);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.IRON_HOE){
                ListenerTouchCauldrone.AddIngredient("Wait",e,false);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.IRON_SHOVEL){
                ListenerTouchCauldrone.AddIngredient("Blend",e,false);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.GLASS_BOTTLE){
                if (CoctailLocations.GetCount(e.getClickedBlock().getLocation())>0){
                ListenerTouchCauldrone.GetDrink(e.getPlayer(),e.getClickedBlock().getLocation());

                }



            }

        }
    }




}
