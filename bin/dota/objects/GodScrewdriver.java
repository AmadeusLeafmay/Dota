package dota.objects;

import dota.logic.GameLogic;

import java.util.ArrayList;

public class GodScrewdriver extends Hero {
    public GodScrewdriver() {
        super("Бог-шуруповерт", 70, 80, 10);
    }

    @Override
    public void attack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Вкрутил шуруп на %d герою %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void magicAttack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Перегрел ручку %d герою %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void heal() {
        int heal = GameLogic.heal(this);
        System.out.printf("Заменил батарею+ %d\n", heal);
    }

    @Override
    public void ultimate(ArrayList<Hero> allies, ArrayList<Hero> enemies) {
        for (int i = 0; i < 10; i++) {
            int enemyNumber = GameLogic.chooseEnemy();
            enemies.get(enemyNumber).setHealth(enemies.get(enemyNumber).getHealth() - (int) (Math.random() * 500));
        }
        System.out.println("Расстрелял шурупами врагов на случайное количество урона\n");
    }

    @Override
    public void deathMessage() {
        System.out.println("Шуруповерт разрядился");
    }
}


