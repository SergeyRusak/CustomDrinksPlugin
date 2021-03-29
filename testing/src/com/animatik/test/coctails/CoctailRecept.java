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
    private boolean can_be_big;

    public CoctailRecept(int adelhyde, int bronson_Extract, int flanergide, int powered_Delta, int karmotrine, boolean need_rocks, boolean need_wait, boolean need_blend) {
        Adelhyde = adelhyde;
        Bronson_Extract = bronson_Extract;
        Flanergide = flanergide;
        Powered_Delta = powered_Delta;
        Karmotrine = karmotrine;
        this.need_rocks = need_rocks;
        this.need_wait = need_wait;
        this.need_blend = need_blend;
        this.can_be_big = adelhyde+bronson_Extract+flanergide+powered_Delta+karmotrine <=10;
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

    public boolean Can_be_big() {
        return can_be_big;
    }

    public int compare(int adel,int flane,int bronson, int delta, int karm, boolean ice, boolean wait, boolean blend) {


       if(ice == need_rocks && wait==need_wait && blend == need_blend) {

           if (can_be_big && adel == Adelhyde * 2 && flane == Flanergide * 2 && bronson == Bronson_Extract * 2 && delta == Powered_Delta * 2)
               if (!optionalKarmotrine)
                   if (karm == Karmotrine * 2) return 2;
                   else {
                       return 2;
                   }
           if (adel == Adelhyde && flane == Flanergide && bronson == Bronson_Extract && delta == Powered_Delta)
               if (!optionalKarmotrine)
                   if (karm == Karmotrine) return 1;
                   else {
                       return 1;
                   }


       }
                return 0;
    }


}
