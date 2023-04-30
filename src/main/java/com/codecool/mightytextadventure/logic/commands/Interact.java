package com.codecool.mightytextadventure.logic.commands;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.DisplayElements;
import com.codecool.mightytextadventure.data.Player;
import com.codecool.mightytextadventure.data.Weapon;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;


public class Interact {

    public Game.RunningSetter runningSetter;

    public Interact(Game.RunningSetter runningSetter) {
        this.runningSetter = runningSetter;
    }

    Input input = new Input();
    Display display = new Display();


    public void action(String object, Area[] areas, Player player, Weapon weapon) {

        switch (object) {
            case "Info Terminal" -> display.printSlowly(DisplayElements.INFO_TERMINAL.getElement());
            case "Armory Closet" -> {
                player.setWeapon();
                if (weapon.getAmmunition() == 10) {
                    display.print("Nothing to do here");
                    display.print("");
                } else {
                    display.print(DisplayElements.ARMORY_CLOSET_TEXT.getElement());
                    display.print("");
                    weapon.setAmmunition(10);
                }
            }
            case "Health Station" -> {
                display.printSlowly((DisplayElements.HEALTH_STATION_TEXT.getElement()));
                if (player.getHealth() < 3) {
                    player.setHealth(3);
                    display.print(DisplayElements.HEALTH_STATION_TEXT.getElement());
                } else {
                    display.print("I am ok. I have no use for this.");
                    display.print("");
                }
            }
            case "Lab Station" -> {
                display.printSlowly(DisplayElements.LAB_STATION_THOUGHTS.getElement());
                if (player.isContaminated()) {
                    display.printSlowly(DisplayElements.CONTAMINATION.getElement());
                    String call = input.getInputFromUser();
                    switch (call.toUpperCase()) {
                        case "1", "RISK IT" -> {
                            if (Math.random() < 0.7) {
                                player.setContaminated(false);
                                display.print("It seems fortune does favor the bold...");
                                display.print("Now lets get the hell out of here!");
                                display.print("");
                            } else {
                                display.print("You were not so lucky.");
                                runningSetter.setRunning(false);
                            }
                        }
                        case "2", "TAKE YOUR CHANCES" -> {
                            display.printSlowly("I think the process contains traces of shellfish waste, and I might be allergic to that.");
                            display.printSlowly("So I can´t risk it out of a general sense of selfishness of course.");
                            display.print("");
                        }
                    }

                } else {
                    display.printSlowly("It seems I am good to go.");
                    display.printSlowly("Now lets get the hell out of here!");
                }
            }
            case "Navigator Terminal" -> {
                //change Direction to sun(make direction boolean)
                player.setChangedCourse(true);
                display.printSlowly("Course changed to the Sun.");
            }
            case "Power Controls" -> {
                //Open Path
                String changePath;
                if (areas[0].isAccess() && areas[1].isAccess()) {
                    display.printSlowly("Which Path will you open up");
                    display.printSlowly("\t1.To Escape Pods");
                    display.printSlowly("\t2.To Command Bridge");
                    changePath = input.getInputFromUser();
                    switch (changePath.toUpperCase()) {
                        case "1", "TO ESCAPE PODS", "ESCAPE PODS": {
                            areas[0].setAccess(false);
                            areas[1].setAccess(false);
                            areas[2].setAccess(false);
                            areas[4].setAccess(false);
                            areas[5].setAccess(true);
                            areas[6].setAccess(true);
                        }
                        break;
                        case "2", "TO COMMAND BRIDGE", "COMMAND BRIDGE": {
                            areas[0].setAccess(false);
                            areas[1].setAccess(false);
                            areas[2].setAccess(true);
                            areas[4].setAccess(true);
                            areas[5].setAccess(false);
                            areas[6].setAccess(false);
                        }
                    }
                } else if (areas[2].isAccess() && areas[4].isAccess()) {
                    display.printSlowly("Which Path will you open up");
                    display.printSlowly("\t1.To Living Quarters");
                    display.printSlowly("\t2.To Escape Pods");
                    changePath = input.getInputFromUser();
                    switch (changePath.toUpperCase()) {
                        case "1", "TO LIVING QUARTERS", "LIVING QUARTERS": {
                            areas[0].setAccess(true);
                            areas[1].setAccess(true);
                            areas[2].setAccess(false);
                            areas[4].setAccess(false);
                            areas[5].setAccess(false);
                            areas[6].setAccess(false);
                        }
                        break;
                        case "2", "TO ESCAPE PODS", "ESCAPE PODS": {
                            areas[0].setAccess(false);
                            areas[1].setAccess(false);
                            areas[2].setAccess(false);
                            areas[4].setAccess(false);
                            areas[5].setAccess(true);
                            areas[6].setAccess(true);
                        }

                    }
                } else if (areas[5].isAccess() && areas[6].isAccess()) {
                    display.printSlowly("Which Path will you open up");
                    display.printSlowly("\t1.To Living Quarters");
                    display.printSlowly("\t2.To Command Bridge");
                    changePath = input.getInputFromUser();
                    switch (changePath.toUpperCase()) {
                        case "1", "TO LIVING QUARTERS", "LIVING QUARTERS": {
                            areas[0].setAccess(true);
                            areas[1].setAccess(true);
                            areas[2].setAccess(false);
                            areas[4].setAccess(false);
                            areas[5].setAccess(false);
                            areas[6].setAccess(false);
                        }
                        break;
                        case "2", "TO COMMAND BRIDGE", "COMMAND BRIDGE": {
                            areas[0].setAccess(false);
                            areas[1].setAccess(false);
                            areas[2].setAccess(true);
                            areas[4].setAccess(true);
                            areas[5].setAccess(false);
                            areas[6].setAccess(false);
                        }
                    }
                }
                display.printSlowly("A new Path has opened up!");
            }
            case "Escape Button" -> {
                if (!player.isHasKey()) {
                    display.print("I need a key card to use the Escape Pods, the Cap´n should have one");
                    display.print("");
                } else {
                    if (!player.isContaminated() && player.isChangedCourse()) {
                        display.printSlowly(DisplayElements.BAD_END.getElement());
                    } else {
                        display.printSlowly(DisplayElements.GOOD_END.getElement());
                    }
                    runningSetter.setRunning(false);
                }
            }

        }
    }
}

