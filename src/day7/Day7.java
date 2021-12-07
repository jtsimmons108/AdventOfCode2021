package day7;

import utils.AdventUtils;
import utils.Day;

import java.util.Arrays;

public class Day7 implements Day {

    private int[] distances;
    private int maxDistance;

    public Day7(){
        distances = Arrays.stream(AdventUtils.getInputAsString(7, false).split(","))
                .mapToInt(Integer::parseInt).toArray();
        for (int distance : distances){
            maxDistance = Math.max(maxDistance, distance);
        }
    }

    @Override
    public void solvePartOne() {
        int min = Integer.MAX_VALUE;
        for(int position = 0; position < maxDistance; position++){
            int total = 0;
            for (int distance : distances){
                total += Math.abs(distance - position);
            }
            min = Math.min(min, total);
        }
        System.out.println("Part 1: " + min);
    }

    @Override
    public void solvePartTwo() {
        long min = Long.MAX_VALUE;
        for(int position = 0; position < maxDistance; position++){
            long total = 0L;
            for (int distance : distances){
                int diff = Math.abs(distance - position);
                total += diff * (diff + 1) / 2;
            }
            min = Math.min(min, total);
        }
        System.out.println("Part 2: " + min);
    }
}
