/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.model;

import edu.neumont.csc150.controller.EnemyDifficultyManager;

public class Game {
    public final static int MAX_WEAPONS = 5;
    private int trialNumber;
    private Figure player, enemy;

    public Game(Figure player, int trial){
        setPlayer(player);
        setEnemy(EnemyDifficultyManager.increaseDifficulty(this, trial));
        setTrialNumber(trial);
    }
    public Game(Figure player){
        setPlayer(player);
        setEnemy(new Enemy());
        setTrialNumber(1);
    }

    //region getters/setters
    public int getTrialNumber() {
        return trialNumber;
    }
    private void setTrialNumber(int trialNumber) {
        if(trialNumber == 0){
            throw new IllegalArgumentException("Game trialNumber cannot be 0.");
        }
        this.trialNumber = trialNumber;
    }
    public Figure getPlayer() {
        return player;
    }
    private void setPlayer(Figure player) {
        if(player == null){
            throw new IllegalArgumentException("Game player object cannot be null.");
        }
        this.player = player;
    }
    public Figure getEnemy() {
        return enemy;
    }
    private void setEnemy(Figure enemy) {
        if(enemy == null){
            throw new IllegalArgumentException("Game enemy object cannot be null.");
        }
        this.enemy = enemy;
    }
    //endregion

}
