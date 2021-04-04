package com.animatik.test;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class Listeners implements Listener {


    @EventHandler
    public void TouchCauldron(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CAULDRON && e.hasItem())  {
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()== ChatColor.RED+"Adelhyde"){
                AddIngredient("Adelhyde",e);

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()== ChatColor.YELLOW+"Bronson Extract"){
                AddIngredient("Bronson Extract",e);

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()== ChatColor.GREEN+"Flanergide"){
                AddIngredient("Flanergide",e);

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()== ChatColor.BLUE+"Powered_Delta"){
                AddIngredient("Powered_Delta",e);

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()== ChatColor.WHITE+"Karmotrine"){
                AddIngredient("Karmotrine",e);

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.ICE){

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.CLOCK){

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.IRON_SHOVEL){

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.GLASS_BOTTLE){

            }

        }
    }
    void SetMeta (Block b){
        b.setMetadata("Adelhyde",new FixedMetadataValue(Main.plugin,0));
        b.setMetadata("Bronson Extract",new FixedMetadataValue(Main.plugin,0));
        b.setMetadata("Flanergide",new FixedMetadataValue(Main.plugin,0));
        b.setMetadata("Powered Delta",new FixedMetadataValue(Main.plugin,0));
        b.setMetadata("Karmotrine",new FixedMetadataValue(Main.plugin,0));
        b.setMetadata("Rocks",new FixedMetadataValue(Main.plugin,false));
        b.setMetadata("Wait",new FixedMetadataValue(Main.plugin,false));
        b.setMetadata("Blend",new FixedMetadataValue(Main.plugin,false));
    }

    int GetCountIngredient(Block b){
        return (b.hasMetadata("Adelhyde")?(-1):(b.getMetadata("Adelhyde").get(0).asInt()+b.getMetadata("Bronson Extract").get(0).asInt()+b.getMetadata("Flanergide").get(0).asInt()+b.getMetadata("Powered Delta").get(0).asInt()+b.getMetadata("Karmotrine").get(0).asInt()));
    }

    void AddIngredient(String ingr, PlayerInteractEvent e) {
        if (!e.getClickedBlock().hasMetadata(ingr)) {
            SetMeta(e.getClickedBlock());
        }
        if (GetCountIngredient(e.getClickedBlock()) < 20) {
            if (e.getPlayer().getInventory().getItemInMainHand().getAmount() == 1) {
                e.getPlayer().getInventory().remove(e.getPlayer().getInventory().getItemInMainHand());
            } else {
                e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);

            }
            e.getClickedBlock().setMetadata(ingr, new FixedMetadataValue(Main.plugin, e.getClickedBlock().getMetadata(ingr).get(0).asInt() + 1));

        }
    }

}
