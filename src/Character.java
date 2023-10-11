public class Character {
    String name;
    String id;
    int health;
    int armor;
    int attack;
    int dodgeChance;
    char type;

    final void runTurn() {
        move();
        attack();
        loot();
    }

    protected void move() {
    }

    protected void attack() {
    }

    protected void loot() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void changeHealth(int c) {
        health += c;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public  void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
