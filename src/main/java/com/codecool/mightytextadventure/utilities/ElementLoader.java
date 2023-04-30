package com.codecool.mightytextadventure.utilities;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.Item;
import com.codecool.mightytextadventure.data.StaticObject;

import java.util.ArrayList;

public class ElementLoader {
    private static final Area[] areas = new Area[7];

    public static Area[] loadAreas() {

        ArrayList<Area> subsequenceAreasOfArmory = new ArrayList<>();
        ArrayList<Area> subsequenceAreasOfLab = new ArrayList<>();
        ArrayList<Area> subsequenceAreasOfMedBay = new ArrayList<>();
        ArrayList<Area> subsequenceAreasOfGeneratorRoom = new ArrayList<>();
        ArrayList<Area> subsequenceAreasOfCommandBridge = new ArrayList<>();
        ArrayList<Area> subsequenceAreasOfEscapePod = new ArrayList<>();
        ArrayList<Area> subsequenceAreasOfLivingQuarters = new ArrayList<>();
        areas[5] = new Area("Lab", subsequenceAreasOfLab, loadLabItems(), loadLabStaticObject(), true, false);
        areas[6] = new Area("Escape Pod", subsequenceAreasOfEscapePod, loadEscapePodItems(), loadEscapePodRoomStaticObject(), true, false);
        areas[4] = new Area("Med Bay", subsequenceAreasOfMedBay, loadMedBayItems(), loadMedBayStaticObject(), true, false);
        areas[3] = new Area("Generator Room", subsequenceAreasOfGeneratorRoom, loadGeneratorItems(), loadGeneratorRoomObject(), false, true);
        areas[2] = new Area("Command Bridge", subsequenceAreasOfCommandBridge, loadCommandBridgeItems(), loadCommandBridgeStaticObject(), false, false);
        areas[1] = new Area("Armory", subsequenceAreasOfArmory, loadArmoryItems(), loadArmoryStaticObject(), false, true);
        areas[0] = new Area("Living Quarters", subsequenceAreasOfLivingQuarters, loadLivingQuarterItems(), loadLivingQuarterStaticObjects(), false, true);
        subsequenceAreasOfLivingQuarters.add(areas[1]);
        subsequenceAreasOfArmory.add(areas[0]);
        subsequenceAreasOfArmory.add(areas[3]);

        subsequenceAreasOfGeneratorRoom.add(areas[1]);
        subsequenceAreasOfGeneratorRoom.add(areas[4]);
        subsequenceAreasOfGeneratorRoom.add(areas[5]);

        subsequenceAreasOfMedBay.add(areas[3]);
        subsequenceAreasOfMedBay.add(areas[2]);

        subsequenceAreasOfCommandBridge.add(areas[4]);

        subsequenceAreasOfLab.add(areas[3]);
        subsequenceAreasOfLab.add(areas[6]);

        subsequenceAreasOfEscapePod.add(areas[5]);
        return areas;
    }

    private static StaticObject loadLivingQuarterStaticObjects() {
        return new StaticObject("Info Terminal");
    }

    private static StaticObject loadArmoryStaticObject() {
        return new StaticObject("Armory Closet");
    }

    private static StaticObject loadMedBayStaticObject() {
        return new StaticObject("Health Station");
    }

    private static StaticObject loadLabStaticObject() {
        return new StaticObject("Lab Station");
    }

    private static StaticObject loadCommandBridgeStaticObject() {
        return new StaticObject("Navigator Terminal");
    }

    private static StaticObject loadGeneratorRoomObject() {
        return new StaticObject("Power Controls");
    }

    private static StaticObject loadEscapePodRoomStaticObject() {
        return new StaticObject("Escape Button");
    }

    private static Item[] loadLivingQuarterItems() {
        Item[] livingQuartersItems = new Item[1];
        livingQuartersItems[0] = new Item("Water Bottle", false);
        return livingQuartersItems;
    }

    public static Item[] loadArmoryItems() {
        Item[] armoryItems = new Item[1];
        armoryItems[0] = new Item("Armor", false);
        return armoryItems;
    }

    public static Item[] loadCommandBridgeItems() {
        Item[] commandBridgeItems = new Item[1];
        commandBridgeItems[0] = new Item("Key Card", false);
        return commandBridgeItems;
    }

    public static Item[] loadGeneratorItems() {
        Item[] generatorItems = new Item[1];
        generatorItems[0] = new Item("Screwdriver", false);
        return generatorItems;
    }

    public static Item[] loadLabItems() {
        Item[] labItems = new Item[1];
        labItems[0] = new Item("Guitar", false);
        return labItems;
    }

    public static Item[] loadMedBayItems() {
        Item[] medBayItems = new Item[1];
        medBayItems[0] = new Item("Scissor", false);
        return medBayItems;
    }

    public static Item[] loadEscapePodItems() {
        Item[] escapePodItems = new Item[1];
        escapePodItems[0] = new Item("Space Suit", false);
        return escapePodItems;
    }
}
