import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tile {
    final private int x;
    final private int y;
    final private Room room;
    private ArrayList<Character> characters;

    Tile(Room room, int x, int y) {
        this.room = room;
        this.x = x;
        this.y = y;
        initCharacters();
    }

    private void initCharacters () {
        this.characters = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Room getRoom(){
        return room;
    }

    public void switchTiles (Character c, Tile t) {
        characters.remove(c);
        t.characters.add(c);
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }
}
