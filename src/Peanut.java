/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vaishnavi Mysore
 */

//Extends the Nut Class
public class Peanut extends Nut{
   
    //Constructor initialization
    public Peanut(int row, int col){
        super('P',row, col);
    }
    
    //Override the create method with current row and col
    @Override
    public void create(){
           put(getRow(), getCol());
    }
      
    
}
