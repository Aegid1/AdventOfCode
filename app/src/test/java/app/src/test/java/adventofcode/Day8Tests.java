package app.src.test.java.adventofcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import adventofcode.Day1.Day1;
import adventofcode.Day7.Node;
import adventofcode.Day8.Day8;

public class Day8Tests {
    
    @Test
    @DisplayName("checks if all visible trees are horizontally considered")
    void testHorizontally(){

        List<String> inputs = List.of("9807", 
                                      "190");

        List<String> result = Day8.getVisibleTreesHorizontally(inputs);

        assertEquals(5, result.size());
    }

    @Test
    @DisplayName("checks if all visible trees are horizontally considered")
    void testHorizontally2(){

        List<String> inputs = List.of("30373", 
                                      "25512",
                                      "65332",
                                      "33549",
                                      "35390");

        List<String> result = Day8.getVisibleTreesHorizontally(inputs);

        assertEquals(3 + 4 + 4 + 3 + 4, result.size());
    }
    @Test
    @DisplayName("checks if all visible trees are vertically considered")
    void testVertically(){

        List<String> inputs = List.of("980", 
                                      "190", 
                                      "928");

        List<String> result = Day8.getVisibleTreesVertically(inputs);

        assertEquals(7, result.size());
    } 

    @Test
    @DisplayName("checks if all visible trees are horizontally considered")
    void testVertically2(){

        List<String> inputs = List.of("3", "2", "6", "3", "3");

        List<String> result = Day8.getVisibleTreesVertically(inputs);

        assertEquals(3 , result.size());
    }
    @Test
    @DisplayName("checks if some trees are considered vertically and horizontally")
    void testUniqueTrees(){

        List<String> horizontalTrees = List.of("00", "01", "02");
        List<String> verticalTrees = List.of("00", "34", "02");

        int result = Day8.getTotalNumberOfVisibleTrees(horizontalTrees, verticalTrees);

        assertEquals(4, result);
    }

    @Test
    @DisplayName("checks if some trees are considered vertically and horizontally")
    void testUniqueTrees2(){

        List<String> horizontalTrees = List.of("30373", 
                                               "25512",
                                               "65332",
                                               "33549",
                                               "35390");

        List<String> verticalTrees = List.of("30373", 
                                             "25512",
                                             "65332",
                                             "33549",
                                             "35390");

        int result = Day8.getTotalNumberOfVisibleTrees(Day8.getVisibleTreesHorizontally(horizontalTrees), Day8.getVisibleTreesVertically(verticalTrees));

        assertEquals(21, result);
    }
}
