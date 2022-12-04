package Day1;

import java.io.IOException;
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


    public static int getMaxCalories(List<String> calories){
        
        int maximum = 0;
        int result = 0;

        for(String item : calories){

            if(item.equals("")){

                if(result > maximum){ 
                    maximum = result;
                }

                result = 0;
                continue;
            }
            else{ result += Integer.parseInt(item); }
        
        }
        
        return maximum;

    }

    public static void main(String[] args){

        List<String> calories = readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day1.txt");
        System.out.println(getMaxCalories(calories));
        
    }    
}