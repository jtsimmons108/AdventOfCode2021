package day1;

import utils.AdventUtils;
import utils.Day;

import java.util.List;

public class Day1 implements Day {

    private List<String> input;
    private int[] depths;

    public Day1(){
        input = AdventUtils.getInputAsList(1, false);
        depths = input.stream().mapToInt(Integer::parseInt).toArray();
    }

    @Override
    public void solvePartOne() {
        int count = 0;
        for(int i = 0; i < depths.length - 1; i++){
            if (depths[i] < depths[i + 1]){
                count++;
            }
        }
        System.out.println("Part 1: " + count);
    }

    @Override
    public void solvePartTwo() {
        int count = 0;
        for(int i = 0; i < depths.length - 3; i++){
            if (depths[i] < depths[i + 3]){
                count++;
            }
        }
        System.out.println("Part 2: " + count);
    }
}
