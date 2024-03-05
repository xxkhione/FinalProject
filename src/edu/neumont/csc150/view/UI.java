/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.view;
 */
package edu.neumont.csc150.view;

import edu.neumont.csc150.model.Figure;

public class UI {

    public int mainMenu(){
        return Console.getIntInput("""
                1. New Game
                2. Load Game
                3. Exit""",1, 3, Console.TextColor.YELLOW);
    }

    public String getName(){
        return Console.getStringInput("What is your name, warrior?", false, Console.TextColor.YELLOW);
        //comment
    }

    public void battleMenu(Figure player, Figure enemy){
        Console.writeLn(player.toString(), Console.TextColor.PURPLE);
        Console.writeLn("Is going up against...");
        Console.writeLn(enemy.toString(), Console.TextColor.PURPLE);
        pressEnterTocContinue();
    }

    public void displayBattleInProgress(Figure player, Figure enemy){
        Console.writeLn(player.toString() + "       " + enemy.toString(), Console.TextColor.PURPLE);
    }
    public boolean attackOccurred(boolean isPlayersTurn, Figure player, Figure enemy){
        if(isPlayersTurn) {
            Console.writeLn(player.getName() + " attacks for " + player.getTotalDamage(player.getDamage(), player.getWeaponDamage()), Console.TextColor.RED);
            return false;
        } else{
            Console.writeLn(enemy.getClass().getSimpleName() + " attacks for " + enemy.getTotalDamage(enemy.getDamage(), enemy.getWeaponDamage()), Console.TextColor.RED);
            return true;
        }
    }

    public int afterBattlePrompt(){
        return Console.getIntInput("""
                1. Save & Continue
                2. Generate New Weapon
                3. Save & Quit""", 1, 3, Console.TextColor.YELLOW);
    }

    public int afterDeathPrompt(){
        return Console.getIntInput("""
                1.Load A Save
                2.New Game
                3.Exit""", 1, 3, Console.TextColor.YELLOW);
    }

    public void noSaves(){
        Console.writeLn("You have no current saves", Console.TextColor.RED);
        //comment
    }

    public String allSaves(String[] currentSaves){
        if(currentSaves != null && currentSaves.length > 0){
            StringBuilder saveList = new StringBuilder();
            for (int i = 0; i < currentSaves.length; i++) {
                saveList.append((i + 1) + ": " + currentSaves[i] + "\n");
            }
            int selection = Console.getIntInput(saveList.toString(), 1, currentSaves.length, Console.TextColor.CYAN);
            return currentSaves[selection - 1];
        } else{
            noSaves();
            return null;
        }
    }

    public void welcomeMessage(){
        Console.writeLn("Welcome to this Solo-RPG!", Console.TextColor.BLUE);
    }
    public void goodByeMessage(){
        Console.writeLn("Thank you for playing! Goodbye.", Console.TextColor.BLUE);
    }
    private void pressEnterTocContinue() {
        Console.getStringInput("~".repeat(10) + " Press [Enter] to continue " + "~".repeat(10), true);
    }
    public void saveMessage(){
        Console.writeLn("Successfully saved game", Console.TextColor.GREEN);
    }
    public void displayPlayerWonMessage(int trialNumber){
        Console.writeLn("Congrats Warrior! You have won the " + trialNumber + " trial!", Console.TextColor.GREEN);
    }
    public void displayPlayerLostMessage(int trialNumber){
        Console.writeLn("I'm very disappointed in you, warrior. You lost the " + trialNumber + " trial. May you rest in peace.", Console.TextColor.RED);
    }
    public void endGameMessage(){
        Console.writeLn("Congratulations! You beat the game. You may rest now, warrior.", Console.TextColor.GREEN);
    }
}
