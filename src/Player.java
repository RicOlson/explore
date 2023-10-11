public class Player extends Character{

    Player(String name, String id, int health, int armor, int attack, int dodgeChance) {
        super(name, id, health, armor, attack, dodgeChance);
    }

    @Override
    protected void move() {
        System.out.println("Player moves");
    }
    @Override
    protected void attack() {
        // get rid of this
//        Monster m = new Monster(); // placeholder until monsters are instantiated in rooms
//        attackMonster(m);
    }
    @Override
    protected void loot() {
        System.out.println("Player loots");
    }

    void attackMonster(Monster m) {
        System.out.println("Player attacks monster: " + m.getName());
    }
}
