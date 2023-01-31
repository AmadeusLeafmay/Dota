package dota.logic;

import dota.objects.Hero;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {
    private static final Scanner in = new Scanner(System.in);

    public static int chooseEnemy() {
        return (int) (Math.random() * 4);
    }

    public static int attack(Hero player, Hero enemy) {
        int damage = Math.abs((int) (player.getStrength() * 0.5 - enemy.getArmor() * 0.2));
        enemy.setHealth(enemy.getHealth() - damage);
        return damage;
    }

    public static int magicAttack(Hero player, Hero enemy) {
        int damage = (int) Math.abs((player.getIntelligence() * 0.6 - enemy.getMagicResist() * 0.3));
        enemy.setHealth(enemy.getHealth() - damage);
        return damage;
    }

    public static int heal(Hero player) {
        int heal = (int) (Math.random() * 200 + player.getIntelligence());
        player.setHealth(player.getHealth() + heal);
        if (player.getHealth() > player.getStrength() * 5) {
            player.setHealth(player.getStrength() * 5);
        }
        return heal;
    }

    public static void printTeams(ArrayList<Hero> teamBlue, ArrayList<Hero> teamRed) {
        frame();
        for (int i = 0; i < teamBlue.size(); i++) {
            System.out.printf("%s | %d                                                  %s | %d\n", teamBlue.get(i).getName(), teamBlue.get(i).getHealth(), teamRed.get(i).getName(), teamRed.get(i).getHealth());
        }
        frame();
    }

    public static void frame() {
        System.out.println("***************************************************************************************************");
    }

    public static void process() {
        System.out.println("Чтобы продолжить нажмите 1");
        in.nextInt();
    }
}
