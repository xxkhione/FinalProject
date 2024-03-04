/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.model;

public class Game {
    public final static int MAX_WEAPONS = 5;
    private int trialNumber;
    private Character player, enemy;

    public Game(Player player){
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
    public Character getPlayer() {
        return player;
    }
    private void setPlayer(Character player) {
        if(player == null){
            throw new IllegalArgumentException("Game player object cannot be null.");
        }
        this.player = player;
    }
    public Character getEnemy() {
        return enemy;
    }
    private void setEnemy(Character enemy) {
        if(enemy == null){
            throw new IllegalArgumentException("Game enemy object cannot be null.");
        }
        this.enemy = enemy;
    }
    //endregion

    public static void generateNewWeapon(){
        
    }

}
