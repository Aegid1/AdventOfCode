package app.src.test.java.adventofcode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import adventofcode.Day1.Day1;
import adventofcode.Day7.Day7;
import adventofcode.Day7.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7Tests {
    
    @Test
    @DisplayName("checks if the tree is builded correctly")
    void testFileTree(){

        List<String> inputs = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/app/src/test/resources/input_day7tests.txt");
        Node<String> tree = Day7.makeTree(inputs);

        assertEquals(9, tree.getChildren().size(),  "your tree didnt make enough leaf nodes");
        assertEquals(4, tree.getFiles().size(), "your tree didnt recognize all files");
    }

    
    @Test
    @DisplayName("checks if changing directory with 'cd' works")
    void testFileTreeChangeDirectory(){

        List<String> inputs = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/app/src/test/resources/input_day7tests.txt");
        Node<String> tree = Day7.makeTree(inputs);
        assertEquals(9, tree.getChildren().size());
    }

    @Test
    @DisplayName("checks if all files are correctly added")
    void testFileTreeGetFileSum(){

        List<String> inputs = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/app/src/test/resources/input_day7tests.txt");
        Node<String> tree = Day7.makeTree(inputs);
        int sum = 0;

        for(String file : tree.getFiles().keySet()){ sum += tree.getFiles().get(file); }
        assertEquals(843566, sum);

    }

    
}


