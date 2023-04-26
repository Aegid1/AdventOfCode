package adventofcode.Day8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import adventofcode.Day1.Day1;

public class Day8 {
    

    public static List<String> getNumberOfVisibleTreesHorizontally(List<String> matrix){

        List<String> visibleTrees = new ArrayList<>();

        for(int j = 0; j < matrix.size(); j++){
            String row = matrix.get(j);

            int frontier = 0;
            List<Integer> trees = new ArrayList<>();

            //converts every treesize from a char to an int
            for(int i = 0; i < row.length(); i++){ trees.add((int) row.charAt(i)); } 
            int max = Collections.max(trees);

            int last_index = trees.lastIndexOf(max);
            int first_index = trees.indexOf(max);

            //adds the coordinates of the two highest trees to the visible trees if existing
            visibleTrees.add(j + "" + first_index);
            if(last_index != first_index){ visibleTrees.add(j + "" + last_index); }

            //adds all the coordinates of the trees, that can be seen starting from the left
            frontier = trees.get(0);
            for(int i = 1; i < first_index; i++){
                
                if(frontier < trees.get(i)){

                    visibleTrees.add(j + "" + i);
                    frontier = trees.get(i);

                }

            }
            frontier = 0;

            
            //adds all trees, that can be seen starting from the right
            frontier = trees.get(trees.size()-1);
            for(int i = trees.size() -1 ; i < last_index; i--){
                
                if(frontier < trees.get(i)){

                    visibleTrees.add(j + "" + i);
                    frontier = trees.get(i);

                }

            }

        }

        
        return visibleTrees;
    }


    public static void main (String args[]){

        List<String> matrix = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/app/src/main/resources/Inputs/input_day8.txt");
        List<String> maximums = List.of("9807");
        List<String> result = getNumberOfVisibleTreesHorizontally(maximums);

        System.out.println(result.size());
        

    }
}
