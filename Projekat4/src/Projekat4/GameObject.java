package Projekat4;

public abstract class GameObject {

    private int x, y;
    protected Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        this.setX(x);
        this.setY(y);

        if (collider == null) {
            throw new IllegalArgumentException("Collider ne smije biti null.");
        }
        this.collider = collider;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public boolean intersects(GameObject other) {
        return this.collider.intersects(other.collider);
    }

    public abstract String getDisplayName();

    @Override
    public String toString() {
        return "GameObject @" + "(" + x + "," + y + ")";
    }
}
