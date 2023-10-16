public class Render {
    Map map = Map.getInstance();

    public void RenderBoard() {
        printRooms();
    }

    public void printRooms() {
        System.out.println("Starting Room");
        printRoom(map.getRoom(0));
        System.out.println("Middle Room");
        printRoom(map.getRoom(1));
        System.out.println("Ending Room");
        printRoom(map.getRoom(2));
    }

    private void printRoom(Room room) {
        String s = "";
        String line = "+------------------";
        String lineS = "";
        int roomSize = room.getX()*2 + 1;

        for (int j = room.getY(); j >= -room.getY(); j--) {
            for (int i = 0; i < roomSize; i++) {
                lineS += line;
            }
            System.out.println(lineS + "+");
            lineS = "";

            for (int k = -room.getX(); k <= room.getX(); k++) {
                s += "|" + room.getTileByRoomCoordinates(room, k, j).getStringContents();
            }

            System.out.println(s + "|");
            s = "";
        }
        for (int i = 0; i < roomSize; i++) {
            lineS += line;
        }

        System.out.println(lineS + "+");
    }
}