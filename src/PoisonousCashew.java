/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vaishnavi Mysore
 */
public class PoisonousCashew extends Nut {
    
    public PoisonousCashew(int row,int col){
        super('C',row,col);
    }
    
    @Override
    public void create(){
           put(getRow(), getCol());
    }
    
}
