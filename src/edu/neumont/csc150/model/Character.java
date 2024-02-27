/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:07 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.model;
 */
package edu.neumont.csc150.model;

public abstract class Character {
    public final static int MIN_HEALTH = 0;
    private String name;
    private Arsenal weapon;
    private int damage;
    private int health;



    //region getters/setters
    public String getName() {
        return name;
    }
    private void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Character name cannot be empty or null.");
        }
        this.name = name;
    }
    public Arsenal getWeapon() {
        return weapon;
    }
    private void setWeapon(Arsenal weapon) {
        this.weapon = weapon;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getTotalDamage(int damage){
        return damage; //TODO: need to implement the weapon damage once we get that method working
    }
    public int getHealth() {
        return health;
    }
    protected abstract void setHealth(int health);
    //endregion



    @Override
    public abstract String toString();
}
