/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Arsenal;
import edu.neumont.csc150.model.Enemy;
import edu.neumont.csc150.model.Figure;
import edu.neumont.csc150.model.Game;

public class EnemyDifficultyManager {

    /**
     * Increases the enemy difficulty every 5 trials.
     * The health increases by 10 each time. Creates a new instance of an enemy.
     * @param game - the current instance of the game.
     * @param trialNumber - the current trial number that the user is on.
     * @return a new enemy with the increased attributes.
     */
    public static Figure increaseDifficulty(Game game, int trialNumber){
        Figure newEnemy;
        int health = game.getEnemy().getHealth();
        int damage = game.getEnemy().getDamage();
        Arsenal weapon = game.generateNewWeapon();
        if(trialNumber >= 5 && trialNumber < 10) {
            health += 10;
            return newEnemy = new Enemy(weapon, damage, health, health);
        } else if(trialNumber >= 10 && trialNumber < 15){
            health += 20;
            return newEnemy = new Enemy(weapon, damage, health, health);
        } else if(trialNumber >= 15 && trialNumber < 20){
            health += 30;
            return newEnemy = new Enemy(weapon, damage, health, health);
        } else if(trialNumber >= 20 && trialNumber < Game.MAX_TRIALS){
            health += 40;
            return newEnemy = new Enemy(weapon, damage, health, health);
        } else if(trialNumber == Game.MAX_TRIALS){ //Final Boss!
            health += 200;
            damage += 45;
            return newEnemy = new Enemy(weapon, damage, health, health);
        } else{ //Trials before 5
            return newEnemy = new Enemy(weapon, damage, health, health);
        }
    }
}
