package day3;

import utils.AdventUtils;
import utils.Day;

import java.util.ArrayList;
import java.util.List;

public class Day3 implements Day {

    private List<String> input;

    public Day3() {
        input = AdventUtils.getInputAsList(3, false);
    }

    @Override
    public void solvePartOne() {
        int width = input.get(0).length();
        int[] cols = new int[width];

        for (String line : input) {
            for (int i = 0; i < width; i++) {
                cols[i] += line.charAt(i) - '0';
            }
        }
        String gamma = "", espilon = "";

        for (int count : cols) {
            int common = (count * 2) / input.size();
            gamma += common;
            espilon += (common ^ 1);
        }
        System.out.println("Part 1: " + Integer.parseInt(gamma, 2) * Integer.parseInt(espilon, 2));

    }

    @Override
    public void solvePartTwo() {
        final int TYPE_OXY = 0, TYPE_CO2 = 1;
        int oxy = filterValues(new ArrayList<>(input), TYPE_OXY);
        int co2 = filterValues(new ArrayList<>(input), TYPE_CO2);
        System.out.println("Part 2: " + oxy * co2);
    }

    private int filterValues(List<String> inputs, int type) {
        int index = 0;
        while (inputs.size() > 1) {
            int count = 0;
            for (String poss : inputs) {
                count += poss.charAt(index) - '0';
            }
            int common = ((count * 2) / inputs.size()) ^ type;
            for (int i = inputs.size() - 1; i >= 0; i--) {
                if (inputs.get(i).charAt(index) != (char) (common + '0')) {
                    inputs.remove(i);
                }
            }
            index++;
        }
        return Integer.parseInt(inputs.get(0), 2);
    }
}
