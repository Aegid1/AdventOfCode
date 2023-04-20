package adventofcode.Day7;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.sound.sampled.Line;
import javax.swing.tree.TreeNode;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import adventofcode.Day1.Day1;


public class Day7 {

    /*
     * Builds a "tree-structure" refering to the commands in the input.
     * The tree-structure resembles a file-structure.
     * 
     * @param input -> list of inputs
     * 
     * @return the root-node/outermost directory consisting of the subnodes/subdirectories
     */
    public static Node<String> makeTree (List<String> input){

        //List<Node<String>> directories = new ArrayList<>();
        Node<String> rootNode = new Node<>("/");
        Node<String> currentNode = rootNode;

        for(String line : input){

            //handles the case for making a new directory
            if(line.substring(0, 3).equals("dir")){

                int lastSpace = line.lastIndexOf(" ");
                String directory = line.substring(lastSpace + 1, line.length());

                currentNode.addChild(new Node<String>(currentNode, directory));
                continue;
            }

            //handles the cases for changing the directory
            if(line.contains("cd") && line.contains("$")){

                if(line.contains("/")){
                    currentNode = rootNode;
                    continue;
                }
                if(line.contains("..")){
                    currentNode = currentNode.getParent();
                    continue;
                }
                int lastSpace = line.lastIndexOf(" ");
                String directory = line.substring(lastSpace +1, line.length());

                for(int i = 0; i < currentNode.getChildren().size(); i++){

                    if(currentNode.getChildren().get(i).getName().equals(directory)){

                        currentNode = currentNode.getChildren().get(i);
                    }
                }

            }

            //handles the case for listing all files/directories in current directory
            if(line.contains("ls") && line.contains("$")){
                continue;
            }

            //checks the case if the command has to do with a file
            try{

                if(Integer.parseInt(String.valueOf(line.charAt(0))) >= 0){

                    int lastSpace = line.lastIndexOf(" ");
                    String fileName = line.substring(lastSpace +1, line.length());
                    int fileSize = Integer.parseInt(line.substring(0, lastSpace));

                    currentNode.addFile(fileName, fileSize);
                }

            }catch(NumberFormatException exception){ continue; }
        }

        return rootNode;
    }


    /*
     * Uses the BFS-Algorithm inside another, outer BFS-Algorithm to search for every file in every directory
     * 
     * @param directory -> is the outermost directory of the file-structure consisting of the subdirectories
     * 
     * @return a map consisting of hashvalues of the directories linked to the summed up filesize values
     */
    public static Map<Integer, Integer> fileSizeSumWithBFS(Node<String> directory){

        Queue<Node<String>> queue = new ArrayDeque<>();
        Queue<Node<String>> outerQueue = new ArrayDeque<>();
        Map<Integer, Integer> directoriesWithFileSizes = new HashMap<>();
        outerQueue.add(directory);

        while(!outerQueue.isEmpty()){

            Node<String> outerNode = outerQueue.remove();
            int fileSizeSum = 0;

            queue.add(outerNode);

            while(!queue.isEmpty()){

                Node<String> node = queue.remove();

                for(Map.Entry<String, Integer> file : node.getFiles().entrySet()){
                    fileSizeSum += file.getValue();
                }

                if(node.getChildren().size() <= 0){ continue; }
        
                for(Node<String> child : node.getChildren()){ queue.add(child); } 
            }

            directoriesWithFileSizes.put(outerNode.hashCode(), fileSizeSum);
        
            if(outerNode.getChildren().size() <= 0){ continue; }
        
            for(Node<String> child : outerNode.getChildren()){ outerQueue.add(child); } 

            }
        
        return directoriesWithFileSizes;
    }

    /*
     * Uses the DFS-Algorithm to search recursively for a specific directory through the file-structure by the name of the directory
     * 
     * @param outerMostDirectory -> is the file-structure that gets searched through
     * @param exploredDirectories -> is the list consisting of all directories explored by the function
     * @param wantedDirectory -> is the directory that is searched with the function
     * 
     * @return the node/directory that is searched for 
     */
    public static Node<String> searchDirectoryWithDFS(Node<String> outerMostDirectory, List<Node<String>> exploredDirectories, String wantedDirectory){

        if(outerMostDirectory.getName() != wantedDirectory){

            //checks if the node is an end-node
            if(outerMostDirectory.getChildren().size() <= 0){

                exploredDirectories.add(outerMostDirectory);
                searchDirectoryWithDFS(outerMostDirectory.getParent(), exploredDirectories, wantedDirectory);

            }

            for(Node<String> child : outerMostDirectory.getChildren()){

                if(!exploredDirectories.contains(child)){ searchDirectoryWithDFS(child, exploredDirectories, wantedDirectory); }
            
            }

            //if all children of the node are already in explored, it goes one level upwards
            exploredDirectories.add(outerMostDirectory);
            searchDirectoryWithDFS(outerMostDirectory.getParent(), exploredDirectories, wantedDirectory);  
            
        }

        return outerMostDirectory;

    }

    public static void main(String[] args){
        
    //PART ONE
        List<String> input = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/app/src/main/resources/Inputs/input_day7.txt");

        Node<String> tree = makeTree(input);
        Map<Integer, Integer> resultMap = fileSizeSumWithBFS(tree);
        int result = 0;

        for(Integer element : resultMap.keySet()){

            if(resultMap.get(element) <= 100000){ result += resultMap.get(element); }
        }

        System.out.println(result);
        

    //PART TWO
        List<Integer> directoriesWithNeededSpace = new ArrayList<>();
        int neededFreeSpace = 30000000;
        int totalSpaceAvailable = 70000000;
        int usedSpace = Collections.max(resultMap.entrySet(), Map.Entry.comparingByValue()).getValue();
        int spaceToFree = neededFreeSpace - (totalSpaceAvailable - usedSpace);

        for(Integer element : resultMap.keySet()){

            if(resultMap.get(element) >= spaceToFree){ directoriesWithNeededSpace.add(resultMap.get(element)); }

        }

        int minimum = Collections.min(directoriesWithNeededSpace);
        System.out.println(minimum);
    }

}
