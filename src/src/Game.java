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
public class Game 
{
    private boolean game = true;
    private Human h1;
    private Human h2;
    private AI ai;
    private int counter = 0;
    Scanner s = new Scanner(System.in);
    int humanCount = 1;
    int aiCount = 0;
    Board mainBoard = new Board();
    
    public Game()
    {
        setAI();
        setHuman();
        
    }
    public void setAI()
    {
        System.out.print("Would you like to play against the computer? (y/n): ");
        String choice = s.nextLine();
        if(choice.equals("y"))
        {
            aiCount = 1;
            ai = new AI();
        }
        
        
    }
    public void setHuman()
    {
        while(humanCount < 3)
        {
            String name;
            String piece;

            
            if(humanCount == 1)
            {
                System.out.print("Enter the name of player " + humanCount + ": ");
                name = s.nextLine();


                System.out.print("Enter the piece of player " + humanCount + ": ");
                piece = s.nextLine();
                h1 = new Human(name,piece);
            }
            
            else if(humanCount == 2 && aiCount != 1)
            {
                System.out.print("Enter the name of player " + humanCount + ": ");
                name = s.nextLine();


                System.out.print("Enter the piece of player " + humanCount + ": ");
                piece = s.nextLine();
                h2 = new Human(name,piece);
            }
            
            humanCount++;
        }   
    }
    
    public void Start()
    {
        int location;
        printBoard();
        boolean gameEnd = false;
        
        
        while(!gameEnd)
        {
            if(h1.isTurn())
            {
                System.out.print(h1.getName() + ", enter a location to put your piece in: ");

                location = s.nextInt();

                h1.move(location, mainBoard, h1.getColor());
                gameEnd = mainBoard.checkWin(h1);
                if(gameEnd == true)
                {
                    h1.setWin(true);
                }
                printBoard();
                h1.setTurn(false);
                if(aiCount == 0)
                {
                    h2.setTurn(true);
                }
            }
            else if(!h1.isTurn())
            {
                if(humanCount == 3 && aiCount != 1)
                {
                    System.out.print(h2.getName() + ", enter a location to put your piece in: ");

                    location = s.nextInt();

                    h2.move(location, mainBoard, h2.getColor());
                    gameEnd = mainBoard.checkWin(h2);
                    if(gameEnd == true)
                    {
                        h2.setWin(true);
                    }
                    printBoard();
                    h2.setTurn(false);
                    h1.setTurn(true);
                }
                else
                {
                    int aiPlace = ai.calCulatePlace();
                    ai.move(aiPlace, mainBoard, ai.getColor());
                    gameEnd = mainBoard.checkWin(ai);
                    {
                        ai.setWin(true);
                    }
                    printBoard();
                    h1.setTurn(true);
                }
            }
        }
        
        end();
    }
    
    public void end()
    {
        if(h1.getWin() == true)
        {
            System.out.println("Congratulations!! " + h1.getName() + ", you won!!");
        }
        else if(h2.getWin() == true)
        {
            System.out.println("Congratulations!! " + h2.getName() + ", you won!!");
        }
        else if(ai.getWin() == true)
        {
            System.out.println("Congratulations!! " + ai.getName() + ", you won!!");
        }
    }
    
    public void printBoard()
    {
        System.out.println(mainBoard);
    }
}
