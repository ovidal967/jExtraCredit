/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Scanner;

/**
 *
 * @author Oscar
 */
public class Human implements PlayerInterface
{
    private String name;
    private String color;//Can only be X or O for testing purposes
    private boolean turn = true;
    private boolean win = false;
    
    public Human(String name, String color)
    {
        this.name = name;
        this.color = color;
    }

    @Override
    public Board move(int i, Board b, String s) 
    {
        int row = 5;
        int col = i-1;
        
        
        
        boolean placed = b.setBoard(row,col, b, s);
        
        while(placed == false)
        {
            System.out.print("Invalid entry please select another spot!: ");
            Scanner sc = new Scanner(System.in);
            col = sc.nextInt()-1;
            
            placed = b.setBoard(row,col, b, s);
        }
        
        return b;
    }
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the turn
     */
    public boolean isTurn() {
        return turn;
    }

    /**
     * @param turn the turn to set
     */
    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    
    public boolean getWin()
    {
        return win;
    }
    public void setWin(boolean win)
    {
        this.win = win;
    }

}
