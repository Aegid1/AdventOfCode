package adventofcode.Day7;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.sound.sampled.Line;
import javax.swing.tree.TreeNode;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import adventofcode.Day1.Day1;


public class Day7 {

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

    public static Node<String> searchDirectoryWithDFS(Node<String> node, List<Node<String>> explored, String directory){

        if(node.getName() != directory){

            //checks if the node is an end-node
            if(node.getChildren().size() <= 0){

                explored.add(node);
                searchDirectoryWithDFS(node.getParent(), explored, directory);

            }

            for(Node<String> child : node.getChildren()){

                if(!explored.contains(child)){ searchDirectoryWithDFS(child, explored, directory); }
            
            }

            //if all children of the node are already in explored, it goes one level upwards
            explored.add(node);
            searchDirectoryWithDFS(node.getParent(), explored, directory);  
            
        }

        return node;

    }

    public static void main(String[] args){
    
        List<String> input = Day1.readFileInList("/home/aegidiushaslauer/Dailies/AdventOfCode/app/src/main/resources/Inputs/input_day7.txt");

        Node<String> tree = makeTree(input);
        Map<Integer, Integer> resultMap = fileSizeSumWithBFS(tree);
        int result = 0;

        for(Integer element : resultMap.keySet()){

            if(resultMap.get(element) <= 100000){ 
            
                result += resultMap.get(element);
            }
        }
        System.out.println(result);
    }

}