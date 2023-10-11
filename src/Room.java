import java.util.ArrayList;

public class Room {
    String name;
    int id;
    int x;
    int y;
    final private int[] enterDoor;
    final private int[] exitDoor;
    Tile current;
    ArrayList<Tile> tiles = new ArrayList<>();
    ArrayList<Character> characters = new ArrayList<>();

    Room(String name, int id, int x, int y, int[] enterDoor, int[] exitDoor) {
        this.name = name;
        this.id = id;
        this.x = x;
        this.y = y;
        this.enterDoor = enterDoor;
        this.exitDoor = exitDoor;
    }

    public int[] getEnterDoor() {
        return enterDoor;
    }

    public int[] getExitDoor() {
        return exitDoor;
    }

    public void enterRoom (Character c) {
        characters.add(c);
    }

    public void exitRoom (Character c) {
        characters.remove(c);
    }

    public void switchRooms (Character c, Room r) {
        characters.remove(c);
        r.characters.add(c);
    }

    public void initRoomTiles (int x, int y) {
        ArrayList<Tile> tiles = new ArrayList<>();

        for (int i = -x; i <= x; i++) {
            for (int j = -y; j <= y; j++) {
                tiles.add(new Tile(this, i, j));
            }
        }

        this.tiles = tiles;
    }

    public ArrayList<Tile> getRoomTiles () {
        return tiles;
    }

    public String getName () {
        return name;
    }

    public int getId () {
        return id;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public void moveNorth() {
        if (current.y+1 <= y){
            current = current.getNeighbors().get(0).;
        }
    }
}
