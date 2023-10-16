import java.util.ArrayList;
import java.util.Objects;

public class Engine {
    public static Engine engine = null;
    private int turnNumber = 0;
    private boolean gameOver = false;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<NPC> npcs = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();
    private final Map map = Map.getInstance();
    static Render render = new Render();
    private Room room = map.getRoomArray().get(0);

    public void game() {
        init();
        runGame();
        endGame();
    }

    private void init() {
        for (int i = 0; i < map.getRoomArray().size(); i++) {
            map.getRoomArray().get(i).initRoom();
        }
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
        if (turnNumber == 0) {
            render.RenderBoard();
//            renderStats();
            turnNumber++;
        }

        for (Monster monster : monsters) {
            monster.runTurn();
        }
        for (Player player : players) {
            player.runTurn();
        }
        for (NPC npc : npcs) {
            npc.runTurn();
        }

        System.out.println("----------Turn-"+turnNumber+"----------");
        render.RenderBoard();
//        renderStats();

        gameOver = true;
    }

    private ArrayList<Player> initPlayers() {
        ArrayList<Player> players = new ArrayList<>();

        Player player1 = new Player("Legend", "PLA01", 15, 3, 2, 10, false);
        player1.setRoom(map.getRoomArray().get(0));
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
        monster1.enterTile(monster1.getCurrentTile().getTileByCoordinates(room, -2, 1));
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

    public static synchronized  Engine getInstance() {
        if (engine == null) {
            engine = new Engine();
        }

        return engine;
    }
}
