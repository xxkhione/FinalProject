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
        //Enemy: 40/100 | Weapon: Axe | Damage: 12
        return this.getClass().getSimpleName() + ": " + super.getHealth()
    }
}
