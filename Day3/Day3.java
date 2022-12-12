package Day3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Day1.Day1;

public class Day3 {
    
    public static int getPriority(String input){
        
        int priority_count = 0;
        String first_compartment = input.substring(0, ((input.length()/2) -1));
        if(input.length() % 2 == 1){ first_compartment = input.substring(0, (input.length()/2)); }
        String second_compartment = input.substring(first_compartment.length());
        
        List<String> first_compartment_list = List.of(first_compartment.split(""));
        List<String> second_compartment_list = List.of(second_compartment.split(""));

        for(int i = 0; i < first_compartment.length(); i++){

            if(second_compartment.contains(first_compartment.charAt(i))){ }
        }


        return priority_count;
    }

    public static void main(String[] args){
        String test = "abc";
        List<String> inputs= Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day3.txt");
    }
}
