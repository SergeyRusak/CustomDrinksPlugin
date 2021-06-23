package com.animatik.CustomDrinks;

import com.animatik.CustomDrinks.coctails.CoctailLocations;
import com.animatik.CustomDrinks.tech.ListenerTouchCauldrone;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class Listeners implements Listener {


    @EventHandler
    public void CancelDraing(CauldronLevelChangeEvent e){
        if (e.getReason() == CauldronLevelChangeEvent.ChangeReason.BOTTLE_FILL && CoctailLocations.GetMixer(e.getBlock().getLocation())!= null){
            e.setCancelled(true);
            ListenerTouchCauldrone.CancelFill(e);
        }
    }

    @EventHandler
    public void TouchCauldron(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK &&
            e.getClickedBlock().getType() == Material.CAULDRON &&
            e.hasItem())  {

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
