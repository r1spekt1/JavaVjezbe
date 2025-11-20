package Projekat4;

public class RectangleCollider implements Collidable {

    private int x, y;
    private int width, height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimenzije moraju biti veće od nule.");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    @Override
    public boolean intersects(Collidable other) {
        if (other instanceof RectangleCollider) {

            RectangleCollider r = (RectangleCollider) other;

            boolean nemaPreklapanja =
                    r.x > this.x + this.width ||
                    r.x + r.width < this.x ||
                    r.y > this.y + this.height ||
                    r.y + r.height < this.y;

            return !nemaPreklapanja;
        }
        else if (other instanceof CircleCollider) {
            return other.intersects(this);
        }
        return false;
    }

    @Override
    public String toString() {
        return width + "x" + height;
    }
}
