
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dhruvavemula
 */
public abstract class Nut extends Entity {
    
    public static final int TOTAL_NUTS = 10;
    public static final int NUTRITION_POINTS = 5;
    public static final int POISONOUS_NUT = 15;
    public static final int TOTAL_POISONOUS_NUTS = 5;
    public static Random rdm = new Random();
    public static String name;

    //Constructor initialization
    public Nut(char symbol, int row, int col) {
        super(symbol, row, col);
    }

    //Creating a random nut either Almond or Peanut and returns the object
    public static Nut randomNut() {
        
        int randomRow, randomCol;
        Nut randomNut;
        
        //Creates random row and col numbers and checks if its available
        do {
            randomRow = rdm.nextInt(Maze.MAX_MAZE_ROW);
            randomCol = rdm.nextInt(Maze.MAX_MAZE_COL);
        } while (!Maze.available(randomRow, randomCol));

        //Randomly creates Almond or Peanut
        if (rdm.nextBoolean()) {
            randomNut = new Almond(randomRow, randomCol);
        } else {
            randomNut = new Peanut(randomRow, randomCol);
        }

        return randomNut;
    }
    
    //Creating a Poisonous nut returns the object
        public static Nut PoisonousNut() {
        
        int randomRow, randomCol;
        Nut randomNut;
        
        //Creates random row and col numbers and checks if its available
        do {
            randomRow = rdm.nextInt(Maze.MAX_MAZE_ROW);
            randomCol = rdm.nextInt(Maze.MAX_MAZE_COL);
        } while (!Maze.available(randomRow, randomCol));

        randomNut = new PoisonousCashew(randomRow, randomCol);


        return randomNut;
    }

}
