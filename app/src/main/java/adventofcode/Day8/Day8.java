package adventofcode.Day8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import adventofcode.Day1.Day1;

public class Day8 {
    

    public static int getNumberOfVisibleTrees(List<String> matrix){

        for(String row : matrix){

            List<Integer> frontiers = new ArrayList<>();
            List<Integer> visibleTrees = new ArrayList<>();
            List<Integer> trees = new ArrayList<>();

            //converts every treesize from a char to an int
            for(int i = 0; i < row.length(); i++){ trees.add((int) row.charAt(i)); }



        }

        
        return 0;
    }


    public static void main (String args[]){

        List<String> matrix = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/app/src/main/resources/Inputs/input_day8.txt");
        List<Integer> maximums = List.of(9, 8, 9, 0, 7, 9);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(Collections.max(maximums));        
        
        
    }
}
