package com.codecool.mightytextadventure.logic.commands;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Item;
import com.codecool.mightytextadventure.data.Player;

public class Inspect {
    private Player player;

    public Inspect(Player player) {
        this.player = player;
    }

    public Area getPlayerPosition() {
        return player.getPosition();
    }

    public Item[] getItemsOfTheCurrentArea() {
        Item[] items = getPlayerPosition().getItems();
        pickUp(items);
        return items;
    }

    private void pickUp(Item[] items) {
        int index;
        for (index = 0; index < items.length; index++) {
            if (items[index].getName().equals("Key Card")) {
                player.setHasKey(true);
            }
            items[index].setIsPickedUp(true);
        }
    }
}
