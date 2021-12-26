package kg.geektech.game.players;

public class Golem extends Hero{
    public Golem(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int bossdmg = boss.getDamage()/5;
        int herojiv = 0;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                herojiv++;
                heroes[i].setHealth(heroes[i].getHealth()+bossdmg);
                this.setHealth(this.getHealth() -bossdmg * herojiv);
            }
        }
        System.out.println("Titan взял на себя " + bossdmg*herojiv);

    }
}
