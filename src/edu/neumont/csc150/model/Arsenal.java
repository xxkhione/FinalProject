/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:08 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.model;
 */
package edu.neumont.csc150.model;

public enum Arsenal {

    HAMMER("Hammer"),

    AXE("Axe"),

    SWORD("Sword"),

    BOW("Bow"),

    RUBBER_DUCK("Rubber Duck");

    private final String goodName;

    Arsenal(String friendlyName){
        this.goodName = friendlyName;
    }

    public String toString(){
        return goodName;
    }


}
