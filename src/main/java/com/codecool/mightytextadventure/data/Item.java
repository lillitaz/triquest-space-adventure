package com.codecool.mightytextadventure.data;

public class Item {
    private final String name;
    private Boolean isPickedUp;

    public Item(String name, Boolean isPickedUp) {
        this.name = name;
        this.isPickedUp = isPickedUp;
    }

    public void setIsPickedUp(boolean b) {
        this.isPickedUp = b;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", isPickedUp=" + isPickedUp +
                '}';
    }
}
