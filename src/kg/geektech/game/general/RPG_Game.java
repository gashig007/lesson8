package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();

    public static void startGame() {
        Warrior warrior = new Warrior(290, 20, "Spider");
        Medic doc = new Medic(240, 5, 20, "Strange");
        Magic magic = new Magic(270, 15, "Aladava");
        Berserk berserk = new Berserk(200, 10, "Tor");
        Medic assistant = new Medic(280, 10, 5, "Chopper");
        Thor thor = new Thor(250, 15, "Frank");
        Golem golem = new Golem(300, 5, "Titan");
        Witcher witcher = new Witcher(260, 0, "Lian");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, thor, golem, witcher};
        Boss boss = new Boss(8000, 150);

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplyAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void heroesApplyAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("________________");
        System.out.println("Boss health: " + boss.getHealth()
                + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
           /* System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth()
                    + " [" + heroes[i].getDamage() + "]");*/
            System.out.println(heroes[i].getName()
                    + " health: " + heroes[i].getHealth()
                    + " [" + heroes[i].getDamage() + "]");
        }
        System.out.println("________________");
    }
}