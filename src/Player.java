public class Player extends Character{


    Player(String name, String id, int health, int armor, int attack, int dodgeChance, boolean isMonster) {
        super(name, id, health, armor, attack, dodgeChance, isMonster);
    }

    @Override
    protected void loot() {
        System.out.println(name + " loots");
    }



}
