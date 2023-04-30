package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.Alien;
import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Player;
import com.codecool.mightytextadventure.data.Weapon;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;
import com.codecool.mightytextadventure.utilities.ElementLoader;


public class Application {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input();
        Area[] areas = ElementLoader.loadAreas();
        Player player = new Player(3, false, false, areas[0], false, false);
        Alien aliens = new Alien(2);
        Weapon weapon = new Weapon("Laser Pistol", 8);
        Game game = new Game(areas, player, input, display, aliens, weapon);
        game.run();
    }
}
