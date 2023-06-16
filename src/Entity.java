/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vaishnavi Mysore
 */
public abstract class Entity {

    public char symbol;
    public int row;
    public int col;

    //Abstract create method
    abstract public void create();

    //Constructor initialization
    public Entity(char symbol, int row, int col) {
        this.symbol = symbol;
        this.row = row;
        this.col = col;
    }

    //Functions to get row, col and symbol
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    //Function to put the symbol at the current row and col in the maze layout
    public void put(int newRow, int newCol) {

        Maze.maze[newRow][newCol] = this;
    }

    //Function to put the squirrel at the current row and col in the maze layout
    public Entity putSquirrel(int newRow, int newCol) {
        Entity replacedEntity = Maze.maze[newRow][newCol];
        Maze.maze[newRow][newCol] = this;
        Maze.maze[row][col] = null;
        row = newRow;
        col = newCol;
        return replacedEntity;
    }
}
