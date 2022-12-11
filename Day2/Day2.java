package Day2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Day1.Day1;
// A: Rock, B: Paper, C: Scissors -> X: Rock, Y: Paper, Z: Scissors
// should not win every time -> suspicious
// lose = 0 points, draw = 3 points, win = 6 points + 
// Rock = 1 point, Paper = 2 points, Scissors = 3 Points
public class Day2 {

    static Map<String, Integer> points_rules = Map.of(
            "X", 1,
            "Y", 2,
            "Z", 3
    );


    public static int fight(String signs){
        
        int result = 0;
        List<String> hand_signs = List.of(signs.split(""));

        String my_choice = hand_signs.get(2);
        String enemy_choice = hand_signs.get(0);

        result = points_rules.get(my_choice);

        if((enemy_choice.equals("A") && my_choice.equals("Y")) 
        || (enemy_choice.equals("B") && my_choice.equals("Z"))
        || (enemy_choice.equals("C") && my_choice.equals("X"))){
            
            result += 6;
        }

        if((enemy_choice.equals("A") && my_choice.equals("Z")) 
        || (enemy_choice.equals("B") && my_choice.equals("X"))
        || (enemy_choice.equals("C") && my_choice.equals("Y"))){
            
            result += 0;
        }
        
        if((enemy_choice.equals("A") && my_choice.equals("X")) 
        || (enemy_choice.equals("B") && my_choice.equals("Y"))
        || (enemy_choice.equals("C") && my_choice.equals("Z"))){
            
            result += 3;
        }

        return result;
    }
    

    public static void main(String[] args){
        
        int points = 0;
        List <String> inputs = Day1.readFileInList("Inputs/input_day2.txt");

        for(String iterator : inputs){ points += fight(iterator); }

        System.out.println(points);

    }
}
