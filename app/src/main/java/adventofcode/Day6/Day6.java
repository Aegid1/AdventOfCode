package adventofcode.Day6;
import java.util.ArrayList;
import java.util.List;

import adventofcode.Day1.Day1;

public class Day6 {
    
    public static int getMarker(String input){

        for(int i = 13; i < input.length(); i++){

            List<Character> list = new ArrayList<>();

            for(int k = 0; k < 14; k++){

                if(list.contains(input.charAt(i - k))){ 
                    
                    list.clear();
                    break; 
                }

                list.add(input.charAt(i - k));

                if(list.size() == 14){ return i + 1; }
                
            }


        }
        return 0;

    }
    public static void main (String[] args){

        List<String> input = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day6.txt");
        String sequence = input.get(0);
        System.out.println(getMarker(sequence));
    }
}
