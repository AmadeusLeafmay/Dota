package dota.objects;

import dota.logic.GameLogic;

import java.util.ArrayList;

public class Rocket extends Hero {
    public Rocket() {
        super("Денис Ракета", 100, 50, 30);
    }

    @Override
    public void attack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Поломал ноги на %d герою %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void magicAttack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Погнул головой крышу на %d герою %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void heal() {
        int heal = GameLogic.heal(this);
        System.out.printf("По пиву)+ на %d\n", heal);
    }

    @Override
    public void ultimate(ArrayList<Hero> allies, ArrayList<Hero> enemies) {
        int enemyNumberFirst = GameLogic.chooseEnemy();
        int enemyNumberSecond = GameLogic.chooseEnemy();
        enemies.get(enemyNumberFirst).setHealth(enemies.get(enemyNumberFirst).getHealth() - 300);
        enemies.get(enemyNumberSecond).setHealth(enemies.get(enemyNumberSecond).getHealth() - 300);
        System.out.printf("Поломал по ноге %s и %s\n", enemies.get(enemyNumberFirst).getName(), enemies.get(enemyNumberSecond).getName());
    }

    @Override
    public void deathMessage() {
        System.out.println("Поломали пальцы");
    }
}