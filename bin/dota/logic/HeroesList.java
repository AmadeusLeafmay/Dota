package dota.logic;

import dota.objects.*;

import java.util.ArrayList;

public class HeroesList {
    private static final ArrayList<Hero> heroes = new ArrayList<>();

    public static ArrayList<Hero> getHeroesList() {
        heroes.add(new Syringe());
        heroes.add(new Blanket());
        heroes.add(new Cancer());
        heroes.add(new Driver());
        heroes.add(new GodScrewdriver());
        heroes.add(new MainBrowser());
        heroes.add(new Rocket());
        heroes.add(new Trun());
        heroes.add(new UniversalProgress());
        heroes.add(new Unreadable());
        return heroes;
    }
}
