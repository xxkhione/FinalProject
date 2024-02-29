/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:08 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.model;
 */
package edu.neumont.csc150.model;

import java.util.Random;

public class Player extends Character{
    public final static int MAX_HEALTH = 100;

    @Override
    public int takeDamage(int damage) {
        int block = new Random().nextInt(50) + 1;
        if (block == 19 ){
            damage -= (int)(damage * 0.3f);
        }
        setHealth(getHealth() - damage, MAX_HEALTH);
        return damage;
    }

    @Override
    public int attack(int damage) {

    }

    @Override
    public String toString() {
        return "Player Name:" + super.getName() +
                "Player health:" + super.getHealth() +
                "Player Weapon:" + super.getWeapon();
    }
}
