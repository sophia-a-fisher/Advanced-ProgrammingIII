import java.util.*;

public class PrimMaze2
{
   ArrayList<Coord> nextCoords; 
   ArrayList<Coord> neighborCoords;
   
   char[][] maze;
   int mazeRows;
   int mazeCols;
   int numPowerUPs;

   public PrimMaze2()
   {
      
      nextCoords = new ArrayList<Coord>();
      //neighborCoords = new ArrayList<Coord>();
      mazeRows = 15;
      mazeCols = 15;
      numPowerUPs = 5;
      maze = new char[mazeRows][mazeCols];
      
      for(int i = 0; i < mazeRows; i++)
      {
         for(int j = 0; j < mazeCols; j++)
         {maze[i][j] = 'X';}
      }
   }
   
   public static void main(String[] args)
   {
      PrimMaze2 test = new PrimMaze2();
      test.createPath();
      test.placePowerUP();
      test.printMaze(test.maze); 
   }
   
   public void createPath()
   {
      int startRow = 0;
      int startCol = 0;
      int endRow = 0;
      int endCol = 0;
      
      //making sure the start is in an odd numbered col and row
      while(startRow % 2 == 0 || startCol % 2 == 0)
      {
         startRow = (int)(Math.random()*(mazeRows - 2)+1);
         startCol = (int)(Math.random()*(mazeCols - 2)+1);
      }
      
      System.out.println("startRow = " + startRow);
      System.out.println("startCol = " + startCol);
      
      maze[startRow][startCol] = 'O';
      Coord currentCoord = new Coord(startCol,startRow);
      
      if(currentCoord.xCoord + 2 < maze[0].length - 1 && maze[currentCoord.yCoord][currentCoord.xCoord + 2] == 'X')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
      {
         nextCoords.add(new Coord(currentCoord.xCoord + 2,currentCoord.yCoord));
         //System.out.println("adjacent right added"); 
      }
      
      if(currentCoord.xCoord - 2 > 0 && maze[currentCoord.yCoord][currentCoord.xCoord - 2] == 'X')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
      {
         nextCoords.add(new Coord(currentCoord.xCoord - 2,currentCoord.yCoord));
         //System.out.println("adjacent left added"); 
      }
      
      if(currentCoord.yCoord + 2 < maze.length - 1 && maze[currentCoord.yCoord + 2][currentCoord.xCoord] == 'X')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
      {
         nextCoords.add(new Coord(currentCoord.xCoord,currentCoord.yCoord + 2));
         //System.out.println("adjacent down added"); 
      }
      
      if(currentCoord.yCoord - 2 > 0 && maze[currentCoord.yCoord - 2][currentCoord.xCoord] == 'X')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
      {
         nextCoords.add(new Coord(currentCoord.xCoord,currentCoord.yCoord - 2));
         //System.out.println("adjacent up added"); 
      }
      
      while(!nextCoords.isEmpty())
      {
         printMaze(maze);
         int randomNextIndex = 0;
         
         do
         {
            randomNextIndex = (int)(Math.random()*nextCoords.size());
            //System.out.println("randomNextIndex = " + randomNextIndex);
            currentCoord = nextCoords.remove(randomNextIndex);
         }while(!nextCoords.isEmpty() && maze[currentCoord.yCoord][currentCoord.xCoord] == 'O');
                  
         //if(nextCoords.isEmpty())
         //{break;}
         
         maze[currentCoord.yCoord][currentCoord.xCoord] = 'O';
         //nextCoords.remove(0);
         
         ArrayList<Coord> neighborCoords = new ArrayList<Coord>();
         
         if(currentCoord.xCoord + 2 < maze[0].length - 1 && maze[currentCoord.yCoord][currentCoord.xCoord + 2] == 'O')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
         {
            neighborCoords.add(new Coord(currentCoord.xCoord + 2,currentCoord.yCoord));
            //System.out.println("adjacent right added"); 
         }
         
         if(currentCoord.xCoord - 2 > 0 && maze[currentCoord.yCoord][currentCoord.xCoord - 2] == 'O')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
         {
            neighborCoords.add(new Coord(currentCoord.xCoord - 2,currentCoord.yCoord));
            //System.out.println("adjacent left added"); 
         }
         
         if(currentCoord.yCoord + 2 < maze.length - 1 && maze[currentCoord.yCoord + 2][currentCoord.xCoord] == 'O')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
         {
            neighborCoords.add(new Coord(currentCoord.xCoord,currentCoord.yCoord + 2));
            //System.out.println("adjacent down added"); 
         }
         
         if(currentCoord.yCoord - 2 > 0 && maze[currentCoord.yCoord - 2][currentCoord.xCoord] == 'O')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
         {
            neighborCoords.add(new Coord(currentCoord.xCoord,currentCoord.yCoord - 2));
            //System.out.println("adjacent up added"); 
         }
         
         int randomNeighborIndex = (int)(Math.random()*neighborCoords.size());
         //System.out.println("randomNextIndex = " + randomNextIndex);
         Coord neighborCoord = neighborCoords.get(randomNeighborIndex);
         
         
         //right
         if(currentCoord.xCoord + 2 < (maze[0].length - 1)  && currentCoord.xCoord + 2 == neighborCoord.xCoord)
         {
            maze[currentCoord.yCoord][currentCoord.xCoord + 1] = 'O';
         }
         
         //left
         if(currentCoord.xCoord - 2 > 0 && currentCoord.xCoord - 2 == neighborCoord.xCoord)
         {
            maze[currentCoord.yCoord][currentCoord.xCoord - 1] = 'O';
         }
         
         //down
         if(currentCoord.yCoord + 2 < maze.length -1 && currentCoord.yCoord + 2 == neighborCoord.yCoord)
         {
            maze[currentCoord.yCoord + 1][currentCoord.xCoord] = 'O';
         }
         
         //up
         if(currentCoord.yCoord - 2 > 0 && currentCoord.yCoord - 2 == neighborCoord.yCoord)
         {
            maze[currentCoord.yCoord - 1][currentCoord.xCoord] = 'O';
         }
         
         
         if(currentCoord.xCoord + 2 < maze[0].length - 1 && maze[currentCoord.yCoord][currentCoord.xCoord + 2] == 'X')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
         {
            nextCoords.add(new Coord(currentCoord.xCoord + 2,currentCoord.yCoord));
            //System.out.println("adjacent right added"); 
         }
         
         if(currentCoord.xCoord - 2 > 0 && maze[currentCoord.yCoord][currentCoord.xCoord - 2] == 'X')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
         {
            nextCoords.add(new Coord(currentCoord.xCoord - 2,currentCoord.yCoord));
            //System.out.println("adjacent left added"); 
         }
         
         if(currentCoord.yCoord + 2 < maze.length - 1 && maze[currentCoord.yCoord + 2][currentCoord.xCoord] == 'X')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
         {
            nextCoords.add(new Coord(currentCoord.xCoord,currentCoord.yCoord + 2));
            //System.out.println("adjacent down added"); 
         }
         
         if(currentCoord.yCoord - 2 > 0 && maze[currentCoord.yCoord - 2][currentCoord.xCoord] == 'X')// && maze[currentCoord.xCoord + 2][currentCoord.yCoord] != 'O')
         {
            nextCoords.add(new Coord(currentCoord.xCoord,currentCoord.yCoord - 2));
            //System.out.println("adjacent up added"); 
         }

         //nextCoords.remove(currentCoord); 
      }
      
      do
      {
         startCol = (int)(Math.random()*maze[0].length);
         endCol = (int)(Math.random()*maze[0].length);
         
      }while(maze[1][startCol] != 'O' || maze[maze.length-2][endCol] != 'O');
      
      maze[0][startCol] = 'O';
      maze[maze.length-1][endCol] = 'O';

   }
   
   public void placePowerUP()
   {
      int powerUpCounter = 0;
      int randomRow;
      int randomCol;
      
      while(powerUpCounter<numPowerUPs)
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