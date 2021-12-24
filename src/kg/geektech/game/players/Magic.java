package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero{
    public Magic(int health, int damage,String name) {
        super(health, damage,
                SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff1 = RPG_Game.random.nextInt(20);
        for (int i = 0; i < heroes.length; i++) {
            boss.setHealth(boss.getHealth() - (this.getDamage() + coeff1));
        }
        System.out.println("Heroes hits critically "
                + (this.getDamage() + coeff1));
    }
}

