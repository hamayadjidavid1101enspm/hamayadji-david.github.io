package fr.Rectangle;

/**
 * Classe représentant un point 2D
 */
public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Point[x=%.2f, y=%.2f]", x, y);
    }
}
