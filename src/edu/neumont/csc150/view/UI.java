/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:09 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.view;
 */
package edu.neumont.csc150.view;

public class UI {

    public int mainMenu(){
        return Console.getIntInput("""
                1. New Game
                2. Load Game
                3. Exit""",1, 3);
    }

    public String getName(){
        return Console.getStringInput("What is your name, warrior");
        //comment
    }

    public void battleMenu(){

    }

    public void attackMenu(){

    }

    public int afterBattlePrompt(){
        return Console.getIntInput("""
                1. Save Game
                2. Generate New Weapon
                3. Quit""", 1, 3);
    }

    public int afterDeathPrompt(){
        return Console.getIntInput("""
                1.Load A Save
                2.Exit""", 1, 2);
    }

    public void noSaves(){
        Console.writeLn("You have no current saves");
        //comment
    }

    public void allSaves(){

    }




}
