import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tile {
    final private int x;
    final private int y;
    final private Room room;
    private ArrayList<Character> characters;
    boolean isEnterTile = false;
    boolean isExitTile = false;

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


    // chamge this to reference itself and get its own neighbors
    public ArrayList<Tile> getNeighbors(Character c) {
        ArrayList<Tile> neighbors = new ArrayList<>();
        int count = 0;
        if (c.getCurrentTile().getY()+1 <= room.getY()) {
//            System.out.println("Type '" + count + "' for north.");
            neighbors.add(getTileByCoordinates(room, c.getCurrentTile().getX(), c.getCurrentTile().getY()+1));
            count++;
        }
        // check if you can move east
        if (c.getCurrentTile().getX()+1 <= room.getX()) {
//            System.out.println("Type '" + count + "' for east.");
            neighbors.add(getTileByCoordinates(room, c.getCurrentTile().getX()+1, c.getCurrentTile().getY()));
            count++;
        }
        // check if you can move south
        if (c.getCurrentTile().getY()-1 >= -room.getY()) {
//            System.out.println("Type '" + count + "' for south.");
            neighbors.add(getTileByCoordinates(room, c.getCurrentTile().getX(), c.getCurrentTile().getY()-1));
            count++;
        }
        // check if you can move west
        if (c.getCurrentTile().getX()-1 >= -room.getX()) {
//            System.out.println("Type '" + count + "' for west.");
            neighbors.add(getTileByCoordinates(room, c.getCurrentTile().getX() - 1, c.getCurrentTile().getY()));
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

    public boolean getIsEnterTile() {
        return isEnterTile;
    }

    public boolean getIsExitTile() {
        return isExitTile;
    }

    public void setIsEnterTile(boolean isEnterTile) {
        this.isEnterTile = isEnterTile;
    }

    public void setIsExitTile(boolean isExitTile) {
        this.isExitTile = isExitTile;
    }

    public String getStringContents() {
        String s = "";
        int total = 0;

        if (characters.isEmpty() && getIsEnterTile()) {
            s += "Enter";
        }
        else if (characters.isEmpty() && getIsExitTile()) {
            s += "Exit";
        }
        else if (characters.isEmpty()) {
            s += "-:-";
        }
        else {
            for (int i = 0; i < characters.size(); i++) {
                if (!characters.get(i).getIsMonster()) {
                    total++;
                    s += characters.get(i).getName();
                    if (characters.size() - 1 != i) {
                        s += ",";
                    }
                }
            }
            if (total == 0) {
                s += "-";
            }
            s += ":";
//            if (getIsEnterTile()) {
//                s += "Enter:";
//            }
//            else if (getIsExitTile()) {
//                s += "Exit:";
//            }

            total = 0;
            for (int i = 0; i < characters.size(); i++) {
                if (characters.get(i).getIsMonster()) {
                    total++;
                    s += characters.get(i).getName();
                    if (characters.size() - 1 != i) {
                        s += ",";
                    }
                }
            }
            if (total == 0) {
                s += "-";
            }
        }

        // add dynamic padding
        s = "       "+ s + "        ";
        return s;
    }
}
