package com.codecool.mightytextadventure.data;

public class Player {
    int health;
    boolean hasWeapon;
    boolean changedCourse;
    boolean hasKey;
    boolean contaminated;
    Area position;

    public Player(int health, boolean hasKey, boolean contaminated, Area position, boolean hasWeapon, boolean changedCourse) {
        this.health = health;
        this.hasKey = hasKey;
        this.contaminated = contaminated;
        this.position = position;
        this.hasWeapon = hasWeapon;
        this.changedCourse = changedCourse;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean isContaminated() {
        return contaminated;
    }

    public void setContaminated(boolean contaminated) {
        this.contaminated = contaminated;
    }

    public Area getPosition() {
        return position;
    }

    public void setPosition(Area position) {
        this.position = position;
    }

    public boolean hasWeapon() {
        return hasWeapon;
    }

    public void setWeapon() {
        this.hasWeapon = true;
    }

    public boolean isChangedCourse() {
        return changedCourse;
    }

    public void setChangedCourse(boolean changedCourse) {
        this.changedCourse = changedCourse;
    }
}

