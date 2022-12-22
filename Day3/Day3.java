package Day3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Day1.Day1;

public class Day3 {
    
    public static int getPriorityBy2Compartments(String input){
        
        int priority = 0;
        String first_compartment = input.substring(0, ((input.length()/2)));

        if(input.length() % 2 == 1){ first_compartment = input.substring(0, (input.length()/2) + 1); }

        String second_compartment = input.substring(first_compartment.length(), input.length());

        Set<String> first_compartment_set = new HashSet<>(List.of(first_compartment.split("")));
        Set<String> second_compartment_set = new HashSet<>(List.of(second_compartment.split("")));


        for(String character : first_compartment_set){

            int temporary_priority = 0;

            if(second_compartment_set.contains(character)){ 
                
                temporary_priority = getPriority(character, priority);

                if(temporary_priority > priority){ priority = temporary_priority; }
            }

        }
        
        return priority;
    }


    public static int getPriority(String input, int priority){

        int temporary_priority = ((int) (input.charAt(0))) % 64;    

        if(temporary_priority > 26){ temporary_priority = (((int) input.charAt(0)) % 96); }

        else { temporary_priority += 26; }
                        
        return temporary_priority;
    }


    public static int getPriorityBy3Bags(List<String> inputList){

        int i = 0;
        int priority1 = 0;
        int sum = 0;
        int temporary_priority = 0;
        
        while(i < inputList.size()){

            Set<String> comparator = new HashSet<>(List.of(inputList.get(i).split("")));
            Set<String> secondBag = new HashSet<>(List.of(inputList.get(i+1).split("")));
            Set<String> thirdBag = new HashSet<>(List.of(inputList.get(i+2).split("")));

            for(String character : comparator){

                if(secondBag.contains(character) && thirdBag.contains(character)){ temporary_priority = getPriority(character, priority1); }

                if(temporary_priority > priority1){ priority1 = temporary_priority; }
                

            }

            if(temporary_priority < 53){ sum += priority1; }

            temporary_priority = 0;

            i += 3;
        }


        return sum;
    }

    public static void main(String[] args){
        
        //int sum = 0;
        List<String> inputs = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day3.txt");
        System.out.println(getPriorityBy3Bags(inputs));

        //for(String rucksack : inputs){ sum += getPriorityBy2Compartments(rucksack); }
        //System.out.println(sum);   
    }
}
