package dota.objects;

import dota.logic.GameLogic;

import java.util.ArrayList;

public class Syringe extends Hero {
    public Syringe() {
        super("Шприц-идиот", 100, 30, 10);
    }

    @Override
    public void attack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Шприц предложил кольнутся на %d герою %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void magicAttack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Шприц идиотит на %d героя %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void heal() {
        int heal = GameLogic.heal(this);
        System.out.printf("Шприц кольнул сам себя и полечился на %d\n", heal);
    }

    @Override
    public void ultimate(ArrayList<Hero> allies, ArrayList<Hero> enemies) {
        for (int i = 0; i < allies.size(); i++) {
            allies.get(i).setHealth(allies.get(i).getHealth() + 200);
            enemies.get(i).setHealth(enemies.get(i).getHealth() - 200);
        }
        System.out.println("Шприц кольнул всех союзников на 200 и вылечил их, и поколол всех противников на 200!\n");
    }

    @Override
    public void deathMessage() {
        System.out.println("Игла затупилась");
    }
}
