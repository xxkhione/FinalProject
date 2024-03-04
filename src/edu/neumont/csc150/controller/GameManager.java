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
        do {
            int selection = ui.afterBattlePrompt();
            switch (selection){
                case 1: // Save Game
                    SaveManager.saveGame(game);
                    break;
                case 2:
                    game.generateNewWeapon();
                case 2: // New Weapon
                    Game.generateNewWeapon();
                    break;
                default: // Save and exit
                    SaveManager.saveGame(game);
                    return;
            }
        } while (true);

    }

    private void afterDeath(){
        do {
            int selection = ui.afterDeathPrompt();
            switch (selection){
                case 1: // Load Game
                    SaveManager.loadGame(game.getPlayer().getName());
                    break;
                case 2: // New Game
                    newGame();
                    break;
                default: // Exit
                    ui.goodByeMessage();
                    return;
            }

        }while (true);
    }

    private void newGame(){
        String name = ui.getName();
        Figure player = new Player(name);
        setGame(new Game(player));
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
    }

}
