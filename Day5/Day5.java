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

    public static List<Integer> getExactCommands (List<String> commands){

        List<Integer> copyOfCommands = new ArrayList<>();
        List<String> acceptableChars = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        
        for(String item : commands){

            for(int i = 0; i < item.length(); i++){
            
//                int test = Integer.parseInt(item.substring(i, i + 1));

//                if(acceptableChars.contains(item.substring(i, i + 1)) && item.substring(i + 1, i + 2) != ){ copyOfCommands.add(Integer.parseInt(item); }

            

//                copyOfCommands.add();
            }
        }

        return copyOfCommands;
    }

    public static List<Stack<String>> restructureStacks (List<Stack<String>> stacks, List<String> commands){
    
        for(String command : commands){

            String[] commandParts = command.split(" ");    

            int amount = Integer.parseInt(commandParts[0]);
            int origin = Integer.parseInt(commandParts[1]);
            int destination = Integer.parseInt(commandParts[2]);

            for(int i = 0; i < amount; i++){

                stacks.get(destination).push(stacks.get(origin).pop());

            }
        }
        
        return stacks;
    
    }

    public static void main (String[] args){

        List<String> stacks = Day1.readFileInListWithRange("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day5.txt", 0, 8);
        List<String> commands = Day1.readFileInListWithRange("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day5.txt", 11, 514);
        
        List<Stack<String>> filledStacks = getReorderedStacks(stacks);
        String test1 = " 11";
        System.out.println(Integer.parseInt(test1));
//        commands = Day5.getExactCommands(commands);

//        for(int i = 0; i < 2 ; i++){ System.out.println(commands.get(i).length()); }

//        filledStacks = Day5.restructureStacks(filledStacks, commands);
// 
//        for(Stack<String> stack : filledStacks){
//
//            for(String item: stack){ System.out.print(item); }
//
//            System.out.println();
//        }
    }
    
}
