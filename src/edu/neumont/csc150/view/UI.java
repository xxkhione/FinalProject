/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.view;
 */
package edu.neumont.csc150.view;

import edu.neumont.csc150.model.Character;

public class UI {

    public int mainMenu(){
        return Console.getIntInput("""
                1. New Game
                2. Load Game
                3. Exit""",1, 3);
    }

    public String getName(){
        return Console.getStringInput("What is your name, warrior?");
        //comment
    }

    public void battleMenu(Character player, Character enemy){
        Console.writeLn(player.toString());
        Console.writeLn(enemy.toString());
    }

    public void attackMenu(Character player, Character enemy){
        Console.writeLn("Player Name" + player.getName() + "Player Health" + player.getHealth() + "Players Weapon" + player.getWeapon() + "       "  + "Enemy Health" + enemy.getHealth()
        + "Enemy Weapon" + enemy.getWeapon());

    }

    public int afterBattlePrompt(){
        return Console.getIntInput("""
                1. Save Game
                2. Generate New Weapon
                3. Save and Quit""", 1, 3);
    }

    public int afterDeathPrompt(){
        return Console.getIntInput("""
                1.Load A Save
                2.New Game
                3.Exit""", 1, 3);
    }

    public void noSaves(){
        Console.writeLn("You have no current saves");
        //comment
    }

    public String allSaves(String[] currentSaves){
        if(currentSaves != null && currentSaves.length > 0){
            StringBuilder saveList = new StringBuilder();
            for (int i = 0; i < currentSaves.length; i++) {
                saveList.append((i + 1) + ": " + currentSaves[i].substring(0, currentSaves[i].lastIndexOf(".")) + "\n");
            }
            int selection = Console.getIntInput(saveList.toString(), 1, currentSaves.length);
            return currentSaves[selection -1];
        } else{
            noSaves();
            return null;
        }
    }

    public void welcomeMessage(){
        Console.writeLn("Welcome to this Solo-RPG!");
    }
}
