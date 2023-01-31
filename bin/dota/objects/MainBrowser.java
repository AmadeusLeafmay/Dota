package dota.objects;

import dota.logic.GameLogic;

import java.util.ArrayList;

public class MainBrowser extends Hero {
    public MainBrowser() {
        super("Главный браузер", 40, 50, 40);
    }

    @Override
    public void attack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Душит главностью %d героя %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void magicAttack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Пробивает по айпи %d героя %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void heal() {
        int heal = GameLogic.heal(this);
        System.out.printf("Подгрузил CSS + %d\n", heal);
    }

    @Override
    public void ultimate(ArrayList<Hero> allies, ArrayList<Hero> enemies) {
        for (int i = 0; i < 10; i++) {
            int enemyNumber = GameLogic.chooseEnemy();
            enemies.get(enemyNumber).setHealth(enemies.get(enemyNumber).getHealth() - (int) (Math.random() * 500));
        }
        System.out.println("БРУТФОРСИТ всех врагов на случайное количество урона\n");
    }

    @Override
    public void deathMessage() {
        System.out.println("В браузере нашли БАГ");
    }
}

