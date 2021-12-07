package utils;

import day1.Day1;
import day2.Day2;
import day3.Day3;
import day5.Day5;
import day6.Day6;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        runAllDays();
    }

    public static void runAllDays(){
        List<Day> days = List.of(new Day1(), new Day2(), new Day3(), new Day5(), new Day6());
        for(Day day : days){
            System.out.println("********");
            System.out.println(day.getClass().getSimpleName());
            System.out.println("********");
            day.solvePartOne();
            day.solvePartTwo();
        }
    }
}
