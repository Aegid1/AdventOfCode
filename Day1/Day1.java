package Day1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1{
    
    public static List<String> readFileInList(String filename){

        List<String> allCalories = new ArrayList<>();

        try{ allCalories = Files.readAllLines(Paths.get(filename)); }
        
        catch(IOException exception)
            { System.out.println("Your file does not exist."); }

        return allCalories;
    }


    public static List<Integer> getMaxCalories(List<String> calories){
        
        int result = 0;
        int firstPlace = 0;
        int secondPlace = 0;
        int thirdPlace = 0;

        for(String item : calories){

            
            if(item.equals("") || item.equals(calories.get(calories.size() -1))){

                if(item.equals(calories.get(calories.size() -1))){ result += Integer.parseInt(item);}

                if(result > firstPlace){
                    thirdPlace = secondPlace;
                    secondPlace = firstPlace;
                    firstPlace = result;
                    result = 0;
                    continue;
                }

                if(result > secondPlace){
                    thirdPlace = secondPlace;
                    secondPlace = result;
                    result = 0;
                    continue;
                }

                if(result > thirdPlace){
                    thirdPlace = result;
                    result = 0;
                    continue;
                }

                result = 0;

            }
            else { result += Integer.parseInt(item); }
        
        }
        
        return List.of(firstPlace, secondPlace, thirdPlace);

    }

    public static void main(String[] args){
        int result = 0;
        List<String> calories = readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day1.txt");
        List<Integer> mostCalories = getMaxCalories(calories);

        for(int item : mostCalories){ 
            result = item + result;
        }
        
        System.out.println(result);  
        
        }
}