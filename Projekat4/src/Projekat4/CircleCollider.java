package Projekat4;

public class CircleCollider implements Collidable {

    private int cx, cy;
    private int radius;

    public CircleCollider(int cx, int cy, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Poluprečnik mora biti veći od nule.");
        }
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
    }

    private int clamp(int val, int min, int max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }

    @Override
    public boolean intersects(Collidable other) {

        if (other instanceof CircleCollider) {

            CircleCollider c = (CircleCollider) other;

            int dx = this.cx - c.cx;
            int dy = this.cy - c.cy;

            int distSq = dx * dx + dy * dy;
            int radiusSum = this.radius + c.radius;

            return distSq <= radiusSum * radiusSum;
        }
        else if (other instanceof RectangleCollider) {

            RectangleCollider r = (RectangleCollider) other;

            int closestX = clamp(cx, r.getX(), r.getX() + r.getWidth());
            int closestY = clamp(cy, r.getY(), r.getY() + r.getHeight());

            int dx = cx - closestX;
            int dy = cy - closestY;

            return dx * dx + dy * dy <= radius * radius;
        }

        return false;
    }

    @Override
    public String toString() {
        return "circle r=" + radius;
    }
}
