/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:08 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.model;
 */
package edu.neumont.csc150.model;

import java.util.Random;

public class Enemy extends Figure {
    public static final int BASE_HEALTH = 100;
    public Enemy(){
        super();
    }

    public Enemy(Arsenal weapon, int damage, int health, int maxHealth){
        super("Enemy", weapon, damage, health, maxHealth);
    }

    /**
     * This method allows for the enemy to dodge, which decreases the amount of overall damage the enemy takes
     * The method also reduces the health from the enemy
     * @param damage the method uses this parameter to deal damage to the enemy
     * @return it then returns the total damage taken from the player
     */
    @Override
    public int takeDamage(int damage) {
        int block = new Random().nextInt(50) + 1;
        if (block == 19 ){
            damage -= (int)(damage * 0.3f);
        }
        setHealth(getHealth() - damage, getMaxHealth());
        if(getHealth() == Figure.MIN_HEALTH){
            setAlive(false);
        }
        return damage;

    }

    /**
     * this method attacks the player and checks if they are dead after they are attacked
     * there is also a possibility for a critical attack
     * @param player the method uses the enemy parameter to check the current health of the player and is also used to call the takeDamage method to deal damage
     * @return this returns the player taking damage
     */
    @Override
    public int attack(Figure player) {
        int attack = getTotalDamage(getDamage(), getWeaponDamage());
        int crit = new Random().nextInt(100)+ 1;
        if(crit == 25){
            attack += 10;
        }
        if(player.getHealth() == 0){
            setAlive(false);
        }
        return player.takeDamage(attack);
    }


    @Override
    public String toString() {
        //Enemy: 40/100 | Weapon: Axe | Damage: 12
        return this.getClass().getSimpleName() + ": " + getHealth() + "/" + getMaxHealth()
                + " | Weapon:" + getWeapon() + " | Damage:" + getTotalDamage(getDamage(), getWeaponDamage());
    }
}
