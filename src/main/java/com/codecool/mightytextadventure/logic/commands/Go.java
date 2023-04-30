package com.codecool.mightytextadventure.logic.commands;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Player;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.ArrayList;
import java.util.Objects;

public class Go {
    public boolean movePlayer(Player player, Display display, Input input) {
        ArrayList<Area> subsequentAreas = player.getPosition().getSubsequentAreas();
        int index;
        for (index = 0; index < subsequentAreas.size(); index++) {
            Area subsequentArea = subsequentAreas.get(index);
            display.print(index + 1 + ". " + subsequentArea.getName());
        }
        String inputOfInput = input.getInputFromUser();

        if (Objects.equals(inputOfInput, "1")) {
            if(subsequentAreas.get(0).isAccess()){
                player.setPosition(subsequentAreas.get(0));
                display.printSlowly("You walk through the passageway and enter the " + player.getPosition().getName());
                display.print("");
            }else {
                display.printSlowly("You have no maid..  access.");
                display.printSlowly("You need to rewire the power outage at the generator.");
            }
        } else if (Objects.equals(inputOfInput, "2")) {
            if(subsequentAreas.get(1).isAccess()){
                player.setPosition(subsequentAreas.get(1));
                display.printSlowly("You walk through the passageway and enter the " + player.getPosition().getName());
                display.print("");
            }
            else {
                display.printSlowly("You have no maid..  access.");
                display.printSlowly("You need to rewire the power outage at the generator.");
            }
        } else if (Objects.equals(inputOfInput, "3")) {
            if(subsequentAreas.get(2).isAccess()){
                player.setPosition(subsequentAreas.get(2));
                display.printSlowly("You walk through the passageway and enter the " + player.getPosition().getName());
                display.print("");
            }
            else {
                display.printSlowly("You have no maid..  access.");
                display.printSlowly("You need to rewire the power outage at the generator.");
            }
        }
        return true;
    }
}
