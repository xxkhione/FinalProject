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
    public void startOfNewTrial(){
        player.setHealth(Player.MAX_HEALTH, Player.MAX_HEALTH);
        enemy.setHealth(Enemy.BASE_HEALTH, Enemy.BASE_HEALTH);
    }

    public boolean playerTurn(){
        if(player.isAlive()){
            player.attack(enemy);
            return enemy.isAlive();
        }
        return true;
    }
    public boolean enemyTurn(){
        if(enemy.isAlive()){
            enemy.attack(player);
            return player.isAlive();
        }
        return true;
    }
}
