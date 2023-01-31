package dota.objects;

import dota.logic.GameLogic;

import java.util.ArrayList;

public class Cancer extends Hero {
    public Cancer() {
        super("Рак-дурак", 30, 100, 10);
    }

    @Override
    public void attack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("ЦАП ЦАП ЦАП КЛЕШНЯМИ на %d герою %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void magicAttack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Плюнул водой на %d герою %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void heal() {
        int heal = GameLogic.heal(this);
        System.out.printf("Пососал клешню и полечился на %d\n", heal);
    }

    @Override
    public void ultimate(ArrayList<Hero> allies, ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        enemies.get(enemyNumber).setHealth(enemies.get(enemyNumber).getHealth() - 500);
        System.out.printf("Быканул клешнями в %s и ему влетело аж 500 урона\n", enemies.get(enemyNumber).getName());
    }

    @Override
    public void deathMessage() {
        System.out.println("Рак сварился");
    }
}

