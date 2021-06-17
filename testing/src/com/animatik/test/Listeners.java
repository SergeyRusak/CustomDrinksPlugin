package com.animatik.test;

import com.animatik.test.coctails.CoctailLocations;
import com.animatik.test.tech.ListenerTouchCauldrone;
import com.animatik.test.tech.Sounds;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.List;


public class Listeners implements Listener {


    @EventHandler
    public void CancelDraing(CauldronLevelChangeEvent e){
        if (e.getReason() == CauldronLevelChangeEvent.ChangeReason.BOTTLE_FILL && CoctailLocations.GetMixer(e.getBlock().getLocation())!= null){
            ListenerTouchCauldrone.CancelFill(e);
        }
    }

    @EventHandler
    public void TouchCauldron(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK &&
            e.getClickedBlock().getType() == Material.CAULDRON &&
            e.hasItem())  {

            Main.Consoleinfo(e.getPlayer().getInventory().getItem(EquipmentSlot.HAND).getItemMeta().getDisplayName());

           ItemStack item = e.getPlayer().getInventory().getItemInMainHand();


            if (item.isSimilar(PreLoad.Adelhyde)){
                ListenerTouchCauldrone.AddIngredient("Adelhyde",e);


            }
            else if (item.isSimilar(PreLoad.Bronson_Extract)){
                ListenerTouchCauldrone.AddIngredient("Bronson Extract",e);
            }
            else if (item.isSimilar(PreLoad.Flanergide)){
                ListenerTouchCauldrone.AddIngredient("Flanergide",e);
            }
            else if (item.isSimilar(PreLoad.Powered_Delta)){
                ListenerTouchCauldrone.AddIngredient("Powered Delta",e);
            }
            else if (item.isSimilar(PreLoad.Karmotrine)){
                ListenerTouchCauldrone.AddIngredient("Karmotrine",e);
            }
            else if (item.isSimilar(PreLoad.forRock)){
                ListenerTouchCauldrone.AddIngredient("Rock",e,true);
            }
            else if (item.isSimilar(PreLoad.forAged)){
                ListenerTouchCauldrone.AddIngredient("Age",e,false);

            }
            else if (item.isSimilar(PreLoad.forBlend)){
                ListenerTouchCauldrone.AddIngredient("Blend",e,false);
            }
            else if (item.isSimilar(PreLoad.forDrink)){
                if (CoctailLocations.GetCount(e.getClickedBlock().getLocation())>0){
                ListenerTouchCauldrone.GetDrink(e.getPlayer(),e.getClickedBlock().getLocation());

                }



            }

        }
    }
    @EventHandler
    public void DestroyCauldron(BlockBreakEvent e){
        if (CoctailLocations.Contains(e.getBlock().getLocation())){
            ListenerTouchCauldrone.DestroyCauldron(e);

        }
    }




}
