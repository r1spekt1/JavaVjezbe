package projekat5;

public class BossEnemy extends Enemy {

    public BossEnemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(type, x, y, collider, damage, health);
    }

    @Override
    public int getEffectiveDamage() {
        return damage * 2;
    }

    @Override
    public String toString() {
        return "BossEnemy[" + type + "] @ (" + getX() + "," + getY() + ") "
                + collider + " DMG=" + damage + "x2 HP=" + health;
    }
}

