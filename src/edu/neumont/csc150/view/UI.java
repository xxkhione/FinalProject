/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.view;
 */
package edu.neumont.csc150.view;

import edu.neumont.csc150.model.Figure;

public class UI {

    /**
     * The main menu for the application
     * @return the selection of the user
     */
    public int mainMenu(){
        return Console.getIntInput("""
                1. New Game
                2. Load Game
                3. Exit""",1, 3, Console.TextColor.YELLOW);
    }

    /**
     * Gets the user's name which is also used as the save name
     * @return the name of the character
     */
    public String getName(){
        return Console.getStringInput("What is your name, warrior?", false, Console.TextColor.YELLOW);
        //comment
    }

    /**
     * This displays the battle to come, your character versus an enemy
     * @param player allows the ui to access the toString of the player and display it
     * @param enemy allows the ui to access the toString of the enemy and display it
     */
    public void battleMenu(Figure player, Figure enemy){
        Console.writeLn(player.toString(), Console.TextColor.PURPLE);
        Console.writeLn("Is going up against...");
        Console.writeLn(enemy.toString(), Console.TextColor.PURPLE);
        pressEnterTocContinue();
    }

    /**
     * This shows the name during the battle and all the information you need
     * @param player allows the ui to access the toString of the player and display it
     * @param enemy allows the ui to access the toString of the enemy and display it
     */
    public void displayBattleInProgress(Figure player, Figure enemy){
        Console.writeLn(player.toString() + "       " + enemy.toString(), Console.TextColor.PURPLE);
    }

    /**
     * Displays an attack occurring during battle.
     * @param isPlayersTurn - whether the player is attacking and uses an if/else check to determine who to display is attacking.
     * @param player - the user's figure.
     * @param enemy - the enemy the user is going against.
     * @return a boolean to switch the player's turn from true to false after an attack and vise versa after an enemy's attack.
     */
    public boolean attackOccurred(boolean isPlayersTurn, Figure player, Figure enemy){
        if(isPlayersTurn) {
            Console.writeLn(player.getName() + " attacks for " + player.getTotalDamage(player.getDamage(), player.getWeaponDamage()), Console.TextColor.RED);
            return false;
        } else{
            Console.writeLn(enemy.getClass().getSimpleName() + " attacks for " + enemy.getTotalDamage(enemy.getDamage(), enemy.getWeaponDamage()), Console.TextColor.RED);
            return true;
        }
    }

    /**
     * this displays after every trial, allowing the player to save, generate a new weapon or save, then quitting
     * @return a selection from the player
     */
    public int afterBattlePrompt(){
        return Console.getIntInput("""
                1. Save & Continue
                2. Generate New Weapon
                3. Save & Quit""", 1, 3, Console.TextColor.YELLOW);
    }

    /**
     * displays after the player dies, allows to load a previous save, start new game, or exit the application
     * @return a selection from the player
     */
    public int afterDeathPrompt(){
        return Console.getIntInput("""
                1.Load A Save
                2.New Game
                3.Exit""", 1, 3, Console.TextColor.YELLOW);
    }

    /**
     * displays that the user has no saves
     */
    public void noSaves(){
        Console.writeLn("You have no current saves", Console.TextColor.RED);
        //comment
    }

    /**
     * Displays all saves in the data/save folder, as long as there are files in the directory.
     * @param currentSaves - a list of all save names.
     * @return - the selection of a save from the user, else it returns null if there is none.
     */
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

    /**
     * displays a simple welcome message
     */
    public void welcomeMessage(){
        Console.writeLn("Welcome to this Solo-RPG!", Console.TextColor.BLUE);
    }

    /**
     * displays a simple goodbye message
     */
    public void goodByeMessage(){
        Console.writeLn("Thank you for playing! Goodbye.", Console.TextColor.BLUE);
    }

    /**
     * displays "Press enter to continue"
     * Credit: Beardall
     */
    private void pressEnterTocContinue() {
        Console.getStringInput("~".repeat(10) + " Press [Enter] to continue " + "~".repeat(10), true);
    }

    /**
     * displays a message saying you have saved successfully
     */
    public void saveMessage(){
        Console.writeLn("Successfully saved game", Console.TextColor.GREEN);
    }

    /**
     * Says you have won your current trial
     * @param trialNumber uses the trial number to display what trial you are on
     */
    public void displayPlayerWonMessage(int trialNumber){
        Console.writeLn("Congrats Warrior! You have won the " + trialNumber + " trial!", Console.TextColor.GREEN);
    }

    /**
     * says you have lost and what trial you lost on
     * @param trialNumber uses the trial number to display what trial you are on
     */
    public void displayPlayerLostMessage(int trialNumber){
        Console.writeLn("I'm very disappointed in you, warrior. You lost the " + trialNumber + " trial. May you rest in peace.", Console.TextColor.RED);
    }

    /**
     * says you have beat the game, and your battle days are over
     */
    public void endGameMessage(){
        Console.writeLn("Congratulations! You beat the game. You may rest now, warrior.", Console.TextColor.GREEN);
    }
}
