
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vaishnavi mysore
 */
public class Maze {

    public static final int MAX_MAZE_ROW = 20;
    public static final int MAX_MAZE_COL = 50;
    public static char symbol;
    static Entity maze[][];

    //Creates the maze array and its contents
    public static void create(String filename) {

        try {

            //Creating the entity object
            maze = new Entity[MAX_MAZE_ROW][MAX_MAZE_COL];

            //Reading the input maze file
            Scanner mazeFile = new Scanner(new FileReader(filename));

            //Reads the file and puts it in the maze array
            while (mazeFile.hasNextLine()) {
                for (int i = 0; i < maze.length; i++) {
                    
                    //Reading line by line
                    String line = mazeFile.nextLine().trim();
                    
                    for (int j = 0; j < line.length(); j++) {
                        
                        //Reading character by character
                        symbol = line.charAt(j);
                        
                        //Updates the content based on the file
                        if (symbol == '*') {
                            maze[i][j] = new Wall(i, j);
                            maze[i][j].create();

                        } else {
                            maze[i][j] = null;
                        }
                    }
                }
            }
            
            //Closes the maze file after reading
            mazeFile.close();
            
        } catch (FileNotFoundException ex) {

            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Displays the array contents
    public static void display() {
        for (int row = 0; row < MAX_MAZE_ROW; row++) {
            for (int col = 0; col < MAX_MAZE_COL; col++) {
                Entity entity = maze[row][col];

                if (entity != null) {
                    System.out.print(maze[row][col].symbol);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    //Checks if the position in the layout is available and returns true or false
    public static boolean available(int row, int col) {
        boolean isAvailable = false;
        if (row < 0 || row >= MAX_MAZE_ROW || col < 0 || col >= MAX_MAZE_COL) {
            isAvailable =  false;
        }
        else if(maze[row][col] == null) {
            isAvailable =  true;
        }
        return isAvailable;
    }

}
