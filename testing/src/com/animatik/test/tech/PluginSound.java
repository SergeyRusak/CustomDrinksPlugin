package com.animatik.test.tech;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;

public class PluginSound {
    public Sound sound;
    public SoundCategory category;
    public float volume;
    public float pitch;


    public PluginSound(Sound sound, SoundCategory category, float volume, float pitch) {
        this.sound = sound;
        this.category = category;
        this.volume = volume;
        this.pitch = pitch;
    }

}
