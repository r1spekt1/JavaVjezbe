package Projekat4;

import java.util.ArrayList;

public class Game {

    private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> eventLog = new ArrayList<>();

    public Game(Player p) {
        if (p == null) throw new IllegalArgumentException("Player ne smije biti null.");
        this.player = p;
    }

    public void addEnemy(Enemy e) {
        if (e == null) throw new IllegalArgumentException("Enemy ne smije biti null.");
        enemies.add(e);
        eventLog.add("ADD: " + e.getDisplayName());
    }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        if (p == null || e == null) {
            throw new IllegalArgumentException("Null reference u decreaseHealth.");
        }

        int oldHp = p.getHealth();
        int dmg = e.getEffectiveDamage();
        int newHp = Math.max(0, oldHp - dmg);

        p.setHealth(newHp);

        eventLog.add("HIT: Player by " + e.getDisplayName()
                + " for " + dmg + " -> HP " + oldHp + " -> " + newHp);
    }

    public ArrayList<Enemy> findByType(String query) {
        ArrayList<Enemy> list = new ArrayList<>();
        String q = query.toLowerCase();

        for (Enemy e : enemies) {
            if (e.type.toLowerCase().contains(q)) {
                list.add(e);
            }
        }
        return list;
    }

    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> list = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) list.add(e);
        }
        return list;
    }

    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }

    public static Enemy parseEnemy(String line) {
        try {
            // primjer: "Goblin:12,5;16x16;20;boss"
            String[] parts = line.split(":");
            String type = parts[0].trim();

            String[] rest = parts[1].split(";");
            String[] pos = rest[0].split(",");
            String[] size = rest[1].split("x");

            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            int w = Integer.parseInt(size[0]);
            int h = Integer.parseInt(size[1]);

            int dmg = Integer.parseInt(rest[2]);

            String flag = rest.length > 3 ? rest[3].trim() : "";

            Collidable col = new RectangleCollider(x, y, w, h);

            if (flag.equalsIgnoreCase("boss")) {
                return new BossEnemy(type, x, y, col, dmg, 100);
            } else {
                return new MeleeEnemy(type, x, y, col, dmg, 60);
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Neispravan format: " + line);
        }
    }

    public static void main(String[] args) {

        Player pl = new Player(
                "  petar    petrović ",
                10, 5,
                new RectangleCollider(10, 5, 32, 32),
                85
        );

        Game game = new Game(pl);

        Enemy e1 = new MeleeEnemy(
                "Goblin",
                12, 5,
                new RectangleCollider(12, 5, 16, 12),
                20,
                60
        );

        game.addEnemy(e1);

        Enemy e2 = parseEnemy("Orc:15,5;20x20;15;boss");
        game.addEnemy(e2);

        System.out.println("=== ENEMIES ===");
        for (Enemy e : game.enemies) {
            System.out.println(e);
        }

        System.out.println("\n=== FIND 'gob' ===");
        System.out.println(game.findByType("gob"));

        System.out.println("\nPlayer before: " + pl);

        game.resolveCollisions();

        System.out.println("Player after: " + pl);

        System.out.println("\n=== EVENT LOG ===");
        for (String s : game.eventLog) {
            System.out.println(s);
        }
    }
}

