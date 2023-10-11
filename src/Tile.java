import java.util.ArrayList;

public class Tile {
    int x;
    int y;
    Room room;

    Tile(Room room, int x, int y) {
        this.room = room;
        this.x = x;
        this.y = y;
    }

    public int[] getCoordinates() {
        return new int[]{x, y};
    }

    public ArrayList<int[]> getNeighbors() {
        ArrayList<Tile> neighbors = new ArrayList<>();
        neighbors.add(new Tile(room, x, y+1));
        neighbors.add(new Tile(room, x+1, y));
        neighbors.add(new Tile(room, x, y-1));
        neighbors.add(new Tile(room, x-1, y));

        return neighbors;
    }

    public int[] getCurrent() {
        return new int[]{x, y};
    }

    public void moveNorth() {
        if (y+1 <= room.getY()){

        }
    }
}
