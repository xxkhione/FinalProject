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

    private void afterBattle(){
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
                ui.goodByeMessage();
        }
    }

    private void newGame(){
        String name = ui.getName();
        Figure player = new Player(name);
        setGame(new Game(player));
        startBattle();
    }
    private void saveGame(){
        SaveManager.saveGame(getGame());
        ui.saveMessage();
    }

    private void pickASave(){
        String saveName = ui.allSaves(SaveManager.getAllSaves());
        if(saveName == null){
            return;
        }
        setGame(SaveManager.loadGame(saveName));
        startBattle();
    }

    private void startBattle(){
        game.startOfNewTrial();
        game.setEnemy(EnemyDifficultyManager.increaseDifficulty(game, game.getTrialNumber()));
        ui.battleMenu(game.getPlayer(), game.getEnemy());
        boolean playerIsAlive = battle();
        checkIfPlayerWon(playerIsAlive);
    }

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
