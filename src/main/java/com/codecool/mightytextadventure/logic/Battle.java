package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Alien;
import com.codecool.mightytextadventure.data.Player;
import com.codecool.mightytextadventure.data.Weapon;

import java.util.Random;


public class Battle {
    private Alien alien;
    private Player player;
    private Weapon weapon;


    public Battle(Player player, Alien alien, Weapon weapon) {
        this.player = player;
        this.alien = alien;
        this.weapon = weapon;
    }

    public void chanceToDamageAlien() {
        Random random = new Random();
        int randomValue = random.nextInt(100);

        if (randomValue < 50) {
            normalHitAlien();
            spendAmmunition();
        } else if (randomValue < 80) {
            missAlien();
            spendAmmunition();
        } else {
            criticalHitAlien();
            spendAmmunition();
        }
    }

    public void chanceToDamagePlayer() {
        Random random = new Random();
        int randomValue = random.nextInt(100);
        if (randomValue < 30) {
            normalHitPlayer();
        } else if (randomValue < 80) {
            missPlayer();
        }
    }

    private void normalHitPlayer() {
        int damage = 1;
        player.setHealth(player.getHealth() - damage);
        System.out.println("You got hit! You have " + player.getHealth() + " health points left!");
        if (!player.isContaminated()) {
            player.setContaminated(true);
            System.out.println("You are infected!");
        }
    }

    private void missPlayer() {
        player.setHealth(player.getHealth());
        System.out.println("The Alien missed! You have " + player.getHealth() + " health points left!");
    }

    private void normalHitAlien() {
        int damage = 1;
        alien.setHealth(alien.getHealth() - damage);
        System.out.println("Normal hit! The alien has " + alien.getHealth() + " health points left!");
    }

    private void missAlien() {
        alien.setHealth(alien.getHealth());
        System.out.println("You missed the alien! The alien has " + alien.getHealth() + " health points left!");
    }

    private void criticalHitAlien() {
        int damage = 2;
        alien.setHealth(alien.getHealth() - damage);
        System.out.println("Headshot! The alien has " + alien.getHealth() + " health points left!");
    }

    private void spendAmmunition() {
        int shot = 1;
        weapon.setAmmunition(weapon.getAmmunition() - shot);
        System.out.println("You have " + weapon.getAmmunition() + " ammunition left!");
    }
}
