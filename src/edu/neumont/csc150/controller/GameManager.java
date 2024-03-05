/**
 * @author dsargent
 * @createdOn 3/1/2024 at 10:42 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Figure;
import edu.neumont.csc150.model.Game;
import edu.neumont.csc150.model.Player;
import edu.neumont.csc150.view.UI;

public class GameManager {
    private UI ui = new UI();
    private Game game;

    //region getters/setters
    private Game getGame() {
        return game;
    }
    private void setGame(Game game) {
        this.game = game;
    }
    //endregion

    /**
     * The main loop of the game. If user selects one from the main menu, it starts a new game.
     * 2 lists the saves and prompts them to pick a save to load.
     * 3 exits the application.
     */
    public void run(){
        ui.welcomeMessage();
        do {
            int selection = ui.mainMenu();
            switch (selection){
                case 1: //New Game
                    newGame();
                    break;
                case 2: //Load game
                    pickASave();
                    break;
                default: //Exit
                    ui.goodByeMessage();
                    return;
            }

        } while (true);
    }

    /**
     * If trial is equal to max trials (25) then it congratulates the user and brings them back to the main loop.
     * Else, it prompts the user to save and continue, generate a new weapon, or save and exit.
     */
    private void afterBattle(){
        if(game.getTrialNumber() == Game.MAX_TRIALS){
            ui.endGameMessage();
        }
        else {
            int selection = ui.afterBattlePrompt();
            switch (selection) {
                case 1: // Save Game
                    saveGame();
                    startBattle();
                    break;
                case 2: // New Weapon
                    game.getPlayer().setWeapon(game.generateNewWeapon());
                    startBattle();
                    break;
                default: //save & exit
                    saveGame();

            }
        }
    }

    /**
     * After the user dies in a trial, it prompts them to load a save, start a new game, or exit to main menu.
     */
    private void afterDeath(){
        int selection = ui.afterDeathPrompt();
        switch (selection){
            case 1: // Load Game
                pickASave();
                break;
            case 2: // New Game
                newGame();
                break;
            default: // Exit
        }
    }

    /**
     * All logic to create a new game.
     * Asks the user for their name, sets the instance of the game with the player information and starts the battle.
     */
    private void newGame(){
        String name = ui.getName();
        Figure player = new Player(name);
        setGame(new Game(player));
        startBattle();
    }

    /**
     * Logic to save the current instance of the game.
     */
    private void saveGame(){
        SaveManager.saveGame(getGame());
        ui.saveMessage();
    }

    /**
     * Loads up all current saves in the directory and prompts the user to pick a save to load.
     */
    private void pickASave(){
        String saveName = ui.allSaves(SaveManager.getAllSaves());
        if(saveName == null){
            return;
        }
        setGame(SaveManager.loadGame(saveName));
        startBattle();
    }

    /**
     * Logic for starting a battle.
     * Begins by regenerating player and enemy health, increases enemy difficulty (if applicable), and displays a battle view.
     * Calls battle to initiate the fighting then checks if the player won.
     */
    private void startBattle(){
        game.startOfNewTrial();
        game.setEnemy(EnemyDifficultyManager.increaseDifficulty(game, game.getTrialNumber()));
        ui.battleMenu(game.getPlayer(), game.getEnemy());
        boolean playerIsAlive = battle();
        checkIfPlayerWon(playerIsAlive);
    }

    /**
     * Logic of the actual battle.
     * While both the enemy and player is alive, they take turns doing damage until one of them dies.
     * @return playerIsAlive; if true, then the player won the trial, if false, the player died.
     */
    private boolean battle(){
        boolean playersTurn = true;
        boolean playerIsAlive = game.getPlayer().isAlive(), enemyIsAlive = game.getEnemy().isAlive();
        while(playerIsAlive && enemyIsAlive){
            ui.displayBattleInProgress(game.getPlayer(), game.getEnemy());
            if(playersTurn) {
                enemyIsAlive = game.playerTurn();
                ui.attackOccurred(playersTurn, game.getPlayer(), game.getEnemy());
                playersTurn = false;
            } else {
                if (enemyIsAlive) {
                    playerIsAlive = game.enemyTurn();
                    ui.attackOccurred(playersTurn, game.getPlayer(), game.getEnemy());
                    playersTurn = true;
                }
            }
        }
        return playerIsAlive;
    }

    /**
     * Checks if the player won or lost and displayed a message based on the parameter.
     * @param playerIsAlive - true or false based on if the player is alive or dead.
     */
    private void checkIfPlayerWon(boolean playerIsAlive){
        if(playerIsAlive){
            ui.displayPlayerWonMessage(game.getTrialNumber());
            game.setTrialNumber(game.getTrialNumber() + 1);
            afterBattle();
        } else{
            ui.displayPlayerLostMessage(game.getTrialNumber());
            afterDeath();
        }
    }
}
