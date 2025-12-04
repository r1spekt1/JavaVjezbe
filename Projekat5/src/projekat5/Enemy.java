package projekat5;

public class Enemy extends GameObject implements Attacker {

    protected String type;
    protected int damage;
    protected int health;

    public Enemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(x, y, collider);
        this.setType(type);
        this.setDamage(damage);
        this.setHealth(health);
    }

    public void setType(String t) {
        if (t == null || t.trim().isEmpty()) {
            throw new IllegalArgumentException("Tip ne može biti prazan.");
        }
        this.type = t.trim();
    }

    public void setDamage(int d) {
        if (d < 0 || d > 100) throw new IllegalArgumentException("Damage 0–100.");
        this.damage = d;
    }

    public void setHealth(int h) {
        if (h < 0 || h > 200) throw new IllegalArgumentException("Health 0–200.");
        this.health = h;
    }

    @Override
    public int getEffectiveDamage() {
        return damage;
    }

    @Override
    public String getDisplayName() {
        return type;
    }

    @Override
    public String toString() {
        return "Enemy[" + type + "] @ (" + getX() + "," + getY() + ") "
                + collider + " DMG=" + damage + " HP=" + health;
    }
}
