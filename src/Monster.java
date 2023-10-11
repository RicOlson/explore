public class Monster extends Character{
    @Override
    protected void move() {
        System.out.println("Monster moves");
    }

    @Override
    protected void attack() {
        // get rid of this
        Player p = new Player(); // placeholder until players are instantiated in rooms
        attackPlayer(p);
    }

    protected void attackPlayer(Player p) {
        System.out.println("Monster attacks player: " + p.getName());
    }

}
