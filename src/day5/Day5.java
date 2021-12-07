package day5;

import utils.AdventUtils;
import utils.Day;
import utils.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 implements Day {

    private List<Line> lines;

    public Day5() {
        lines = new ArrayList<>();

        List<String> input = AdventUtils.getInputAsList(5, false);
        Pattern pattern = Pattern.compile("(\\d+),(\\d+) -> (\\d+),(\\d+)");

        for (String line : input) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                int x1 = Integer.parseInt(matcher.group(1));
                int y1 = Integer.parseInt(matcher.group(2));
                int x2 = Integer.parseInt(matcher.group(3));
                int y2 = Integer.parseInt(matcher.group(4));
                lines.add(new Line(x1, y1, x2, y2));
            }
        }
    }

    @Override
    public void solvePartOne() {
        System.out.println("Part 1: " + getOverLaps(lines, false));
    }

    @Override
    public void solvePartTwo() {
        System.out.println("Part 2: " + getOverLaps(lines, true));
    }

    private int getOverLaps(List<Line> lines, boolean diagonalsAllowed) {
        Map<Point, Integer> counts = new HashMap<>();
        for (Line line : lines) {
            if (diagonalsAllowed || !line.isDiagonal()) {
                for (Point point : line.getPoints()) {
                    counts.put(point, counts.getOrDefault(point, 0) + 1);
                }
            }
        }

        int total = 0;
        for(int count : counts.values()){
            if(count > 1){
                total++;
            }
        }
        return total;
    }
}
