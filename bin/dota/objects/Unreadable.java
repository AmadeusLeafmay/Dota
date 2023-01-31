package dota.objects;

import dota.logic.GameLogic;

import java.util.ArrayList;

public class Unreadable extends Hero {
    public Unreadable() {
        super("&7^^%$$^&&$%", 30, 30, 100);
    }

    @Override
    public void attack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Рассказал что солнышко то наше электронное %d герою %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void magicAttack(ArrayList<Hero> enemies) {
        int enemyNumber = GameLogic.chooseEnemy();
        int damage = GameLogic.attack(this, enemies.get(enemyNumber));
        System.out.printf("Показал кирпичики мироздания %d герою %s\n", damage, enemies.get(enemyNumber).getName());
    }

    @Override
    public void heal() {
        int heal = GameLogic.heal(this);
        System.out.printf("Получил сон с логином и паролем к КАБИНЕТУ %d\n", heal);
    }

    @Override
    public void ultimate(ArrayList<Hero> allies, ArrayList<Hero> enemies) {
        for (int i = 0; i < allies.size(); i++) {
            allies.get(i).setHealth(allies.get(i).getHealth() + 200);
            enemies.get(i).setHealth(enemies.get(i).getHealth() - 200);
        }
        System.out.println("Узнал как все устроено, полечил всех союзников на 200 и вылечил их, и разрушил всех противников на 200!\n");
    }

    @Override
    public void deathMessage() {
        System.out.println("Ушел в виртуальность");
    }
}
