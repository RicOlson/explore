import java.util.ArrayList;
import java.util.Objects;

public class Engine {
    private int turnNumber = 0;
    private boolean gameOver = false;
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<NPC> npcs = new ArrayList<>();
    ArrayList<Monster> monsters = new ArrayList<>();

    public void game() {
        init();
        runGame();
        endGame();
    }

    public void init() {
        players = initPlayers();
        monsters = initMonsters();
        npcs = initNPCs();
    }

    public void runGame() {
        if (turnNumber < 1) {
            turnNumber++;
        }
        while (!gameOver) {
            runRound();
            turnNumber++;
        }
    }

    private void runRound() {
        for (Player player : players) {
            player.runTurn();
        }
        for (NPC npc : npcs) {
            npc.runTurn();
        }
        for (Monster monster : monsters) {
            monster.runTurn();
        }
        gameOver = true;
    }

    private ArrayList<Player> initPlayers() {
        ArrayList<Player> players = new ArrayList<>();

        Player player1 = new Player();
        players.add(player1);

        // initialize player characters

        return players;
    }

    private ArrayList<Monster> initMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();

        Monster monster1 = new Monster();
        monsters.add(monster1);

        // initialize player characters

        return monsters;
    }

    private ArrayList<NPC> initNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        NPC npc1 = new NPC();
        npcs.add(npc1);

        // initialize player characters

        return npcs;
    }

    private void endGame() {

    }
}
