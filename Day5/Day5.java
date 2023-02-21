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
        int count = 0;

        for(String item : commands){

            for(int i = 0; i < item.length(); i++){
                
                try{
                    
                    if(Integer.parseInt(item.substring(i, i + 1)) >= 0){

                        copyOfCommands.add(item.substring(i, i + 1));
                        count ++;

                        if((i < item.length() -2) && (Integer.parseInt(item.substring(i + 1 , i + 2)) >= 0)){ 

                            copyOfCommands.remove(count - 1);
                            copyOfCommands.add(item.substring(i, i + 1) + item.substring(i + 1 , i + 2));

                            i++;
                        }

                    }

                } catch(NumberFormatException exception){ continue; }

            

            }
        }

        return copyOfCommands;
    }

    public static List<Stack<String>> restructureStacks (List<Stack<String>> stacks, List<String> commands){
    
        for(int i = 0; i < commands.size(); i += 3){
            
            int amount = Integer.parseInt(commands.get(i));
            int origin = Integer.parseInt(commands.get(i + 1)) - 1;
            int destination = Integer.parseInt(commands.get(i + 2)) - 1;

            if(amount <= 1){ stacks.get(destination).push(stacks.get(origin).pop()); }

            else{

                List<String> placeholder = new ArrayList<>();

                for(int j = 0; j < amount; j++){
                
                    placeholder.add(stacks.get(origin).pop());

                }

                for(int k = 1; k <= amount; k++){

                    stacks.get(destination).push(placeholder.get(placeholder.size() - k));

                }
            }

            
        }
        
        return stacks;
    
    }

    public static void main (String[] args){

        List<String> stacks = Day1.readFileInListWithRange("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day5.txt", 0, 8);
        List<String> commands = Day1.readFileInListWithRange("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day5.txt", 11, 514);
        
        List<Stack<String>> filledStacks = getReorderedStacks(stacks);

        commands = Day5.getExactCommands(commands);

        for(int i = 0; i < 2 ; i++){ System.out.println(commands.get(i).length()); }

        filledStacks = Day5.restructureStacks(filledStacks, commands);
 
        for(Stack<String> stack : filledStacks){

            for(String item: stack){ System.out.print(item); }

            System.out.println();
        }
    }
    
}
