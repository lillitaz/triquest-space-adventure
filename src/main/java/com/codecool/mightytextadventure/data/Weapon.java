package com.codecool.mightytextadventure.data;

public class Weapon {
    public String name;
    private int ammunition;

    public Weapon(String name, int ammunition) {
        this.name = name;
        this.ammunition = ammunition;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int ammo) {
        this.ammunition = ammo;
    }
}
