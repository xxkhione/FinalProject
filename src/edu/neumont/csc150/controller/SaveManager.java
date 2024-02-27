/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:08 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.controller;
 */
package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Game;
import edu.neumont.csc150.model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {
    private final static String DATA_FOLDER = "data";
    private final static String SAVE_FOLDER = "save";

    private static String getFullFilePath(String saveName){
        return DATA_FOLDER + "/" + SAVE_FOLDER + "/" + saveName;
    }

    public static void saveGame(Game game){
        String saveName = game.getPlayer().getName();
        StringBuilder saveInfo = new StringBuilder();
        saveInfo.append("name:" + game.getPlayer().getName() + "\n");
        saveInfo.append("trial:" + game.getTrialNumber() + "\n");
        saveInfo.append("health:" + game.getPlayer().getHealth() + "\n");
        saveInfo.append("max health:" + Player.MAX_HEALTH + "\n");
        saveInfo.append("weapon:" + game.getPlayer().getWeapon());
        writeSave(saveName, saveInfo.toString());
    }

    private static void writeSave(String saveName, String saveInfo){
        BufferedWriter bWriter;
        try{
            bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getFullFilePath(saveName))));
            try{
                bWriter.write(saveInfo);
            } catch(IOException ioe){
                throw new RuntimeException(ioe);
            } finally{
                bWriter.close();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    private static List<String> readSave(String saveName){
        try{
            BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(getFullFilePath(saveName))));
            List<String> saveLines = new ArrayList<>();
            while(bReader.ready()){
                saveLines.add(bReader.readLine());
            }
            return saveLines;
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return null;
    }

    private static boolean checkIfPathExists(){
        File path = new File(DATA_FOLDER + "/" + SAVE_FOLDER);
        if(!path.exists()){
            path.mkdirs();
        }
        return true;
    }
}
