import java.util.ArrayList;

public class Room {
    final private String name;
    final private int id;
    final private int[] enterDoorXY;
    final private int[] exitDoorXY;
    private Tile enterDoor;
    private Tile exitDoor;
    final private int x;
    final private int y;
    private ArrayList<Tile> tiles = new ArrayList<>();
    private ArrayList<Character> characters = new ArrayList<>();

    Room(String name, int id, int x, int y, int[] enterDoorXY, int[] exitDoorXY) {
        this.name = name;
        this.id = id;
        this.x = x;
        this.y = y;
        this.enterDoorXY = enterDoorXY;
        this.exitDoorXY = exitDoorXY;
    }

    private void initCharacters () {
        this.characters = new ArrayList<>();
    }

    private void initEnterDoor() {
        for (Tile t: this.getRoomTiles()) {
            if (t.getX() == enterDoorXY[0] && t.getY() == enterDoorXY[1]) {
                enterDoor = t;
            }
        }
    }

    private void initExitDoor() {
        for (Tile t: this.getRoomTiles()) {
            if (t.getX() == exitDoorXY[0] && t.getY() == exitDoorXY[1]) {
                exitDoor = t;
            }
        }
    }

    public Tile getEnterDoor() { return enterDoor; }

    public Tile getExitDoor() {
        return exitDoor;
    }

    public void initRoom () {
        ArrayList<Tile> tiles = new ArrayList<>();
        initCharacters();
        int xEnter = 0;
        int yEnter = 0;
        int xExit = 0;
        int yExit = 0;

        for (int i = -x; i <= x; i++) {
            for (int j = y; j >= -y; j--) {
                tiles.add(new Tile(this, i, j));
                if (i == -x && j == 0) {
                    xEnter = i;
                    yEnter = j;

                }
                else if(i == x && j == 0) {
                    xExit = i;
                    yExit = j;
                }
            }
        }

        this.tiles = tiles;
        this.initEnterDoor();
        this.initExitDoor();
        getTileByRoomCoordinates(this, xEnter, yEnter).setIsEnterTile(true);
        getTileByRoomCoordinates(this, xExit, yExit).setIsExitTile(true);

    }

    public Tile getTileByRoomCoordinates (Room room, int x, int y) {
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getX() == x && tiles.get(i).getY() == y) {
                return tiles.get(i);
            }
        }

        return null;
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

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void switchRooms (Character c, Room r) {
        characters.remove(c);
        r.characters.add(c);
    }
}
