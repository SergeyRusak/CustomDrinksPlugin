package com.animatik.test.tech;

import com.animatik.test.Main;
import com.animatik.test.coctails.Coctail;
import com.animatik.test.coctails.CoctailLocations;
import com.animatik.test.coctails.Ingridient;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public class ListenerTouchCauldrone {

    public static void AddIngredient(String ingr, PlayerInteractEvent e){
        AddIngredient(ingr,e,true);
    }
    public static void AddIngredient(String ingr, PlayerInteractEvent e, boolean remove) {


        if (!CoctailLocations.Contains(e.getClickedBlock().getLocation())) {
            CoctailLocations.Add(e.getClickedBlock().getLocation());
        }


        if (    (ingr.equals("Wait")&& !CoctailLocations.GetMixer(e.getClickedBlock().getLocation()).isWait()    )||
                (ingr.equals("Rock")&& !CoctailLocations.GetMixer(e.getClickedBlock().getLocation()).isRocks()     )||
                (ingr.equals("Blend")&& !CoctailLocations.GetMixer(e.getClickedBlock().getLocation()).isBlend()   )||
                CoctailLocations.GetCount(e.getClickedBlock().getLocation()) < 20) {

            if (remove) {
                if (e.getPlayer().getInventory().getItemInMainHand().getAmount() == 1) {
                    e.getPlayer().getInventory().remove(e.getPlayer().getInventory().getItemInMainHand());
                } else {
                    e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);

                }

            }


            switch (ingr) {
                case "Adelhyde":
                    CoctailLocations.update(1, e.getClickedBlock().getLocation());
                    break;
                case "Bronson Extract":
                    CoctailLocations.update(2, e.getClickedBlock().getLocation());
                    break;
                case "Flanergide":
                    CoctailLocations.update(3, e.getClickedBlock().getLocation());
                    break;
                case "Powered_Delta":
                    CoctailLocations.update(4, e.getClickedBlock().getLocation());
                    break;
                case "Karmotrine":
                    CoctailLocations.update(5, e.getClickedBlock().getLocation());
                    break;
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
        UpdateCauldron(e.getClickedBlock());
    }


    static void UpdateCauldron (Location loc){
        if(loc.getBlock().getType().equals(Material.CAULDRON)){
            UpdateCauldron(loc.getBlock());
        }
    }
    static void UpdateCauldron(Block b) {
        int i = CoctailLocations.GetCount(b.getLocation());
        Levelled cauldronData = (Levelled) b.getBlockData();

        if (i == 0) cauldronData.setLevel(0);
        else if (i <= 10) cauldronData.setLevel(1);
        else if (i > 10 && i < 20) cauldronData.setLevel(2);
        else if (i > 19) cauldronData.setLevel(3);
        b.setBlockData(cauldronData);

    }

    public static void GetDrink(Player player, Location loc) {
        PlayerInventory inv = player.getInventory();
        if (inv.getItemInMainHand().getAmount() == 1) {
            inv.remove(inv.getItemInMainHand());
        } else {
            inv.getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);

        }

        Ingridient ingr = CoctailLocations.GetMixer(loc);
        Coctail coctail = Main.book.getCoctailfromBook(
                ingr.getAdelhyde(),
                ingr.getFlanergide(),
                ingr.getBronson_Extract(),
                ingr.getPowered_Delta(),
                ingr.getKarmotrine(),
                ingr.isRocks(),
                ingr.isWait(),
                ingr.isBlend());

        inv.addItem(coctail.GetCoctail());
        CoctailLocations.reset(loc);
        UpdateCauldron(loc);

    }









}
