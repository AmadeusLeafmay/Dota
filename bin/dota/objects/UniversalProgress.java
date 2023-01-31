package dota.objects;

import dota.logic.GameLogic;

import java.util.ArrayList;

public class UniversalProgress extends Hero {
    public UniversalProgress() {
        super("Универсальный способ развития", 10, 50, 100);
    }

    @Override
    public void attack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Заставляет себя искать %d героя %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void magicAttack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Заставляет о нем думать %d героя %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void heal() {
        int heal = GameLogic.heal(this);
        System.out.printf("Думаешь что нашел)+ %d\n", heal);
    }

    @Override
    public void ultimate(ArrayList<Hero> allies, ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        double chance = Math.random();
        if (chance < 0.5) {
            enemies.get(enemyNumber).setHealth(enemies.get(enemyNumber).getHealth() - 1000);
            System.out.printf("%s, осознает что его нет\n", enemies.get(enemyNumber).getName());
        } else {
            allies.get(enemyNumber).setHealth(allies.get(enemyNumber).getHealth() - 1000);
            System.out.printf("%s, осознает что его нет\n", allies.get(enemyNumber).getName());
        }
    }

    @Override
    public void deathMessage() {
        System.out.println("Не ищут его");
    }
}
