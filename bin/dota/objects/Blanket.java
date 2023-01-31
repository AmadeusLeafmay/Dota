package dota.objects;

import dota.logic.GameLogic;

import java.util.ArrayList;

public class Blanket extends Hero {
    public Blanket() {
        super("Лоскутное одеяло", 40, 70, 20);
    }

    @Override
    public void attack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Порвало на лоскуты %d героя %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void magicAttack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Заманило на чердак %d героя %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void heal() {
        int heal = GameLogic.heal(this);
        System.out.printf("Сварило суп из лоскутов+ %d\n", heal);
    }

    @Override
    public void ultimate(ArrayList<Hero> allies, ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        enemies.get(enemyNumber).setHealth(enemies.get(enemyNumber).getHealth() - 1000);
        System.out.printf("Сожрало %s на чердаке\n", enemies.get(enemyNumber).getName());
    }

    @Override
    public void deathMessage() {
        System.out.println("Одеяло разорвалось(");
    }
}
