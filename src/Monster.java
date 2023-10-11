public class Monster extends Character{
    Monster(String name, String id, int health, int armor, int attack, int dodgeChance) {
        super(name, id, health, armor, attack, dodgeChance);
    }

    @Override
    protected void move() {
        System.out.println("Monster moves");
    }

    @Override
    protected void attack() {
        // get rid of this
//        Player p = new Player("Player 1"); // placeholder until players are instantiated in rooms
//        attackPlayer(p);
    }

    protected void attackPlayer(Player p) {
        System.out.println("Monster attacks player: " + p.getName());
    }

}
