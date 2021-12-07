package utils;

import java.util.Objects;

public class Point {
    private int x, y;

    public Point(){
        this(0, 0);
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getManhattanDistanceFrom(Point other){
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)){
            return false;
        }
        Point other = (Point) obj;
        return this.x == other.x
                && this.y == other.y;
    }

    public String toString(){
        return String.format("(%d, %d)", x, y);
    }
}
