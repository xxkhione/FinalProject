/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.model;

import java.util.Random;

public class Game {
    public final static int MAX_TRIALS = 25;
    private int trialNumber;
    private Figure player, enemy;

    public Game(Figure player, Figure enemy, int trial){
        setPlayer(player);
        setEnemy(enemy);
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
    public void setTrialNumber(int trialNumber) {
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
    public void setEnemy(Figure enemy) {
        if(enemy == null){
            throw new IllegalArgumentException("Game enemy object cannot be null.");
        }
        this.enemy = enemy;
    }
    //endregion

    /**
     * Generates a new weapon based on a random integer.
     * If the number is 1-6, the weapon is a bow. If the number is 7-12, the weapon is a sword.
     * If the number is 13-16, the weapon is an axe. If the number is 17-19, the weapon is a hammer.
     * The very rare chance of getting a 20, gives you the over-powered rubber duck.
     * @return the weapon from the if/elseif/else checks.
     */
    public Arsenal generateNewWeapon(){
        Random rand = new Random();
        int weaponChance = rand.nextInt(20) + 1;
        if (weaponChance == 1 || weaponChance == 2 || weaponChance == 3 || weaponChance == 4 || weaponChance == 5 || weaponChance == 6){
            return Arsenal.BOW;
        } else if (weaponChance == 7 || weaponChance == 8 || weaponChance == 9 || weaponChance == 10 || weaponChance == 11 || weaponChance == 12) {
            return Arsenal.SWORD;
        } else if (weaponChance == 13 || weaponChance == 14 || weaponChance == 15 || weaponChance == 16 ) {
            return Arsenal.AXE;
        } else if (weaponChance == 17 || weaponChance == 18 || weaponChance == 19) {
            return Arsenal.HAMMER;
        } else {
            return Arsenal.RUBBER_DUCK;
        }
    }

    /**
     * Resets the player and enemy health before each start of the trial.
     * This ensures that neither one is at zero health at the beginning of a trial.
     */
    public void startOfNewTrial(){
        player.setHealth(Player.MAX_HEALTH, Player.MAX_HEALTH);
        enemy.setHealth(Enemy.BASE_HEALTH, Enemy.BASE_HEALTH);
    }

    /**
     * When it is the player's turn, and they are alive, they will attack the enemy.
     * @return a boolean; if the player is alive, it will return if the enemy is alive after attacking. Else, it will return true that they are dead.
     */
    public boolean playerTurn(){
        if(player.isAlive()){
            player.attack(enemy);
            return enemy.isAlive();
        }
        return true;
    }

    /**
     * When it is the enemy's turn, and they are alive, they will attack the player.
     * @return a boolean; if the enemy is alive, it will return if the player is alive after attacking. Else, it will return true that they are dead.
     */
    public boolean enemyTurn(){
        if(enemy.isAlive()){
            enemy.attack(player);
            return player.isAlive();
        }
        return true;
    }
}
