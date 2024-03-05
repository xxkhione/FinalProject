/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:08 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {
    private final static String DATA_FOLDER = "data";
    private final static String SAVE_FOLDER = "save";

    private static String getFullFilePath(String saveName){
        return DATA_FOLDER + "/" + SAVE_FOLDER + "/" + saveName;
    }

    /**
     * Saves the current version of the game and appends all the needed info into a StringBuilder.
     * Calls writeSave to officially write the save passing in saveName(The player's name) and the saveInfo.
     * @param game - the current instance of game that the user wants to save.
     */
    public static void saveGame(Game game){
        String saveName = game.getPlayer().getName();
        StringBuilder saveInfo = new StringBuilder();
        saveInfo.append("name:" + game.getPlayer().getName() + "\n");
        saveInfo.append("trial:" + game.getTrialNumber() + "\n");
        saveInfo.append("health:" + game.getPlayer().getHealth() + "\n");
        saveInfo.append("max health:" + Player.MAX_HEALTH + "\n");
        saveInfo.append("weapon:" + game.getPlayer().getWeapon() + "\n");
        saveInfo.append("enemy health:" + game.getEnemy().getHealth() + "\n");
        saveInfo.append("enemy damage:" + game.getEnemy().getDamage());
        writeSave(saveName, saveInfo.toString());
    }

    /**
     * Reads the data from the save file requested and then splits up the information.
     * Once the file is split up, the variables needed are then reassigned to create new instances of a game, player, and enemy.
     * @param saveName - the player's name.
     * @return - returns a new instance of a game with the data extracted from the file.
     */
    public static Game loadGame(String saveName){
        List<String> saveData = readSave(saveName);
        Game game = null;
        Figure player = null;
        Figure enemy = null;

        if(saveData != null){
            String playerName = null;
            int trial = 0;
            int health = Player.MAX_HEALTH;
            int maxHealth = Player.MAX_HEALTH;
            int damage = Player.BASE_DAMAGE;
            Arsenal weapon = null;
            int enemyHealth = 0;
            int enemyDamage = 0;
            Arsenal enemyWeapon = null;

            for(String saveLine : saveData){
                if(saveLine.startsWith("name")){
                    String[] nameParts = saveLine.split(":");
                    playerName = nameParts[1];
                } else if(saveLine.startsWith("trial")){
                    String[] trialParts = saveLine.split(":");
                    trial = Integer.parseInt(trialParts[1]);
                } else if(saveLine.startsWith("health")){
                    String[] healthParts = saveLine.split(":");
                    health = Integer.parseInt(healthParts[1]);
                } else if(saveLine.startsWith("max health")){
                    String[] maxHealthParts = saveLine.split(":");
                    maxHealth = Integer.parseInt(maxHealthParts[1]);
                }  else if(saveLine.startsWith("weapon")){
                    String[] weaponParts = saveLine.split(":");
                    if(weaponParts[1].equals("Rubber Duck")){
                        weapon = Arsenal.RUBBER_DUCK;
                    } else {
                        weapon = Arsenal.valueOf(weaponParts[1].toUpperCase());
                    }
                } else if(saveLine.startsWith("enemy health")){
                    String[] enemyHealthParts = saveLine.split(":");
                    enemyHealth = Integer.parseInt(enemyHealthParts[1]);
                } else if(saveLine.startsWith("enemy damage")){
                    String[] enemyDamageParts = saveLine.split(":");
                    enemyDamage = Integer.parseInt(enemyDamageParts[1]);
                }
            }
            player = new Player(playerName, weapon, damage, health, maxHealth);
            enemy = new Enemy(enemyWeapon, enemyDamage, enemyHealth, enemyHealth);
            game = new Game(player, enemy, trial);
        }
        return game;
    }

    /**
     * Writes the save information into a .txt file using a BufferedWriter.
     * @param saveName - the player's name.
     * @param saveInfo - the save information passed from saveGame.
     */
    private static void writeSave(String saveName, String saveInfo){
        if(checkIfPathExists()) {
            BufferedWriter bWriter;
            try {
                bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getFullFilePath(saveName))));
                try {
                    bWriter.write(saveInfo);
                } catch (IOException ioe) {
                    throw new RuntimeException(ioe);
                } finally {
                    bWriter.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Reads the save with the matching saveName using a BufferedReader.
     * @param saveName - the player's name.
     * @return a list of strings containing all the information from the file read.
     */
    private static List<String> readSave(String saveName){
        if(checkIfPathExists()) {
            try {
                BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(getFullFilePath(saveName))));
                List<String> saveLines = new ArrayList<>();
                while (bReader.ready()) {
                    saveLines.add(bReader.readLine());
                }
                return saveLines;
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Checks if the path exists before manipulating anything within the path.
     * If the path doesn't exist, it creates the directories needed.
     * @return a boolean; returns true if path exists.
     */
    private static boolean checkIfPathExists(){
        File path = new File(DATA_FOLDER + "/" + SAVE_FOLDER);
        if(!path.exists()){
            path.mkdirs();
        }
        return true;
    }

    /**
     * Gets all the saves from the data/save folder and lists all names.
     * @return a String[] with all the save names in the data/save directory.
     */
    public static String[] getAllSaves(){
        File file = new File(DATA_FOLDER + "/" + SAVE_FOLDER);
        if(file.exists()){
            return file.list();
        }
        return null;
    }
}
