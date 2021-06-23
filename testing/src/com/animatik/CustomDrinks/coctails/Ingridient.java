package com.animatik.CustomDrinks.coctails;

public class Ingridient {
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

    public Ingridient() {
        Adelhyde = 0;
        Bronson_Extract = 0;
        Flanergide = 0;
        Powered_Delta = 0;
        Karmotrine = 0;
        this.rocks = false;
        this.wait = false;
        this.blend = false;
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

    public void setAdelhyde(int adelhyde) {
        Adelhyde = adelhyde;
    }

    public void setBronson_Extract(int bronson_Extract) {
        Bronson_Extract = bronson_Extract;
    }

    public void setFlanergide(int flanergide) {
        Flanergide = flanergide;
    }

    public void setPowered_Delta(int powered_Delta) {
        Powered_Delta = powered_Delta;
    }

    public void setKarmotrine(int karmotrine) {
        Karmotrine = karmotrine;
    }

    public void setRocks(boolean rocks) {
        this.rocks = rocks;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public void setBlend(boolean blend) {
        this.blend = blend;
    }
}
