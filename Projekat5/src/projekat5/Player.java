package projekat5;

public class Player extends GameObject {

    private String name;
    private int health;

    public Player(String name, int x, int y, Collidable collider, int health) {
        super(x, y, collider);
        this.setName(name);
        this.setHealth(health);
    }

    private String formatName(String s) {
        s = s.trim().replaceAll("\\s+", " ");

        if (s.isEmpty()) return "";

        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String p : parts) {
            sb.append(Character.toUpperCase(p.charAt(0)))
              .append(p.substring(1).toLowerCase())
              .append(" ");
        }
        return sb.toString().trim();
    }

    public void setName(String name) {
        String f = formatName(name);
        if (f.isEmpty()) {
            throw new IllegalArgumentException("Ime ne moze biti prazno.");
        }
        this.name = f;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health mora biti 0-100.");
        }
        this.health = health;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player[" + name + "] @ (" + getX() + "," + getY() + ") " + collider + " HP=" + health;
    }
}
