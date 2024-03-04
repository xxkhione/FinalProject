/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:08 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.model;
 */
package edu.neumont.csc150.model;

import java.util.Random;

public class Enemy extends Character{
    public Enemy(){
        super();
    }

    public Enemy(Arsenal weapon, int damage, int health, int maxHealth){
        super("Enemy", weapon, damage, health, maxHealth);
    }


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
    public int attack(Character player) {
        int attack = getTotalDamage(getDamage(), assignWeaponDamage(getWeapon()));
        int crit = new Random().nextInt(100)+ 1;
        if(crit == 25){
            attack += 10;
        }
        return attack;
    }


    @Override
    public String toString() {
        //Enemy: 40/100 | Weapon: Axe | Damage: 12
        return this.getClass().getSimpleName() + ": " + getHealth() + "/" + getMaxHealth()
                + " | Weapon:" + getWeapon() + " | Damage:" + getTotalDamage(getDamage(), assignWeaponDamage(getWeapon()));
    }
}
