package com.codecool.mightytextadventure.ui;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    public final String getInputFromUser() {
        return scanner.nextLine();
    }
}
