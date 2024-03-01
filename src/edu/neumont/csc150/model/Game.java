/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.model;

public class Game {
    public final static int MAX_TRIALS = 25;
    public final static int MAX_WEAPONS = 5;
    private int trialNumber;
    private Character player, enemy;

    //region getters/setters
    public int getTrialNumber() {
        return trialNumber;
    }
    private void setTrialNumber(int trialNumber) {
        this.trialNumber = trialNumber;
    }
    public Character getPlayer() {
        return player;
    }
    private void setPlayer(Character player) {
        this.player = new Player();
    }
    public Character getEnemy() {
        return enemy;
    }
    private void setEnemy(Character enemy) {
        this.enemy = new Enemy();
    }

    //endregion
}
