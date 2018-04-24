/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Random;

/**
 *
 * @author Oscar
 */
public class AI implements PlayerInterface
{
    private String name = "Bot";
    private String color = "O";
    private boolean win = false;
    
    public AI()
    {
        
    }

    public int calCulatePlace()
    {
        Random rand = new Random();
        int  n = rand.nextInt(7);
        return n;
    }
    
    @Override
    public Board move(int i, Board b, String s) {
        int row = 5;
        int col = i;
       
        System.out.println(b.getBoard()[1][col]);
        
        
        boolean placed = b.setBoard(row,col, b, s);
        
        while(placed == false)
        {
            col = calCulatePlace();
            placed = b.setBoard(row, col, b, s);
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

    public boolean getWin()
    {
        return win;
    }
    
    public void setWin(boolean win)
    {
        this.win = win;
    }
}
