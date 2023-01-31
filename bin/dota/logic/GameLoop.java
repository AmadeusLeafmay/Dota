package dota.logic;

import dota.objects.Hero;

import java.util.ArrayList;

import static dota.logic.GameLogic.frame;
import static dota.logic.GameLogic.process;

public class GameLoop {
    private static ArrayList<Hero> heroes;
    private static final ArrayList<Hero> teamBlue = new ArrayList<>();
    private static final ArrayList<Hero> teamRed = new ArrayList<>();
    private static boolean endFlag = false;

    public static void startGame() {
        heroes = HeroesList.getHeroesList();
        chooseTeam();
        while (!endFlag) {
            if (deathCheck(teamBlue) == 5 || deathCheck(teamRed) == 5) {
                String winner = deathCheck(teamRed) > deathCheck(teamBlue) ? "Победили синие" : "Победили красные";
                System.out.println(winner);
                endFlag = true;
            }
            GameLogic.printTeams(teamBlue, teamRed);
            process();
            System.out.println("Ходит синяя команда:");
            frame();
            teamTurn(teamBlue, teamRed);
            System.out.println("Ходит красная команда:");
            frame();
            teamTurn(teamRed, teamBlue);
        }
    }

    private static void chooseTeam() {
        for (Hero hero : heroes) {
            if (teamBlue.size() < 5 && teamRed.size() < 5) {
                if (Math.random() > 0.5) {
                    teamBlue.add(hero);
                } else {
                    teamRed.add(hero);
                }
            } else {
                if (teamBlue.size() < 5) {
                    teamBlue.add(hero);
                } else {
                    teamRed.add(hero);
                }
            }
        }
    }

    private static void chooseAction(Hero hero, ArrayList<Hero> allies, ArrayList<Hero> enemies) {
        double chance = Math.random();
        if (hero.getHealth() < 200) {
            System.out.printf("%s лечится\n", hero.getName());
            hero.heal();
        } else {
            if (chance < 0.45) {
                System.out.printf("%s атакует\n", hero.getName());
                hero.attack(enemies);
            } else if (chance <= 0.9) {
                System.out.printf("%s колдует\n", hero.getName());
                hero.magicAttack(enemies);
            } else {
                System.out.printf("%s ультует\n", hero.getName());
                hero.ultimate(allies, enemies);
            }
        }
        process();
    }

    private static int deathCheck(ArrayList<Hero> team) {
        int deaths = 0;
        for (Hero hero : team) {
            if (hero.getHealth() <= 0) {
                deaths++;
            }
        }
        return deaths;
    }

    private static void teamTurn(ArrayList<Hero> alliesTeam, ArrayList<Hero> enemyTeam) {
        for (Hero hero : alliesTeam) {
            if (hero.getHealth() < 0) {
                hero.deathMessage();
            } else {
                chooseAction(hero, alliesTeam, enemyTeam);
            }
            frame();
        }
    }
}
