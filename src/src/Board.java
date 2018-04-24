/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Oscar
 */
public class Board 
{
    private String[][] board;
    private boolean[][] visited = new boolean[7][6];
    private boolean win = false;
    
    public Board()
    {
        board = new String[7][7];
        for(int row = 0; row < board.length-1; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    /**
     * @return the board
     */
    public String[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public boolean setBoard(int row, int col, Board b, String s) {
        boolean placed = false;
        while(!placed)
            {
                if(board[0][col] != " ")
                {
                    return false;
                }
                if(board[row][col] == " ")
                {
                    board[row][col] = s;
                    placed = true;
                    return true;
                }
                else
                    row -= 1;
            }
        return false;
    }
    
    public boolean checkWin(Human h)
    {
        int counter = 0;
        //checkWinRow(counter, h);
        //checkWinCol(counter, h);
        checkWinDiag(counter, h);
        return win;
    }
    
    public void checkWinDiag(int counter, Human h)
    {
        checkWinLeft(counter, h);
        checkWinRight(counter, h);
    }
    
    public void checkWinLeft(int counter, Human h)
    {
        
        int row = 5;
        int col = 3;
        int colUp;

        while(row >= 3)
        {
            while(col <= 6)
            {
                for(int r = 5; r >= 0; r--)
                {
                    colUp = col;
                    System.out.println("row: " + r + " colUp: " + colUp + " " + board[r][colUp]);
                    if(board[r][colUp].equals(h.getColor()))
                    {
                        counter++; 
                        System.out.println("Counter: " + counter);
                    }
                    if(counter == 4)
                    {
                        win = true;
                    }
                    

                    if(colUp > 0)
                        colUp--;
                }
                
                col++;
                System.out.println("Col: " + col);
            }
            row--;
        }
    }
    public void checkWinRight(int counter, Human h)
    {
        
    }
    public void checkWinCol(int counter, Human h)
    {
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                if(board[col][row] == h.getColor())//Checks col win
                {
                    counter++;
                }
                if(counter == 4)
                {
                    win = true;
                }
            }
            counter = 0;
        }
    }
    
    public void checkWinRow(int counter, Human h)
    {
        int row = 5;
        
        while(row >= 0)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                if(board[row][col] == h.getColor())
                {
                    counter++;
                }
                if(counter == 4)
                {
                    win = true;
                }
            }
            counter = 0;
            row--;
        }             
    }
    
    public boolean checkWin(AI h)
    {
        boolean win = false;
        int counter = 0;
        
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                if(board[col][row] == h.getColor())//Checks col win
                {
                    counter++;
                }
                if(counter == 4)
                {
                    win = true;
                }
            }
            counter = 0;
        }
        
        return win;
    }
    
    @Override
    public String toString()
    {
        String str = "|1|2|3|4|5|6|7|\n";
        for(int row = 0; row < board.length-1; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                str = str+ "|" + board[row][col];
            }
            str = str + "|\n";
        }
        return str;
    }
}
