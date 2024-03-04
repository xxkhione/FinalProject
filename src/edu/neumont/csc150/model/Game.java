/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.model;

import edu.neumont.csc150.controller.EnemyDifficultyManager;

import java.util.Random;

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

    public void generateNewWeapon(){
        Random rand = new Random();
        int weaponChance = rand.nextInt(20) + 1;
        if (weaponChance == 1 || weaponChance == 2 || weaponChance == 3 || weaponChance == 4 || weaponChance == 5 || weaponChance == 6){
            player.setWeapon(Arsenal.BOW);
        } else if (weaponChance == 7 || weaponChance == 8 || weaponChance == 9 || weaponChance == 10 || weaponChance == 11 || weaponChance == 12) {
            player.setWeapon(Arsenal.SWORD);
        } else if (weaponChance == 13 || weaponChance == 14 || weaponChance == 15 || weaponChance == 16 ) {
            player.setWeapon(Arsenal.AXE);
        } else if (weaponChance == 17 || weaponChance == 18 || weaponChance == 19) {
            player.setWeapon(Arsenal.HAMMER);
        } else {
            player.setWeapon(Arsenal.RUBBER_DUCK);
        }
    }


    private boolean battle(){
        boolean playerIsAlive = player.isAlive(), enemyIsAlive = enemy.isAlive();
        while(playerIsAlive && enemyIsAlive){
            enemyIsAlive = playerTurn();
            if(enemyIsAlive){
                playerIsAlive = enemyTurn();
            }
        }
        return playerIsAlive;
    }

    private boolean playerTurn(){
        if(player.isAlive()){
            player.attack(enemy);
            return enemy.isAlive();
        }
        return true;
    }
    private boolean enemyTurn(){
        if(enemy.isAlive()){
            enemy.attack(player);
            return player.isAlive();
        }
        return true;
    }
}
