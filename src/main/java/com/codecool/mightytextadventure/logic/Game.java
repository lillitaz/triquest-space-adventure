package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.*;
import com.codecool.mightytextadventure.logic.commands.Go;
import com.codecool.mightytextadventure.logic.commands.Inspect;
import com.codecool.mightytextadventure.logic.commands.Interact;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

public class Game {

    private final Area[] areas;
    private final Input input;
    private static Display display;
    private final Player player;
    private final Weapon weapon;
    private final Alien aliens;
    Interact interact = new Interact(this::setRunning);
    private Area currentRoom;
    private String currentItem;
    private boolean isRunning;
    private boolean game;
    private boolean playerHasEncounteredAlien;


    public Game(Area[] areas, Player player, Input input, Display display, Alien aliens, Weapon weapon) {
        this.areas = areas;
        this.player = player;
        this.input = input;
        this.display = display;
        this.isRunning = true;
        this.game = true;
        this.aliens = aliens;
        this.weapon = weapon;
        this.playerHasEncounteredAlien = false;
    }

    public void run() {
        display.print(DisplayElements.INTRO_SCREEN.getElement());
        display.print(DisplayElements.TITLE.getElement());

        display.printSlowly("Do you want to start the game? (type: start or quit)");
        isRunning = true;
        while (isRunning) {
            isRunning = processInput();
        }
        display.printSlowly("Would you like to retry?");
        String decide = input.getInputFromUser();
        if (decide.equalsIgnoreCase("YES")) {
            isRunning = true;
            areas[0].setAccess(true);
            areas[1].setAccess(true);
            areas[2].setAccess(false);
            areas[4].setAccess(false);
            areas[5].setAccess(false);
            areas[6].setAccess(false);
            run();
        } else {
            display.printSlowly("BYE");
        }
    }

    private boolean processInput() {

        String userInput = input.getInputFromUser();
        switch (userInput.toUpperCase()) {
            case "START" -> {
                display.printSlowly(DisplayElements.INTRO.getElement());

                //explain commands to the user
                while (game) {
                    currentRoom = player.getPosition();
                    boolean checkAliens = currentRoom.hasAlien();
                    String currentObject = currentRoom.getStaticObject().name();
                    if (!checkAliens) {
                        for (Item item : currentRoom.getItems()) {
                            currentItem = item.getName();
                        }
                        display.print("");
                        display.print("                                  Choose Action :");
                        display.print("                                  \t1.Inspect " + currentItem);
                        display.print("                                  \t2.Interact with " + currentObject);
                        display.print("                                  \t3.Go ");
                        display.print("                                  \t4.Map ");
                        display.print("                                  \t5.Quit ");
                        display.print("");
                        game = gameStart(input.getInputFromUser());
                    } else {
                        if (!playerHasEncounteredAlien) {
                            display.print(DisplayElements.ALIEN.getElement());
                            display.printSlowly("You encounter an Alien!");
                            display.printSlowly("Press 1 to shoot.");
                            playerHasEncounteredAlien = true;
                        }
                        game = combat(input.getInputFromUser());
                    }
                }
                return false;
            }
            case "QUIT" -> {
                display.printSlowly(DisplayElements.QUIT.getElement());
                return false;
            }
            default -> {
                display.printSlowly(DisplayElements.INPUT_ERROR.getElement());
                return true;
            }
        }
    }

    @FunctionalInterface
    public interface RunningSetter {
        void setRunning(boolean running);
    }

    private boolean gameStart(String command) {
        currentRoom = player.getPosition();
        String currentObject = currentRoom.getStaticObject().name();
        switch (command.toUpperCase()) {
            case "INSPECT", "1" -> {
                // after inspect command every Item in the room is set to isPickedUp true
                Inspect inspect = new Inspect(player);
                String item = null;
                int index;
                for (index = 0; index < inspect.getItemsOfTheCurrentArea().length; index++) {
                    item = inspect.getItemsOfTheCurrentArea()[index].getName();
                }
                display.printSlowly("You find: ");
                display.printSlowly(index + ". " + item);
                display.print("");
                return true;
            }
            case "INTERACT", "2" -> {
                //interact logic
                interact.action(currentObject, areas, player,weapon);
                if (!isRunning) return false;
                return true;
            }
            case "GO", "3" -> {
                //go to next room logic
                display.printSlowly("Where do you want to go?");
                Go go = new Go();
                return go.movePlayer(player, display, input);
            }
            case "MAP", "4" -> {
                display.print(DisplayElements.MAP.getElement());
                return true;
            }
            case "HELP", "H" -> {
                display.print(DisplayElements.GAME_MECHANICS.getElement());
                return true;
            }
            case "QUIT", "5" -> {
                display.printSlowly(DisplayElements.QUIT.getElement());
                return false;
            }
            default -> {
                display.printSlowly(DisplayElements.INPUT_ERROR.getElement());
                return true;
            }
        }
    }

    private boolean combat(String command) {
        currentRoom = player.getPosition();
        boolean hasWeapon = player.hasWeapon();
        Area afterCombat = player.getPosition();

        if (!hasWeapon) {
            display.printSlowly("You dont have a Weapon. The Alien attacks and kills you in an instant.");
            display.printMediumSpeed("\u001B[31m" + DisplayElements.YOU_DIED.getElement() + "\u001B[0m");
            return false;
        } else {
            Battle battle = new Battle(player, aliens, weapon);
                if (command.equals("1") && aliens.getHealth() >= 0) {
                    battle.chanceToDamageAlien();
                    battle.chanceToDamagePlayer();
                    if (aliens.getHealth() <= 0) {
                        display.printSlowly("You killed the Alien");
                        player.setPosition(afterCombat);
                        currentRoom.setHasAlien();
                        aliens.setHealth(2);
                        playerHasEncounteredAlien = false;
                        return true;
                    }
                    if (player.getHealth() <= 0) {
                        display.printSlowly("You are Dead!");
                        display.printMediumSpeed("\u001B[31m" + DisplayElements.YOU_DIED.getElement() + "\u001B[0m");
                        return false;
                    }
                    if (weapon.getAmmunition() <= 0) {
                        display.printSlowly("You are out of Ammunition and defenseless! The Alien kills you.");
                        display.printMediumSpeed("\u001B[31m" + DisplayElements.YOU_DIED.getElement() + "\u001B[0m");
                        return false;
                    }
                    return true;
                }
        }
        return true;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
