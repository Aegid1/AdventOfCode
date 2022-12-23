package Day4;

import java.util.List;

import Day1.Day1;

public class Day4 {
    

    public static int getOverlappings(List<String> inputs){

        int count = 0;

        for(String pair : inputs){

            List<String> onePair = List.of(pair.split(","));

            List<String> firstPair = List.of((onePair.get(0).split("-")));
            List<String> secondPair = List.of((onePair.get(1).split("-")));

            int firstBoundaryFirstPair = Integer.parseInt(firstPair.get(0));
            int secondBoundaryFirstPair = Integer.parseInt(firstPair.get(1));

            int firstBoundarySecondPair = Integer.parseInt(secondPair.get(0));
            int secondBoundarySecondPair = Integer.parseInt(secondPair.get(1));

            //this checks if the first pair is in the second pair included
            if((firstBoundaryFirstPair >= firstBoundarySecondPair && firstBoundaryFirstPair <= secondBoundarySecondPair) &&
                (secondBoundaryFirstPair >= firstBoundarySecondPair && secondBoundaryFirstPair <= secondBoundarySecondPair)){
                    count += 1;
                    continue;
                }
                
            //this checks if the second pair is in the first pair included
            if((firstBoundaryFirstPair <= firstBoundarySecondPair && firstBoundarySecondPair <= secondBoundaryFirstPair) &&
                (firstBoundaryFirstPair <= secondBoundarySecondPair && secondBoundaryFirstPair >= secondBoundarySecondPair)){
                    count += 1;
                    continue;
                }

        }



        return count;
    }

    public static void main(String[] args){

        List<String> inputs = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/Inputs/input_day4.txt");
        System.out.println(getOverlappings(inputs));
    }
}
