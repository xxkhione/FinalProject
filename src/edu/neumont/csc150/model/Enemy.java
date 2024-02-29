/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:08 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.model;
 */
package edu.neumont.csc150.model;

public class Enemy extends Character{



    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public void attack(int damage) {

    }


    @Override
    public String toString() {
        return "Enemy Health" + super.getHealth() +
                "Enemy Weapon" + super.getWeapon();
    }
}
