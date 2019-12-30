package com.company;

public class Player {
    static int tired;
    int efficiency;
    static int drunkenness;
    String name;

    Player(String name) {
        tired = 0;
        this.efficiency = 100;
        drunkenness = 0;
        this.name = name;
    }

    public void setEfficiency(int tired, int drunkenness) {
        if (drunkenness < 50) {
            this.efficiency = 100 - tired + drunkenness;
        } else if (drunkenness + tired < 100) {
            this.efficiency = 100 - tired - drunkenness;
        }

        if (this.efficiency < 10) {
            this.efficiency = 10;
        }

    }

    void drunk() {
        if (Resource.beer > 0) {
            --Resource.beer;
            drunkenness += 10;
            if (tired >= 10) {
                tired -= 10;
            } else {
                tired = 0;
            }
        } else {
            System.out.println("Пива нет");
        }

    }
}
