package Day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Day1.Day1;

public class Day5 {

    public static List<Stack<String>> getReorderedStacks(List<String> inputs){

        List<Stack<String>> stacks = new ArrayList<>();
        

        for(String item : inputs){

            int count = 0;

            for(int i = 1; i < item.length(); i+=4){

                //this checks if enough stacks are created
                if(stacks.size() <= (item.length() / 4)){ stacks.add(new Stack<String>()); }
                
                if(item.substring(i, i + 1).equals(" ")){ 

                    count++;
                    continue; 
                }                

                stacks.get(count).push(item.substring(i, i+1));
                count++;
            }

        }
        return stacks;

    }


    public static void main (String[] args){

        List<String> stacks = Day1.readFileInListWithRange("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day5.txt", 8);
        List<Stack<String>> filledStacks = getReorderedStacks(stacks);

        for(Stack<String> stack : filledStacks){

            for(String item: stack){ System.out.print(item); }

            System.out.println();
        }

    }
    
}
