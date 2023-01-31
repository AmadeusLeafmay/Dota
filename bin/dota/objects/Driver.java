package dota.objects;

import dota.logic.GameLogic;

import java.util.ArrayList;

public class Driver extends Hero {
    public Driver() {
        super("Грач-таксист", 70, 60, 10);
    }

    @Override
    public void attack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Ты чё на вокзале таксуешь моем %d герою %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void magicAttack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Развел на деньги за поездку %d героя %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void heal() {
        int heal = GameLogic.heal(this);
        System.out.printf("Кофеек с автомата+ %d\n", heal);
    }

    @Override
    public void ultimate(ArrayList<Hero> allies, ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        enemies.get(enemyNumber).setHealth(enemies.get(enemyNumber).getHealth() - 700);
        System.out.printf("Переехал на такси %s\n", enemies.get(enemyNumber).getName());
    }

    @Override
    public void deathMessage() {
        System.out.println("Грач потерял кепку");
    }
}
