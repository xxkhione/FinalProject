/**
 * @author EavenBall
 * @createdOn 2/27/2024 at 11:07 AM
 * @projectName FinalProject
 * @packageName edu.neumont.csc150.model;
 */
package edu.neumont.csc150.model;

public abstract class Character implements Attackable{
    public final static int MIN_HEALTH = 0;
    private String name;
    private Arsenal weapon;
    private int damage;
    private int health;
    private int maxHealth;
    private boolean isAlive;

    public Character(){
        this("Default", Arsenal.SWORD, 10, 100, 100);
    }
    public Character(String name, Arsenal weapon, int damage, int health, int maxHealth){
        setName(name);
        setWeapon(weapon);
        setDamage(damage);
        setHealth(health, maxHealth);
        setAlive(true);
    }


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
    public void setWeapon(Arsenal weapon) {
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
    protected void setHealth(int health, int maxHealth){
        if(health > maxHealth){
            health = maxHealth;
        } else if(health > MIN_HEALTH){
            setAlive(true);
        } else if(health < MIN_HEALTH){
            health = 0;
            setAlive(false);
        }
        this.health = health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    private void setMaxHealth(int maxHealth) {
        if(maxHealth < MIN_HEALTH){
            throw new IllegalArgumentException(maxHealth + " cannot be lower than" + MIN_HEALTH);
        }
        this.maxHealth = maxHealth;
    }

    private boolean isAlive() {
        return isAlive;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    //endregion



    @Override
    public abstract String toString();
}
