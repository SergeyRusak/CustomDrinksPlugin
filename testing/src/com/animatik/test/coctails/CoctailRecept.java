package com.animatik.test.coctails;

public class CoctailRecept {
    private int Adelhyde;
    private int Bronson_Extract;
    private int Flanergide;
    private int Powered_Delta;
    private int Karmotrine;
    private boolean optionalKarmotrine;
    private boolean need_rocks;
    private boolean need_wait;
    private boolean need_blend;

    public CoctailRecept(int adelhyde, int bronson_Extract, int flanergide, int powered_Delta, int karmotrine, boolean need_rocks, boolean need_wait, boolean need_blend) {
        Adelhyde = adelhyde;
        Bronson_Extract = bronson_Extract;
        Flanergide = flanergide;
        Powered_Delta = powered_Delta;
        Karmotrine = karmotrine;
        this.need_rocks = need_rocks;
        this.need_wait = need_wait;
        this.need_blend = need_blend;
    }



    public void setOptionalKarmotrine(boolean optionalKarmotrine) {
        this.optionalKarmotrine = optionalKarmotrine;
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

    public boolean isOptionalKarmotrine() {
        return optionalKarmotrine;
    }

    public boolean isNeed_rocks() {
        return need_rocks;
    }

    public boolean isNeed_wait() {
        return need_wait;
    }

    public boolean isNeed_blend() {
        return need_blend;
    }
}
