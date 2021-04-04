package com.animatik.test.coctails;

import org.bukkit.Location;

import java.util.Map;

public class CoctailsmixersLocations {
    static public Map<Location,Ingridient> mixers;



    public CoctailsmixersLocations() {

    }

}
class Ingridient{
    int Adelhyde;
    int Bronson_Extract;
    int Flanergide;
    int Powered_Delta;
    int Karmotrine;
    boolean rocks;
    boolean wait;
    boolean blend;

    public Ingridient(int adelhyde, int bronson_Extract, int flanergide, int powered_Delta, int karmotrine, boolean rocks, boolean wait, boolean blend) {
        Adelhyde = adelhyde;
        Bronson_Extract = bronson_Extract;
        Flanergide = flanergide;
        Powered_Delta = powered_Delta;
        Karmotrine = karmotrine;
        this.rocks = rocks;
        this.wait = wait;
        this.blend = blend;
    }

    public int getAdelhyde() {
        return Adelhyde;
    }

    public int getBronson_Extract() {
        return Bronson_Extract;
    }

    public int getFlanergide() {
        return Flanergide;
    }

    public int getPowered_Delta() {
        return Powered_Delta;
    }

    public int getKarmotrine() {
        return Karmotrine;
    }

    public boolean isRocks() {
        return rocks;
    }

    public boolean isWait() {
        return wait;
    }

    public boolean isBlend() {
        return blend;
    }
}
