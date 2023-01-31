package dota.objects;

import java.util.ArrayList;

public abstract class Hero {
    private final String name;
    private int health;
    private final int strength;
    private final int intelligence;
    private final int armor;
    private final int magicResist;

    public Hero(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.health = 20 * strength;
        this.armor = 5 * agility;
        this.magicResist = 5 * intelligence;
    }

    public abstract void attack(ArrayList<Hero> enemies);

    public abstract void magicAttack(ArrayList<Hero> enemies);

    public abstract void heal();

    public abstract void ultimate(ArrayList<Hero> allies, ArrayList<Hero> enemies);

    public abstract void deathMessage();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public int getMagicResist() {
        return magicResist;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getName() {
        return name;
    }
}
