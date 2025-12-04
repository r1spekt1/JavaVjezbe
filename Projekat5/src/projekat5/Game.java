package projekat5;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Collections;
import javax.swing.SwingUtilities;

public class Game {

    private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> eventLog = new ArrayList<>();

    public Game(Player p) {
        if (p == null) throw new IllegalArgumentException("Player ne smije biti null.");
        this.player = p;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<String> getEventLog() {
        return eventLog;
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

    public static ArrayList<Enemy> loadEnemiesFromCSV(String filePath) throws IOException {
        // Prvo učitamo sve neprijatelje iz CSV-a
        ArrayList<Enemy> allEnemies = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                
                // Preskačemo header red
                if (isFirstLine) {
                    isFirstLine = false;
                    // Proveravamo da li je ovo header red
                    if (line.toLowerCase().contains("type") || line.toLowerCase().contains("class")) {
                        continue;
                    }
                    // Ako nije header, procesiramo ga kao običan red
                }
                
                try {
                    Enemy enemy = parseCSVLine(line);
                    allEnemies.add(enemy);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Neispravan zapis u CSV: " + line, e);
                }
            }
        }
        
        // Sada biramo random broj neprijatelja
        if (allEnemies.isEmpty()) {
            return allEnemies; // Vraćamo prazan niz ako nema neprijatelja
        }
        
        Random random = new Random();
        int totalEnemies = allEnemies.size();
        
        // Biramo random broj između 1 i totalnog broja neprijatelja
        int numberOfEnemiesToLoad = random.nextInt(totalEnemies) + 1;
        
        // Mešamo listu da dobijemo random redosled
        Collections.shuffle(allEnemies, random);
        
        // Uzimamo samo potreban broj neprijatelja
        ArrayList<Enemy> selectedEnemies = new ArrayList<>();
        for (int i = 0; i < numberOfEnemiesToLoad; i++) {
            selectedEnemies.add(allEnemies.get(i));
        }
        
        return selectedEnemies;
    }

    public static ArrayList<Enemy> loadEnemiesFromCSV(String filePath, int minEnemies, int maxEnemies) throws IOException {
        // Učitavamo sve neprijatelje
        ArrayList<Enemy> allEnemies = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                
                if (isFirstLine) {
                    isFirstLine = false;
                    if (line.toLowerCase().contains("type") || line.toLowerCase().contains("class")) {
                        continue;
                    }
                }
                
                try {
                    Enemy enemy = parseCSVLine(line);
                    allEnemies.add(enemy);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Neispravan zapis u CSV: " + line, e);
                }
            }
        }
        
        if (allEnemies.isEmpty()) {
            return allEnemies;
        }
        
        // Validacija parametara
        int totalEnemies = allEnemies.size();
        minEnemies = Math.max(1, Math.min(minEnemies, totalEnemies));
        maxEnemies = Math.max(minEnemies, Math.min(maxEnemies, totalEnemies));
        
        Random random = new Random();
        int numberOfEnemiesToLoad = random.nextInt(maxEnemies - minEnemies + 1) + minEnemies;
        
        Collections.shuffle(allEnemies, random);
        
        ArrayList<Enemy> selectedEnemies = new ArrayList<>();
        for (int i = 0; i < numberOfEnemiesToLoad; i++) {
            selectedEnemies.add(allEnemies.get(i));
        }
        
        return selectedEnemies;
    }

    private static Enemy parseCSVLine(String line) {
        // Novi format: type,class,damage,health,x,y,shape,width,height,radius
        String[] parts = line.split(",", -1); // -1 čuva prazna polja na kraju
        if (parts.length != 10) {
            throw new IllegalArgumentException("CSV red mora imati tačno 10 kolona, ima: " + parts.length);
        }
        
        String type = parts[0].trim();
        String enemyClass = parts[1].trim();
        int damage = Integer.parseInt(parts[2].trim());
        int health = Integer.parseInt(parts[3].trim());
        int x = Integer.parseInt(parts[4].trim());
        int y = Integer.parseInt(parts[5].trim());
        String shape = parts[6].trim();
        
        Collidable collider;
        if (shape.equalsIgnoreCase("rectangle")) {
            int width = Integer.parseInt(parts[7].trim());
            int height = Integer.parseInt(parts[8].trim());
            collider = new RectangleCollider(x, y, width, height);
        } else if (shape.equalsIgnoreCase("circle")) {
            int radius = Integer.parseInt(parts[9].trim());
            collider = new CircleCollider(x, y, radius);
        } else {
            throw new IllegalArgumentException("Nepoznat oblik kolajdera: " + shape);
        }
        
        if (enemyClass.equalsIgnoreCase("melee")) {
            return new MeleeEnemy(type, x, y, collider, damage, health);
        } else if (enemyClass.equalsIgnoreCase("boss")) {
            return new BossEnemy(type, x, y, collider, damage, health);
        } else {
            throw new IllegalArgumentException("Nepoznata klasa neprijatelja: " + enemyClass);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameGUI().setVisible(true);
        });
    }
}

