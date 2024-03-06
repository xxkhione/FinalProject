/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:08 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.model;
 */
package edu.neumont.csc150.model;

import java.util.Random;

public class Player extends Figure {
    public final static int MAX_HEALTH = 100;
    public final static int BASE_DAMAGE = 7;

    public Player(String name){
        super(name, Arsenal.BOW, BASE_DAMAGE, MAX_HEALTH, MAX_HEALTH);
    }
    public Player(String name, Arsenal weapon, int damage, int health, int maxHealth){
        super(name, weapon, damage, health, maxHealth);
    }

    /**
     * This method allows for the player to dodge, which decreases the amount of overall damage the player takes
     * The method also reduces the health from the player
     * @param damage the method uses this parameter to deal damage to the player
     * @return it then returns the total damage taken from the enemy
     */
    @Override
    public int takeDamage(int damage) {
        int block = new Random().nextInt(50) + 1;
        if (block == 19 ){
            damage -= (int)(damage * 0.3f);
        }
        setHealth(getHealth() - damage, MAX_HEALTH);
        if(getHealth() == Figure.MIN_HEALTH){
            setAlive(false);
        }
        return damage;
    }

    /**
     * this method attacks the enemy and checks if they are dead after they are attacked
     * there is also a possibility for a critical attack
     * @param enemy the method uses the enemy parameter to check the current health of the enemy and also is also used to call the takeDamage method to deal damage
     * @return this returns the enemy taking damage
     */
    @Override
    public int attack(Figure enemy) {
        int attack = getTotalDamage(getDamage(), getWeaponDamage());
        int crit = new Random().nextInt(100)+ 1;
        if (crit == 10){
            attack += 10;
        }
        if(enemy.getHealth() == Figure.MIN_HEALTH){
            setAlive(false);
        }
        return enemy.takeDamage(attack);
    }

    @Override
    public String toString() {
        //John: 20/100 | Weapon: Bow | Damage: 15
         return getName() + ": " + getHealth() + "/" + getMaxHealth()
                + " | Weapon:" + getWeapon() + " | Damage:" + getTotalDamage(getDamage(), getWeaponDamage());
    }
}
