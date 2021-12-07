package day5;

import utils.Point;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Point> points;
    private boolean diagonal;

    public Line(int x1, int y1, int x2, int y2){
        points = new ArrayList<>();
        int x = x1, y = y1;
        int dx = x2 - x1;
        int dy = y2 - y1;

        while (x != x2 || y != y2){
            points.add(new Point(x, y));
            x += dx == 0 ? 0 : dx / Math.abs(x2 - x1);
            y += dy == 0 ? 0 : dy / Math.abs(y2 - y1);
        }

        points.add(new Point(x2, y2));

        diagonal = x1 != x2 && y1 != y2;
    }

    public List<Point> getPoints(){
        return points;
    }

    public boolean isDiagonal(){
        return diagonal;
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
