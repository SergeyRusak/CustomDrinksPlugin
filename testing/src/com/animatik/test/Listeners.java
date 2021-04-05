package com.animatik.test;

import com.animatik.test.coctails.Coctail;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.metadata.FixedMetadataValue;


public class Listeners implements Listener {


    @EventHandler
    public void TouchCauldron(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CAULDRON && e.hasItem())  {
            Main.Consoleinfo(e.getPlayer().getInventory().getItem(EquipmentSlot.HAND).getItemMeta().getDisplayName());
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
                AddBoolIngredient("Rock",e,true);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.CLOCK){
                AddBoolIngredient("Wait",e,false);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.IRON_SHOVEL){
                AddBoolIngredient("Blend",e,true);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.GLASS_BOTTLE){
                if (GetCountIngredient(e.getClickedBlock())>0){

                    if (e.getPlayer().getInventory().getItemInMainHand().getAmount() == 1) {
                        e.getPlayer().getInventory().remove(e.getPlayer().getInventory().getItemInMainHand());
                    } else {
                        e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);

                    }
                    Coctail coctail = Main.book.getCoctailfromBook(e.getClickedBlock().getMetadata("Adelhyde").get(0).asInt(),
                                                                e.getClickedBlock().getMetadata("Bronson Extract").get(0).asInt(),
                                                                e.getClickedBlock().getMetadata("Flanergide").get(0).asInt(),
                                                                e.getClickedBlock().getMetadata("Powered Delta").get(0).asInt(),
                                                                e.getClickedBlock().getMetadata("Karmotrine").get(0).asInt(),
                                                                e.getClickedBlock().getMetadata("Rock").get(0).asBoolean(),
                                                                e.getClickedBlock().getMetadata("Wait").get(0).asBoolean(),
                                                                e.getClickedBlock().getMetadata("Blend").get(0).asBoolean());

                    if (coctail.getName() !="Messed up drink"){
                        Coctail Created = new Coctail(coctail.getName(),
                                                      coctail.getColor(),
                                                      coctail.getAdelhyde(),
                                                      coctail.getBronson_Extract(),
                                                      coctail.getFlanergide(),
                                                      coctail.getPowered_Delta(),
                                                      coctail.getKarmotrine(),
                                                      coctail.isNeed_rocks(),
                                                      coctail.isNeed_wait(),
                                                      coctail.isNeed_blend());
                        Created.setLore(coctail.getLore());
                        e.getPlayer().getInventory().addItem(Created.GetCoctail());
                        SetMeta(e.getClickedBlock());


                    }
                }



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
        Main.Consoleinfo("Metadata update" + b.getMetadata("Adelhyde").size());
    }
    void UpdateCauldron(Block b){
       int i = GetCountIngredient(b);
       if (i==0){
           Levelled cauldronData = (Levelled) b.getBlockData();
           cauldronData.setLevel(0);
           b.setBlockData(cauldronData);

       }
       else if (i<=10){
           Levelled cauldronData = (Levelled) b.getBlockData();
           cauldronData.setLevel(1);
           b.setBlockData(cauldronData);

       }
       else if (i>10){
           Levelled cauldronData = (Levelled) b.getBlockData();
           cauldronData.setLevel(2);
           b.setBlockData(cauldronData);

       }
       else if (i==20){
           Levelled cauldronData = (Levelled) b.getBlockData();
           cauldronData.setLevel(3);
           b.setBlockData(cauldronData);

       }

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
    void AddBoolIngredient(String ingr, PlayerInteractEvent e, boolean remove) {
        if (!e.getClickedBlock().hasMetadata(ingr)) {
            SetMeta(e.getClickedBlock());
        }
        if (!e.getClickedBlock().getMetadata(ingr).get(0).asBoolean()) {
            if(remove) {
                if (e.getPlayer().getInventory().getItemInMainHand().getAmount() == 1) {
                    e.getPlayer().getInventory().remove(e.getPlayer().getInventory().getItemInMainHand());
                } else {
                    e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);

                }
            }
            e.getClickedBlock().setMetadata(ingr, new FixedMetadataValue(Main.plugin, true));

        }
    }

}
