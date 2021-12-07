package day6;

import utils.AdventUtils;
import utils.Day;

import java.util.Arrays;

public class Day6 implements Day {
    private String input;
    private int[] start;

    public Day6() {
        input = AdventUtils.getInputAsString(6, false);
        start = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    @Override
    public void solvePartOne() {
        System.out.println("Part 1: " + getTotalFish(start, 80));
    }

    @Override
    public void solvePartTwo() {
        System.out.println("Part 2: " + getTotalFish(start, 256));
    }

    private long getTotalFish(int[] original, int limit) {
        long[] added = new long[limit];
        for (int fish : original) {
            added[fish]++;
        }

        for (int i = 0; i < limit - 7; i++) {
            added[i + 7] += added[i];
            if (i + 9 < limit) {
                added[i + 9] += added[i];
            }
        }

        long total = original.length;
        for (long add : added) {
            total += add;
        }

        return total;
    }
}
