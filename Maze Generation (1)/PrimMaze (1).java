import java.util.*;

public class PrimMaze
{
   //ArrayList<Coord> pathCoords;
   ArrayList<Coord> nextCoords; 
   ArrayList<Coord> innerCoords;
   //ArrayList<Coord> neighborCoords;
   char[][] maze;
   int mazeRows;
   int mazeCols;

   public PrimMaze()
   {
      //pathCoords = new ArrayList<Coord>();
      nextCoords = new ArrayList<Coord>();
      innerCoords = new ArrayList<Coord>();
      //neighborCoords = new ArrayList<Coord>();
      mazeRows = 15;
      mazeCols = 13;
      maze = new char[mazeRows][mazeCols];
      
      for(int i = 0; i < mazeRows; i++)
      {
         for(int j = 0; j < mazeCols; j++)
         {maze[i][j] = 'X';}
      }
   }

   public static void main(String[] args)
   {
      PrimMaze test = new PrimMaze();
      test.createPath();
      test.placePowerUP();
      test.printMaze(test.maze);
   }
   
   public void createPath()
   {
      //generating a starting coordinate inside maze edges
      int startRow = (int)(Math.random()*(mazeRows - 2)+1);
      int startCol = (int)(Math.random()*(mazeCols - 2)+1);
      Coord startCoord = new Coord(startCol,startRow);
      Coord innerCoord;
      Coord currentCoord = startCoord;
      
      System.out.println("startRow = " + startRow);
      System.out.println("startCol = " + startCol);
      
      int randomNextIndex;
      
      do
      {
         //checking adjacent right
         innerCoords = new ArrayList<Coord>();
         //neighborCoords = new ArrayList<Coord>();
         if(currentCoord.xCoord + 2 < maze[0].length - 1 && maze[currentCoord.yCoord][currentCoord.xCoord + 2] == 'X')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
         {
               nextCoords.add(new Coord(currentCoord.xCoord + 2,currentCoord.yCoord));
               //System.out.println("adjacent right added");
            
         }
         
         //checking adjacent left
         if(currentCoord.xCoord - 2 > 0 && maze[currentCoord.yCoord][currentCoord.xCoord - 2] == 'X') //&& maze[currentCoord.xCoord - 2][currentCoord.yCoord] != 'O'
         {
            nextCoords.add(new Coord(currentCoord.xCoord - 2,currentCoord.yCoord));
            //System.out.println("adjacent left added");
         }
         
         //checking adjacent up
         if(currentCoord.yCoord - 2 > 0 && maze[currentCoord.yCoord - 2][currentCoord.xCoord] == 'X') //&& maze[currentCoord.xCoord][currentCoord.yCoord - 2] != 'O')
         {
            nextCoords.add(new Coord(currentCoord.xCoord,currentCoord.yCoord - 2));
            //System.out.println("adjacent up added");
         }
         
         //checking adjacent down
         if(currentCoord.yCoord + 2 < maze.length - 1 && maze[currentCoord.yCoord + 2][currentCoord.xCoord] == 'X') //&& maze[currentCoord.xCoord][currentCoord.yCoord + 2] != 'O')
         {
            nextCoords.add(new Coord(currentCoord.xCoord,currentCoord.yCoord + 2));
            //System.out.println("adjacent down added");
         } 
         
         //pathCoords.add(currentCoord);
         maze[currentCoord.yCoord][currentCoord.xCoord] = 'O';
         
         /*for(Coord element : nextCoords)
         {
            if()
            {
         
            }
         }
         */
         
        /*else
         {
            

         }*/
         
         randomNextIndex = (int)(Math.random()*nextCoords.size());
         //System.out.println("randomNextIndex = " + randomNextIndex);
         currentCoord = nextCoords.remove(randomNextIndex);
               
         if(currentCoord.xCoord + 2 < maze[0].length - 1) //&& maze[currentCoord.yCoord][currentCoord.xCoord + 2] == 'O')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
         {
               innerCoords.add(new Coord(currentCoord.xCoord + 1,currentCoord.yCoord));
               //System.out.println("adjacent right added");
            
         }
         
         //checking adjacent left
         if(currentCoord.xCoord - 2 > 0 )//&& maze[currentCoord.yCoord][currentCoord.xCoord - 2] == 'O') //&& maze[currentCoord.xCoord - 2][currentCoord.yCoord] != 'O'
         {
            innerCoords.add(new Coord(currentCoord.xCoord - 1,currentCoord.yCoord));
            //System.out.println("adjacent left added");
         }
         
         //checking adjacent up
         if(currentCoord.yCoord - 2 > 0) //&& maze[currentCoord.yCoord - 2][currentCoord.xCoord] == 'O') //&& maze[currentCoord.xCoord][currentCoord.yCoord - 2] != 'O')
         {
            innerCoords.add(new Coord(currentCoord.xCoord,currentCoord.yCoord - 1));
            //System.out.println("adjacent up added");
         }
         
         //checking adjacent down
         if(currentCoord.yCoord + 2 < maze.length - 1 )//&& maze[currentCoord.yCoord + 2][currentCoord.xCoord] == 'O') //&& maze[currentCoord.xCoord][currentCoord.yCoord + 2] != 'O')
         {
            innerCoords.add(new Coord(currentCoord.xCoord,currentCoord.yCoord + 1));
            //System.out.println("adjacent down added");
         } 
                  
         randomNextIndex = (int)(Math.random()*innerCoords.size());
         innerCoord = innerCoords.remove(randomNextIndex);
         maze[innerCoord.yCoord][innerCoord.xCoord] = 'O';
         //innerCoord = null;
         
         //printMaze(maze);
         
      }while(!nextCoords.isEmpty());
      
      boolean startMade = false;
      do
      {
         int randomStart = (int)(Math.random()*mazeCols);
         if(maze[maze.length-3][randomStart] == 'O')
         {
            maze[maze.length-1][randomStart] = 'O';
            maze[maze.length-2][randomStart] = 'O';
            startMade = true;
         }  
      }while(!startMade);
      
      boolean endMade = false;
      do
      {
         int randomStart = (int)(Math.random()*mazeCols);
         if(maze[maze.length-3][randomStart] == 'O')
         {
            maze[0][randomStart] = 'O';
            maze[1][randomStart] = 'O';
            endMade = true;
         }  
      }while(!endMade);
      
   }
   
   public void placePowerUP()
   {
      int powerUpCounter = 0;
      int randomRow;
      int randomCol;
      
      while(powerUpCounter<5)
      {
         randomRow = (int)(Math.random()*(mazeRows));
         randomCol = (int)(Math.random()*(mazeCols));
         if(maze[randomRow][randomCol] == 'O')
         {
            maze[randomRow][randomCol] = 'P';
            powerUpCounter++;
         }
      }
   }
   
   public void printMaze(char[][] maze)
   {
      for(int i = 0; i < maze.length;i++)
      {
         System.out.print("\t\t\t\t ");
         for(int j = 0; j < maze[i].length; j++)
         {
            System.out.print(maze[i][j]);
            if(!(j==maze[i].length-1))
            {System.out.print(", ");}
         }
         System.out.print("\n");
      }
      System.out.print("\n");
   }
}