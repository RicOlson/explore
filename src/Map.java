import java.util.ArrayList;

public class Map {
    private ArrayList<Room> rooms;
    private static Map map_instance = null;

    // Init rooms and create map;
    public Map() {
        rooms = new ArrayList<>();
        createMap();
    }

    public void createMap() {
        // Starting with a map created with three rooms
        // each of increasing size
        rooms.add(new Room("Starting Room", 0, 2, 2, new int[]{-2, 0}, new int[]{2, 0}));
        rooms.add(new Room("Middle Room", 1, 3, 3, new int[]{-3, 0}, new int[]{3, 0}));
        rooms.add(new Room("Final Room", 2, 4, 4, new int[]{-4, 0}, new int[]{4, 0}));
    }

    public Room getRoom(int id) {
        return rooms.get(id);
    }

    public ArrayList<Room> getRoomArray () {
        return rooms;
    }

    public static synchronized Map getInstance() {
        if (map_instance == null) {
            map_instance = new Map();
        }

        return map_instance;
    }
}
