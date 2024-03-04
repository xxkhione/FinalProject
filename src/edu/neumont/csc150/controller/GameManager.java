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
        do {
            int selection = ui.mainMenu();
            switch (selection){
                case 1:
                    Player p = new Player();
                    String name = ui.getName();
                    
                    break;
                case 2:
                    break;
                default:
                    return;
            }

        } while (true);
    }
}
