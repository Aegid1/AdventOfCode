package adventofcode.Day8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import adventofcode.Day1.Day1;

public class Day8 {
    
    public static List<String> getVisibleTreesHorizontally(List<String> matrix){

        List<String> visibleTrees = new ArrayList<>();
        for(int j = 0; j < matrix.size(); j++){
            String row = matrix.get(j);

            int frontier = 0;
            List<Integer> trees = new ArrayList<>();

            //converts every treesize from a char to an int
            for(int i = 0; i < row.length(); i++){ trees.add( Integer.parseInt(row.substring(i, i +1))); } 

            int max = Collections.max(trees);

            int last_index = trees.lastIndexOf(max);
            int first_index = trees.indexOf(max);

            //adds the coordinates of the two highest trees to the visible trees if existing
            visibleTrees.add(j + "" + first_index);
            if(last_index != first_index){ visibleTrees.add(j + "" + last_index); }

            //only adds the tree on the border if it isnt the max-sized-tree
            frontier = trees.get(0);
            if(first_index != 0){ visibleTrees.add(j + "" + 0); }

            //adds all the coordinates of the trees, that can be seen starting from the left
            for(int i = 1; i < first_index; i++){
                
                if(frontier < trees.get(i)){
                    
                    visibleTrees.add(j + "" + i);
                    frontier = trees.get(i);

                }

            }
            frontier = 0;

            //only adds the tree on the border if it isnt the max-sized-tree
            frontier = trees.get(trees.size()-1);
            if(last_index != trees.size()-1){ visibleTrees.add(j + "" + (trees.size()-1)); }
            
            //adds all trees, that can be seen starting from the right
            for(int i = trees.size() -2 ; i > last_index; i--){

                if(frontier < trees.get(i)){

                    visibleTrees.add(j + "" + i);
                    frontier = trees.get(i);

                }

            }

        }

        return visibleTrees;
    }


    public static List<String> getVisibleTreesVertically(List<String> input){

        List<String> visibleTrees = new ArrayList<>();
        for(int cols = 0; cols < input.get(0).length(); cols++){

            int frontier = 0;
            
            //this puts every tree vertically seen into a list
            List<Integer> trees = new ArrayList<>();
            for(String treeSizes : input){ trees.add(Integer.parseInt(treeSizes.substring(cols, cols+1))); } 

            int max = Collections.max(trees);

            //last_index and first_index are here not representing the columns, rather representing the rows
            int last_index = trees.lastIndexOf(max);
            int first_index = trees.indexOf(max);

            visibleTrees.add(first_index + "" + cols);
            if(last_index != first_index){ visibleTrees.add(last_index + "" + cols); }

            frontier = trees.get(0);
            if(first_index != 0){ visibleTrees.add(0 + "" + cols); }

            for(int rows = 1; rows < first_index; rows++){
                
                if(frontier < trees.get(rows)){
                    
                    visibleTrees.add(rows + "" + cols);
                    frontier = trees.get(rows);

                }

            }
            frontier = 0;

            
            frontier = trees.get(trees.size()-1);
            if(last_index != trees.size() -1){ visibleTrees.add((trees.size()-1) + "" + cols); }
            
            //adds all trees, that can be seen starting from the right
            for(int rows = trees.size() -2 ; rows > last_index; rows--){

                if(frontier < trees.get(rows)){

                    visibleTrees.add(rows + "" + cols);
                    frontier = trees.get(rows);

                }

            }
        }

        return visibleTrees;
    } 

    public static int getTotalNumberOfVisibleTrees(List<String> treesHorizontal, List<String> treesVertical){

        List<String> uniqueTrees = new ArrayList<>(treesHorizontal);

        for(String tree : treesVertical){

            if(!uniqueTrees.contains(tree)){uniqueTrees.add(tree); }

        }        
        
        return uniqueTrees.size();
    }

    public static void main (String args[]){

        List<String> matrix = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/app/src/main/resources/Inputs/input_day8.txt");
        List<String> horizontalTrees = getVisibleTreesHorizontally(matrix);
        List<String> verticalTrees = getVisibleTreesVertically(matrix);
        int result = getTotalNumberOfVisibleTrees(horizontalTrees, verticalTrees);
 
        System.out.println(result);
        
    }
}
