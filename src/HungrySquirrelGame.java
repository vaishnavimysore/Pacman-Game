
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Vaishnavi Mysore
 */
public class HungrySquirrelGame {

    //Variable to control the start and end of the game
    static boolean startGame = true;

    public static void main(String args[]) {

        //Input text file
        Maze.create("maze.txt");

        //Initializing the squirrel class and creating it
        Squirrel sq = new Squirrel(0, 0);
        sq.create();

        //Initializing the array of nuts and creating them
        Nut[] nuts = new Nut[Nut.TOTAL_NUTS];
        for (int i = 0; i < Nut.TOTAL_NUTS; i++) {
            nuts[i] = Nut.randomNut();
            nuts[i].create();
        }
        //Initializing the array of poisonous nuts and creating them
        Nut[] poisonNuts = new Nut[Nut.TOTAL_POISONOUS_NUTS];
        for (int i = 0; i < Nut.TOTAL_POISONOUS_NUTS; i++) {
            poisonNuts[i] = Nut.PoisonousNut();
            poisonNuts[i].create();
        }

        //Start of the game loop
        while (startGame) {

            System.out.println("Enter commands u,d,l,r to move Up, Down, Left, and Right:");

            //Displaying the game outline
            Maze.display();

            System.out.println("Enter command:");

            //Reading the user commands for moving the squirrel and passing it to Move() function
            Scanner sc = new Scanner(System.in);
            sq.move(sc.next().charAt(0));

            //Checks if all nuts are collected and increases the points
            for (int i = 0; i < Nut.TOTAL_NUTS; i++) {
                if (nuts[i].row == sq.row) {
                    if (nuts[i].col == sq.col) {

                        //Stores the name of the nut
                        if (nuts[i].symbol == 'A') {
                            //Adding points upon collecting a nut
                            sq.pointsCollected = sq.pointsCollected + Nut.NUTRITION_POINTS;
                            sq.totalNutsEaten++;
                            nuts[i].create();
                            Nut.name = "Almond";
                        } else if (nuts[i].symbol == 'P') {
                            //Adding points upon collecting a nut
                            sq.pointsCollected = sq.pointsCollected + Nut.NUTRITION_POINTS;
                            sq.totalNutsEaten++;
                            nuts[i].create();
                            Nut.name = "Peanut";
                        }

                    }
                }

            }

            //Checks if poisnous nuts are collected and decrease the points
            for (int i = 0; i < Nut.TOTAL_POISONOUS_NUTS; i++) {
                if (poisonNuts[i].row == sq.row) {
                    if (poisonNuts[i].col == sq.col) {

                        if (poisonNuts[i].symbol == 'C') {
                            //Subtract points upon collecting this nut
                            sq.pointsCollected = sq.pointsCollected - Nut.POISONOUS_NUT;
                            poisonNuts[i].create();
                            Nut.name = "Poisonous Cashew";
                        }

                    }
                }

            }

            System.out.println("Squirrel ate " + Nut.name + " and gained " + sq.pointsCollected + "points (Total " + sq.pointsCollected + " )");

            //Checks if all nuts are collected and ends the game if so
            if (sq.totalNutsEaten == Nut.TOTAL_NUTS) {
                System.out.println("Squirrel successfully collected all the nuts. Total points " + sq.pointsCollected);
                System.out.println("Thank you for playing this game!!");
                startGame = false;
                break;
            }

            //Checks if points are in negative and ends the game if so
            if (sq.pointsCollected < 0) {
                System.out.println("Squirrel died !! ");
                System.out.println("GAME OVER!!");
                startGame = false;
                break;
            }

        }
    }

}
