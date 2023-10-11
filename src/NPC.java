public class NPC extends Character{
    NPC(String name, String id, int health, int armor, int attack, int dodgeChance) {
        super(name, id, health, armor, attack, dodgeChance);
    }

    @Override
    protected void move() {
        System.out.println("NPC moves");
    }

    @Override
    protected void attack() {
//        Monster m = new Monster(); // placeholder until monsters are instantiated in rooms
//        attackMonster(m);
    }

    protected void attackMonster(Monster m) {
        System.out.println("NPC attacks monster: " + m.getName());
    }
}
