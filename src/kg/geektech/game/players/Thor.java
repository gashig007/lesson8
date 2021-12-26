package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero{

    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff4 = RPG_Game.random.nextInt();
        boolean round = RPG_Game.random.nextBoolean();
        if(round){
            boss.setDamage(0);
            System.out.println("Frank оглушил босса" );
        }
        else {
            boss.setDamage(50);
        }
    }
}
