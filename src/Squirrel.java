
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dhruvavemula
 */
public class Squirrel extends Entity implements Movable {

    public int pointsCollected = 0;
    public int totalNutsEaten = 0;
    public int enteredRow = 0, enteredCol = 0;
    int row, col;

    //Constructor initialization
    public Squirrel(int row, int col) {
        super('@', row, col);
    }

    @Override
    public void create() {

        boolean locAvailable = true;
        Scanner scanner = new Scanner(System.in);

        //Checks if location for placing the squirrel is available by taking the user inputs
        while (locAvailable) {

            System.out.println("Enter the Squirrel position (row and column):");

            //Reads the user inputs,formats it and stores it
            String input = scanner.nextLine();
            String[] position = input.split(",");
            try {
                enteredRow = Integer.parseInt(position[0].trim());
                enteredCol = Integer.parseInt(position[1].trim());

                //Storing the current squirrel position to move it
                row = enteredRow;
                col = enteredCol;

                //Checks if the location is available and puts the squirrel in the maze layout
                locAvailable = Maze.available(enteredRow, enteredCol);

                if (locAvailable) {
                    System.out.println("User Input Accepted!");
                    putSquirrel(enteredRow, enteredCol);
                    break;
                } else {
                    locAvailable = true;
                    System.out.println("Invalid entered location!");
                    System.out.println("Position not available. Try again within 20 * 50 !");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Squirrel position out of the 20*50 game size, Enter again!!");
            }
        }

    }

    @Override
    public void move(char direction) {

        //Moves the squirrel up, dowm,left or right based on the user input
        try {
            if (direction == 'u') {
                row--;
            } else if (direction == 'd') {
                row++;
            } else if (direction == 'r') {
                col++;
            } else if (direction == 'l') {
                col--;
            } else {
                //do nothing
            }

            //Puts the squirrel in the updated position
            putSquirrel(row, col);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Squirrel position out of the 20*50 game size!!");
        }
    }

}
