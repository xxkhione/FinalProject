/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Arsenal;
import edu.neumont.csc150.model.Character;
import edu.neumont.csc150.model.Enemy;
import edu.neumont.csc150.model.Game;

import java.util.Random;

public class EnemyDifficultyManager {
    private static final Random rand = new Random();
    //Gets the trial number
    //Based on the number (increments of 5)
    //The damage & health of enemy get stronger
    //Their chance of getting a harder hitting weapon increases
    //Returns enemy with new properties

    public static Character increaseDifficulty(Game game){
        int trialNumber = game.getTrialNumber();
        float chanceForOPWeapon = rand.nextFloat(0.05f);
        int health = 0;
        int damage = 0;
        Arsenal weapon = null;
        switch(trialNumber){
            case 1, 2, 3, 4, 5 -> {
                health = 75; damage = 5;
                
            }
        }
        return null;
    }
}
