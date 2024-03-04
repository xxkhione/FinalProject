/**
 * @author dsargent
 * @createdOn 3/1/2024 at 10:42 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Player;
import edu.neumont.csc150.view.UI;

public class GameManager {

    UI ui = new UI();
    public void Run(){
        ui.welcomeMessage();
        do {
            int selection = ui.mainMenu();
            switch (selection){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    return;
            }

        } while (true);
    }

    public void pickASave(){
        do {
            int selection = ui.allSaves();
            switch (selection){

            }

        }while (true);
    }

    private void afterBattle(){
        do {
            int selection = ui.afterBattlePrompt();
            switch (selection){
                case 1:
                SaveManager.saveGame();
                    break;
                case 2:
                    break;
                default:
                    SaveManager.saveGame();
                    return;
            }
        } while (true);

    }

    private void afterDeath(){
        do {
            int selection = ui.afterDeathPrompt();
            switch (selection){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    return;
            }

        }while (true);
    }

    private void newGame(){
        String name = ui.getName();
        Player p = new Player(name);
    }


}
