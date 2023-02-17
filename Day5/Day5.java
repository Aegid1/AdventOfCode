package Day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Day1.Day1;

public class Day5 {

    public static List<Stack<String>> getReorderedStacks(List<String> inputs){

        List<Stack<String>> stacks = new ArrayList<>();
        

        for(int k = 1; k <= inputs.size(); k++){

            String item = inputs.get(inputs.size() - k);
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

    public static List<String> getExactCommands (List<String> commands){

        List<String> copyOfCommands = new ArrayList<>();

        for(String item : commands){

            String command = item;
            
            command = command.replaceAll("move", " ");
            command = command.replaceAll("from", " ");
            command = command.replaceAll("to", " ");

            copyOfCommands.add(command);

        }

        return copyOfCommands;
    }

    public static List<Stack<String>> restructureStacks (List<Stack<String>> stacks, List<String> commands){
    
        
    }

    public static void main (String[] args){

        List<String> stacks = Day1.readFileInListWithRange("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day5.txt", 0, 8);
        List<String> commands = Day1.readFileInListWithRange("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day5.txt", 11, 514);
        
        List<Stack<String>> filledStacks = getReorderedStacks(stacks);

        commands = Day5.getExactCommands(commands);
 
        for(String command : commands){ System.out.println(command); }

//        for(Stack<String> stack : filledStacks){
//
//            for(String item: stack){ System.out.print(item); }
//
//            System.out.println();
//        }
    }
    
}
