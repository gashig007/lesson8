package kg.geektech.game.players;

public class Witcher extends Hero{
    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() == 0 && heroes[i]!= this && this.getHealth() > 0) {
                heroes[i].setHealth(200);
                this.setHealth(0);
                System.out.println("Lian оживил " + heroes[i].getName());
                break;
            }
        }
    }
}
