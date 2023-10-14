import java.util.ArrayList;

public class Character {
    protected String name;
    protected String id;
    protected boolean isAlive = true;
    protected boolean isMonster;
    protected int health;
    protected int armor;
    protected int attack;
    protected int dodgeChance;
//    protected Location location;
    private Tile tile;
    private Room room;

    Character (String name, String id, int health, int armor, int attack, int dodgeChance, boolean isMonster) {
        this.name = name;
        this.id = id;
        this.health = health;
        this.armor = armor;
        this.attack = attack;
        this.dodgeChance = dodgeChance;
        this.isMonster = isMonster;
    }

    final void runTurn() {
        move();
        attack();
        loot();
    }

    protected void move() {
        int move = 0;
        String old = "(" + getCurrentTile().getX() + ", " + getCurrentTile().getY() + ")";
        enterTile(getNeighbors().get(move));
        System.out.println(name + " moves FROM tile " + old + " -> tile (" + getCurrentTile().getX() + ", " + getCurrentTile().getY() + ")");
    }

    protected void attack() {
        for (Character c : getCurrentTile().getCharacters()) {
            if (c.isMonster != isMonster) {
                attackCharacter(c);
            }
        }
    }

    protected void loot() {
    }

    public void attackCharacter(Character c) {
        System.out.println(name + " attacks " + c.name);
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

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public boolean getIsAlive () {
        return isAlive;
    }

    public void kill () {
        isAlive = false;
    }

    public boolean getIsMonster() {
        return isMonster;
    }

//    public Location getLocation () {
//        return location;
//    }

    public void enterTile (Tile tile) {


        getCurrentTile().switchTiles(this, tile);
        this.tile = tile;
//        getCurrentTile().getCharacters().remove(this);
//        tile.getCharacters().add(this);
    }

    public void enterRoom (Room room) {


        getCurrentRoom().switchRooms(this, room);
        this.room = room;

//        if (!(getCurrentRoom() == null)) {
//            getCurrentRoom().getCharacters().remove(this);
//        }
//
//        room.getCharacters().add(this);
    }

    public Tile getCurrentTile() {
        return tile;
    }

    public Room getCurrentRoom() {
        return room;
    }

    public ArrayList<Tile> getNeighbors() {
        ArrayList<Tile> neighbors = new ArrayList<>();
        int count = 0;
        if (getCurrentTile().getY()+1 <= room.getY()) {
//            System.out.println("Type '" + count + "' for north.");
            neighbors.add(getTileByCoordinates(room, getCurrentTile().getX(), getCurrentTile().getY()+1));
            count++;
        }
        // check if you can move east
        if (getCurrentTile().getX()+1 <= room.getX()) {
//            System.out.println("Type '" + count + "' for east.");
            neighbors.add(getTileByCoordinates(room, getCurrentTile().getX()+1, getCurrentTile().getY()));
            count++;
        }
        // check if you can move south
        if (getCurrentTile().getY()-1 >= -room.getY()) {
//            System.out.println("Type '" + count + "' for south.");
            neighbors.add(getTileByCoordinates(room, getCurrentTile().getX(), getCurrentTile().getY()-1));
            count++;
        }
        // check if you can move west
        if (getCurrentTile().getX()-1 >= -room.getX()) {
//            System.out.println("Type '" + count + "' for west.");
            neighbors.add(getTileByCoordinates(room, getCurrentTile().getX() - 1, getCurrentTile().getY()));
            count++;
        }
        if (count == 0) {
            System.out.println("There are no neighbors");
        }

        return neighbors;
    }

    public Tile getTileByCoordinates(Room room, int x, int y) {
        for (Tile t : room.getRoomTiles()) {
            if (t.getX() == x && t.getY() == y) {
                return t;
            }
        }

        return null;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
