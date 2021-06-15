package com.animatik.test.tech;

import com.animatik.test.PreLoad;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class Sounds {
  public static  PluginSound  addIngr, addRock, blend, age, pickupDrink;


 public static void  PreLoadSounds(){
     addIngr     =  new PluginSound(Sound.BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE,SoundCategory.BLOCKS,0.25f, 2.0f);
     addRock     =  new PluginSound(Sound.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE,SoundCategory.BLOCKS,0.25f, 2.0f);
     blend       =  new PluginSound(Sound.BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE,SoundCategory.BLOCKS,0.25f, 0.5f);
     age         =  new PluginSound(Sound.BLOCK_DISPENSER_DISPENSE, SoundCategory.BLOCKS, 0.25f,2.0f);
     pickupDrink =  new PluginSound(Sound.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 0.25f,0.75f);

 }

 public static  void PlaySound(PluginSound sound, Player p, Location loc){
     p.playSound(loc,sound.sound,sound.category,sound.volume,sound.pitch);
 }



}
