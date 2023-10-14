//import java.util.ArrayList;
//
//public class Location {
//    private Tile tile;
//    private Room room;
//
//    public Tile getCurrentTile() {
//        return tile;
//    }
//
//    public Room getCurrentRoom() {
//        return room;
//    }
//
//    public void setCurrentRoom(Character c, Room room) {
//        this.room = room;
//
//        if (!(c.location.getCurrentRoom() == null)) {
//            c.location.getCurrentRoom().getCharacters().remove(c);
//        }
//
//        room.getCharacters().add(c);
//    }
//
//    public void setCurrentTile(Character c, Tile tile) {
//        this.tile = tile;
//
//        if (!(c.location.getCurrentTile() == null)) {
//            c.location.getCurrentTile().getCharacters().remove(c);
//        }
//
//        tile.getCharacters().add(c);
//    }
//
//    public ArrayList<Tile> getNeighbors() {
//        ArrayList<Tile> neighbors = new ArrayList<>();
//        int count = 0;
//        System.out.println("Beginning getNeighbors() Location");
//        for(Tile t : room.getRoomTiles()) {
//            // check if you can move north
//            if (t.getY()+1 <= room.getY()) {
//                System.out.println("Type '" + count + "' for north.");
//                neighbors.add(getTileByCoordinates(room, t.getX(), t.getY()+1));
//                count++;
//            }
//            // check if you can move east
//            if (t.getX()+1 <= room.getX()) {
//                System.out.println("Type '" + count + "' for east.");
//                neighbors.add(getTileByCoordinates(room, t.getX()+1, t.getY()));
//                count++;
//            }
//            // check if you can move south
//            if (t.getY()-1 >= -room.getY()) {
//                System.out.println("Type '" + count + "' for south.");
//                neighbors.add(getTileByCoordinates(room, t.getX(), t.getY()-1));
//                count++;
//            }
//            // check if you can move west
//            if (t.getX()-1 >= -room.getX()) {
//                System.out.println("Type '" + count + "' for west.");
//                neighbors.add(getTileByCoordinates(room, t.getX()-1, t.getY()));
//                count++;
//            }
//        }
//
//        if (count == 0) {
//            System.out.println("Count 0 -- Location getNeighbors()");
//        }
//
//        System.out.println("Left Location getNeighbors()");
//        return neighbors;
//    }
//
//    public Tile getTileByCoordinates(Room room, int x, int y) {
//        for (Tile t : room.getRoomTiles()) {
//            if (t.getX() == x && t.getY() == y) {
//                return t;
//            }
//        }
//
//        return null;
//    }
//}
