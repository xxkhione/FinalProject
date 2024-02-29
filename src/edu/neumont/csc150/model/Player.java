/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:08 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.model;
 */
package edu.neumont.csc150.model;

public class Player extends Character{
    public final static int MAX_HEALTH = 100;

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public void attack(int damage) {

    }

    @Override
    protected void setHealth(int health) {
        
    }

    @Override
    public String toString() {
        return "Player Name:" + super.getName() +
                "Player health:" + super.getHealth() +
                "Player Weapon:" + super.getWeapon();
    }
}
