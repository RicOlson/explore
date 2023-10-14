import java.util.ArrayList;
import java.util.Objects;

public class Engine {
    private int turnNumber = 0;
    private boolean gameOver = false;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<NPC> npcs = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();
    private final Room room = new Room("Test", 1, 2, 2, new int[]{-2, 0}, new int[]{2, 0});

    public void game() {
        init();
        runGame();
        endGame();
    }

    private void init() {
        room.initRoom();
        players = initPlayers();
        monsters = initMonsters();
        npcs = initNPCs();

    }

    private void runGame() {
        if (turnNumber < 1) {
            turnNumber++;
        }
        while (!gameOver) {
            runRound();
            turnNumber++;
        }
//        while (endCondition()) {
//            runRound();
//            turnNumber++;
//        }
    }

    private void runRound() {
        for (Monster monster : monsters) {
            monster.runTurn();
        }
        for (Player player : players) {
            player.runTurn();
        }
        for (NPC npc : npcs) {
            npc.runTurn();
        }
        for (Player player : players) {
            player.runTurn();
        }

        gameOver = true;
    }

    private ArrayList<Player> initPlayers() {
        ArrayList<Player> players = new ArrayList<>();

        Player player1 = new Player("Legend", "PLA01", 15, 3, 2, 10, false);
        player1.setRoom(room);
        player1.enterRoom(room);
        player1.setTile(room.getEnterDoor());
        player1.enterTile(room.getEnterDoor());
        players.add(player1);

        // initialize players

        return players;
    }

    private ArrayList<Monster> initMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();

        Monster monster1 = new Monster("Wolf", "MON01", 10, 1, 4, 20, true);
        monster1.setRoom(room);
        monster1.enterRoom(room);
        monster1.setTile(room.getEnterDoor());
        monster1.enterTile(room.getEnterDoor());
        monster1.enterTile(monster1.getTileByCoordinates(room, -2, 1));
//        System.out.println(monster1.getName() + " is at tile " + monster1.getCurrentTile().getX() + ", " + monster1.getCurrentTile().getY() + ")");
        monsters.add(monster1);

        // initialize monsters

        return monsters;
    }

    private ArrayList<NPC> initNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        NPC npc1 = new NPC("John Smith", "NPC01", 5, 2, 2, 15, false);
        npc1.setRoom(room);
        npc1.enterRoom(room);
        npc1.setTile(room.getEnterDoor());
        npc1.enterTile(room.getEnterDoor());
        npcs.add(npc1);

        // initialize npcs

        return npcs;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Monster> getMonsters() {
        return  monsters;
    }

    public ArrayList<NPC> getNpcs() {
        return npcs;
    }

    private boolean endCondition() {
        return false;
    }

    private void endGame() {
        // print some end of game stuff
    }
}
