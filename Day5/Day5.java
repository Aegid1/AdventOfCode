package Day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Day1.Day1;

public class Day5 {

    public static List<Stack<String>> getReorderedStacks(List<String> inputs){

        List<Stack<String>> stacks = List.of();
        

        for(String item : inputs){

            int count = 0;

            for(int i = 0; i < item.length(); i+=4){

                if(item.substring(i, i).equals(" ")){ 

                    count++;
                    continue; 
                }                

                if(stacks.get(count) == null){ stacks.add(new Stack<String>()); }

                stacks.get(count).push(item.substring(i, i));
                count ++;
            }

        }
        return stacks;

    }


    public static void main (String[] args){

        List<String> stacks = Day1.readFileInListWithRange("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day5.txt", 8);
        List<Stack<String>> filledStacks = getReorderedStacks(stacks);

        Stack<String> stack1 = new Stack<String>();
        stack1.push("test1");
        stack1.push("test2");

        List<Stack<String>> list1 = new ArrayList<>();
        list1.add(stack1);

        for(Stack<String> stack : list1){

            for(String item: stack){ System.out.println(item); }
        }

    }
    
}
