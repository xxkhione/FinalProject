/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:08 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.model;
 */
package edu.neumont.csc150.model;

import java.util.Random;

public class Enemy extends Character{



    @Override
    public int takeDamage(int damage) {
        int block = new Random().nextInt(50) + 1;
        if (block == 19 ){
            damage -= (int)(damage * 0.3f);
        }
        setHealth(getHealth() - damage, getMaxHealth());
        return damage;

    }

    @Override
    public int attack(int damage) {
        return 0;
    }


    @Override
    public String toString() {
        //Enemy: 40/100 | Weapon: Axe | Damage: 12
        return this.getClass().getSimpleName() + ": " + super.getHealth()
    }
}
