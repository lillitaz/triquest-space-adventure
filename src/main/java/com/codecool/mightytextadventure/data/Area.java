package com.codecool.mightytextadventure.data;

import java.util.ArrayList;
import java.util.Arrays;

public class Area {
    private ArrayList<Area> subsequentAreas;
    private String name;

    private Item[] items;

    private boolean hasAlien;

    private StaticObject staticObject;

    private boolean access;

    public Area(String name, ArrayList<Area> subsequentAreas, Item[] items, StaticObject staticObject, boolean hasAlien, boolean access) {
        this.name = name;
        this.subsequentAreas = subsequentAreas;
        this.items = items;
        this.staticObject = staticObject;
        this.hasAlien = hasAlien;
        this.access = access;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public String getName() {
        return name;
    }

    public StaticObject getStaticObject() {
        return staticObject;
    }

    public Item[] getItems() {
        return items;
    }

    public ArrayList<Area> getSubsequentAreas() {
        return subsequentAreas;
    }

    public boolean hasAlien() {
        return hasAlien;
    }

    public void setHasAlien() {
        this.hasAlien = false;
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", items=" + Arrays.toString(items) +
                ", Objects=" + Arrays.toString(new StaticObject[]{staticObject}) +
                '}' +
                "access:" + access;
    }
}
