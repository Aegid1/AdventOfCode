package Day3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Day1.Day1;

public class Day3 {
    
    public static int getPriority(String input){
        
        int priority = 0;
        String first_compartment = input.substring(0, ((input.length()/2)));

        if(input.length() % 2 == 1){ first_compartment = input.substring(0, (input.length()/2)); }

        String second_compartment = input.substring(first_compartment.length(), input.length());

        System.out.println(first_compartment.length());
        System.out.println(second_compartment.length());
        System.out.println(input.length());

        Set<String> first_compartment_set = new HashSet<>(List.of(first_compartment.split("")));
        Set<String> second_compartment_set = new HashSet<>(List.of(second_compartment.split("")));


        for(String character : first_compartment_set){

            if(second_compartment_set.contains(character)){ 
                
                int temporary_priority = ((int) (character.charAt(0))) % 64;    

                if(temporary_priority > 26){ temporary_priority = (((int) character.charAt(0)) % 96); }

                else { temporary_priority += 26; }
                                
                if(temporary_priority > priority){ priority = temporary_priority; }

            }

        }
        
        return priority;
    }


    public static void main(String[] args){
        
        int sum = 0;
        List<String> inputs = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day3.txt");

        for(String rucksack : inputs){ sum += getPriority(rucksack); }
        System.out.println(sum);   
    }
}
