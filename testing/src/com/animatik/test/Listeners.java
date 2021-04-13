package com.animatik.test;

import com.animatik.test.coctails.Coctail;
import com.animatik.test.coctails.CoctailLocations;
import com.animatik.test.coctails.Ingridient;
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

import java.util.List;


public class Listeners implements Listener {


    @EventHandler
    public void TouchCauldron(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CAULDRON && e.hasItem())  {
            Main.Consoleinfo(e.getPlayer().getInventory().getItem(EquipmentSlot.HAND).getItemMeta().getDisplayName());
            Main.Consoleinfo(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()+ " ----- " +ChatColor.RED+"Adelhyde");




            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED+"Adelhyde")){
                AddIngredient("Adelhyde",e);
                Main.Consoleinfo("Adelhyde ready");

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW+"Bronson Extract")){
                AddIngredient("Bronson Extract",e);
                Main.Consoleinfo("Bronson ready");

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN+"Flanergide")){
                AddIngredient("Flanergide",e);
                Main.Consoleinfo("Flaner ready");

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE+"Powered_Delta")){
                AddIngredient("Powered_Delta",e);
                Main.Consoleinfo("delta ready");

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.WHITE+"Karmotrine")){
                AddIngredient("Karmotrine",e);
                Main.Consoleinfo("Karmo ready");

            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.ICE){
                AddBoolIngredient("Rock",e,true);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.IRON_HOE){
                AddBoolIngredient("Wait",e,false);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.IRON_SHOVEL){
                AddBoolIngredient("Blend",e,false);
            }
            else if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.GLASS_BOTTLE){
                if (CoctailLocations.GetCount(e.getClickedBlock().getLocation())>0){

                    if (e.getPlayer().getInventory().getItemInMainHand().getAmount() == 1) {
                        e.getPlayer().getInventory().remove(e.getPlayer().getInventory().getItemInMainHand());
                    } else {
                        e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);

                    }

                    Ingridient ingr = CoctailLocations.GetMixer(e.getClickedBlock().getLocation());
                    Main.Consoleinfo(Main.book.getCoctailfromBook(0,0,0,0,0,false,false,false).getName());
                    Coctail coctail = Main.book.getCoctailfromBook(
                                ingr.getAdelhyde(),
                                ingr.getBronson_Extract(),
                                ingr.getFlanergide(),
                                ingr.getPowered_Delta(),
                                ingr.getKarmotrine(),
                                ingr.isRocks(),
                                ingr.isWait(),
                                ingr.isBlend());

                    coctail.setKarmotrine(ingr.getKarmotrine());
                    if (coctail.getName().equals("Messed up drink")){

                        List<String> templore = coctail.getLore();


                        coctail = new Coctail(coctail.getName(),
                                                      coctail.getColor(),
                                                      coctail.getAdelhyde(),
                                                      coctail.getBronson_Extract(),
                                                      coctail.getFlanergide(),
                                                      coctail.getPowered_Delta(),
                                                      coctail.getKarmotrine(),
                                                      coctail.isNeed_rocks(),
                                                      coctail.isNeed_wait(),
                                                      coctail.isNeed_blend());
                        coctail.setLore(templore);




                    }
                    e.getPlayer().getInventory().addItem(coctail.GetCoctail());
                    CoctailLocations.reset(e.getClickedBlock().getLocation());
                }



            }

        }
    }

    void UpdateCauldron(Block b){
       int i = CoctailLocations.GetCount(b.getLocation());
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
       else if (i>19){
           Levelled cauldronData = (Levelled) b.getBlockData();
           cauldronData.setLevel(3);
           b.setBlockData(cauldronData);

       }

    }


    void AddIngredient(String ingr, PlayerInteractEvent e) {
        if (!CoctailLocations.Contains(e.getClickedBlock().getLocation())) {
            CoctailLocations.Add(e.getClickedBlock().getLocation());
        }
        if (CoctailLocations.GetCount(e.getClickedBlock().getLocation()) < 20) {
            if (e.getPlayer().getInventory().getItemInMainHand().getAmount() == 1) {
                e.getPlayer().getInventory().remove(e.getPlayer().getInventory().getItemInMainHand());
            } else {
                e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);

            }
           switch (ingr){
               case "Adelhyde":
                   CoctailLocations.update(1,e.getClickedBlock().getLocation());
                   break;
               case "Bronson Extract":
                   CoctailLocations.update(2,e.getClickedBlock().getLocation());
                   break;
               case "Flanergide":
                   CoctailLocations.update(3,e.getClickedBlock().getLocation());
                   break;
               case "Powered_Delta":
                   CoctailLocations.update(4,e.getClickedBlock().getLocation());
                   break;
               case "Karmotrine":
                   CoctailLocations.update(5,e.getClickedBlock().getLocation());
                   break;
           }

        }
        UpdateCauldron(e.getClickedBlock());
    }
    void AddBoolIngredient(String ingr, PlayerInteractEvent e, boolean remove) {
        if (!CoctailLocations.Contains(e.getClickedBlock().getLocation())) {
            CoctailLocations.Add(e.getClickedBlock().getLocation());
        }
        if ((!CoctailLocations.GetMixer(e.getClickedBlock().getLocation()).isBlend()&& ingr == "Blend")||
                (!CoctailLocations.GetMixer(e.getClickedBlock().getLocation()).isRocks()&& ingr == "Rock")||
                (!CoctailLocations.GetMixer(e.getClickedBlock().getLocation()).isWait()&& ingr == "Wait")) {

        }
            if(remove) {
                if (e.getPlayer().getInventory().getItemInMainHand().getAmount() == 1) {
                    e.getPlayer().getInventory().remove(e.getPlayer().getInventory().getItemInMainHand());
                } else {
                    e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);

                }
            }
            switch (ingr){
                case "Rock":
                    CoctailLocations.update(6,e.getClickedBlock().getLocation());
                    break;
                case "Wait":
                    CoctailLocations.update(7,e.getClickedBlock().getLocation());
                    break;
                case "Blend":
                    CoctailLocations.update(8,e.getClickedBlock().getLocation());
                    break;


        }
    }

}
