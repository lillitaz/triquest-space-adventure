package com.codecool.mightytextadventure.ui;

import com.codecool.mightytextadventure.data.DisplayElements;

public class Display {

    public void print(String element) {
        System.out.print(element);
        System.out.println(" ");
    }

    public void printSlowly(String element) {
        System.out.println(" ");
        for (int i = 0; i < element.length(); i++) {
            System.out.print(element.charAt(i));
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(DisplayElements.ERROR.getElement());
            }
        }
        System.out.println(" ");
    }

    public void printMediumSpeed(String element) {
        System.out.println(" ");
        for (int i = 0; i < element.length(); i++) {
            System.out.print(element.charAt(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(DisplayElements.ERROR.getElement());
            }
        }
        System.out.println(" ");
    }
}
