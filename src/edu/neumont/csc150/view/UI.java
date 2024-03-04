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
                3. Exit""",1, 3);
    }

    public String getName(){
        return Console.getStringInput("What is your name, warrior?");
        //comment
    }

    public void battleMenu(Figure player, Figure enemy){
        Console.writeLn(player.toString());
        Console.writeLn("Is going up against...");
        Console.writeLn(enemy.toString());
        pressEnterTocContinue();
    }

    public void displayBattleInProgress(Figure player, Figure enemy){
        Console.writeLn(player.toString() + "       " + enemy.toString());
    }
    public boolean attackOccurred(boolean isPlayersTurn, Figure player, Figure enemy){
        if(isPlayersTurn) {
            Console.writeLn(player.getName() + " attacks for " + player.getTotalDamage(player.getDamage(), player.getWeaponDamage()));
            return false;
        } else{
            Console.writeLn(enemy.getClass().getSimpleName() + " attacks for " + enemy.getTotalDamage(enemy.getDamage(), enemy.getWeaponDamage()));
            return true;
        }
    }

    public int afterBattlePrompt(){
        return Console.getIntInput("""
                1. Save & Continue
                2. Generate New Weapon
                3. Save & Quit""", 1, 3);
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
    public void goodByeMessage(){
        Console.writeLn("Thank you for playing! Goodbye.");
    }
    private void pressEnterTocContinue() {
        Console.getStringInput("~".repeat(10) + " Press [Enter] to continue " + "~".repeat(10), true);
    }
    public void saveMessage(){
        Console.writeLn("Successfully saved game");
    }
    public void invalidInput(){
        Console.writeLn("Please enter a valid input.");
    }
    public void displayPlayerWonMessage(int trialNumber){
        Console.writeLn("Congrats Warrior! You have won the " + trialNumber + " trial!");
    }
    public void displayPlayerLostMessage(int trialNumber){
        Console.writeLn("I'm very disappointed in you, warrior. You lost the " + trialNumber + " trial. May you rest in peace.");
    }
}
