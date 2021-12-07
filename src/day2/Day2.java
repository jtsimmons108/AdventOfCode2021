package day2;

import utils.AdventUtils;
import utils.Day;

import java.util.List;

public class Day2 implements Day {

    private List<String> input;

    public Day2(){
        input = AdventUtils.getInputAsList(2, false);
    }

    @Override
    public void solvePartOne() {
        int horizontal = 0, vertical = 0;
        for(String line : input){
            int space = line.indexOf(" ");
            String move = line.substring(0, space);
            int amount = Integer.parseInt(line.substring(space + 1));

            switch(move){
                case "forward": horizontal += amount; break;
                case "up": vertical -= amount; break;
                case "down": vertical += amount; break;
            }
        }
        System.out.println("Part 1: " + horizontal * vertical);
    }

    @Override
    public void solvePartTwo() {
        int horizontal = 0, vertical = 0, aim = 0;
        for(String line : input){
            int space = line.indexOf(" ");
            String move = line.substring(0, space);
            int amount = Integer.parseInt(line.substring(space + 1));

            switch(move){
                case "forward": horizontal += amount; vertical += aim * amount; break;
                case "up": aim -= amount; break;
                case "down": aim += amount; break;
            }
        }
        System.out.println("Part 2: " + horizontal * vertical);

    }
}
