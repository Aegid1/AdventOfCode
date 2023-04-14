import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;
import javax.swing.tree.TreeNode;

import Day1.Day1;

public class Day7 {

    public static Node<String> makeTree (List<String> input){

        //List<Node<String>> directories = new ArrayList<>();
        Node<String> rootNode = new Node<>();
        Node<String> currentNode = rootNode;

        for(String line : input){

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
                String directory = line.substring(lastSpace, line.length());

                for(int i = 0; i < currentNode.getChildren().size(); i++){

                    if(currentNode.getChildren().get(i).getName() == directory){

                        currentNode = currentNode.getChildren().get(i);
                    }
                }

            }

            //handles the case for listing all files/directories in current directory
            if(line.contains("ls") && line.contains("$")){
                continue;
            }

            //handles the case for making a new directory
            if(line.substring(0, 3) == "dir"){

                int lastSpace = line.lastIndexOf(" ");
                String directory = line.substring(lastSpace, line.length());

                currentNode.addChild(new Node<String>(currentNode, directory));
            }

            //checks the case if the command has to do with a file
            try{

                if(Integer.parseInt(input.get(0)) >= 0){

                    int lastSpace = line.lastIndexOf(" ");
                    String fileName = line.substring(lastSpace, line.length());
                    int fileSize = Integer.parseInt(fileName.substring(0, lastSpace));
                    
                    currentNode.addFile(fileName, fileSize);
                }

            }catch(NumberFormatException exception){ continue;}
        }

        return rootNode;
    }


    public static void main(String[] args){

    }

}
