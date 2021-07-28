// Lab29ast.java
// This is the student version of the Lab29a assignment.
// Completing this file, as is, is the 100 point version.  
// For 80 points you will be given the <getMove> code.


import java.util.*;


public class Lab29ast
{
	public static void main(String args[]) 
	{
		System.out.println("\nLab 29a 80/100 Point Version\n");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter random starting seed  ===>>  ");
		int seed = input.nextInt();
		
		Maze maze = new Maze(seed);
		maze.displayMaze();
		maze.solveMaze(); //work on this
		maze.displayMaze();
		maze.mazeSolution(); //work?
	}
}


class Maze
{
	
	private char mat[][];			// 2d character array that stores the maze display
	private Coord currentMove;		// object that stores current maze position
	private Stack visitStack;		// stack that stores location that have been visited
                 
                               
	class Coord
	// Coord is a class that stores a single maze location.  
	{
		private int rPos;
		private int cPos;
		public Coord (int r, int c) 		{ rPos = r; cPos = c; }
		public boolean isFree() 			{ return (rPos == 0 && cPos == 0); }
		public void setPos(int r, int c) 	{ rPos+= r; cPos+= c; }
      public int getRPos()       {return rPos; }
      public int getCPos()       {return cPos; }
	}
	
	  
	public Maze(int seed)
	// constructor which generates the random maze, random starting location
	// and initializes Maze class values.  If the random value equals 0 the maze
	// store an 'X' otherwise it store an 'O' in the maze.
	{
		Random random = new Random(seed);
		int startRow, startCol;
		mat = new char[12][12]; 
		for (int r = 0; r < 12; r++)
			for (int c = 0; c < 12; c++)
			{
				if (r == 0 || c == 0 || r == 11 || c == 11)
					mat[r][c] = 'X';
				else
				{
					int rndInt = random.nextInt(2);
					if (rndInt == 0)
						mat[r][c] = 'X';
					else
						mat[r][c] = 'O';
				}
			}
		mat[0][0] = 'O';
		startRow = random.nextInt(12);
		startCol = 11;
		mat[startRow][startCol] = '.';
		visitStack = new Stack();
		currentMove = new Coord(startRow,startCol); 
		visitStack.push(currentMove);
	}


	void displayMaze()
	// displays the current maze configuration
	{
		System.out.println("\nRANDOM MAZE DISPLAY\n");
		for (int r = 0; r < 12; r++)
		{
			for (int c = 0; c < 12; c++)
				System.out.print(mat[r][c] + "  ");
			System.out.println();
		}
		System.out.println();
		pause();
	}


	public void solveMaze()
	// This methods solves the maze with private helper method <getMove>.
	// A loop is needed to repeat getting new moves until either a maze solution
	// is found or it is determined that there is no way out off the maze.
	{
		System.out.println("\n>>>>>   WORKING  ....  SOLVING MAZE   <<<<<\n");
      while(true) 
      {  
         if(currentMove.isFree())
         {
            break;
         }
         
         
         
         if(getMove() == false)
         {
            visitStack.pop();
            
            if(visitStack.isEmpty())
            {
               //System.out.println("Yo");
               break;
            }
            
            currentMove = (Coord)visitStack.peek();
            //System.out.println(currentMove.getRPos() + "  " + currentMove.getCPos());
         }
         
         
         //displayMaze();
         
      }
      //while(!currentMove.isFree() || !visitStack.empty());
      
	}


	public void mazeSolution()
	// Short method to display the result of the maze solution
	{
		if (currentMove.isFree())
			System.out.println("\nTHE MAZE HAS A SOLUTION.\n");
		else
			System.out.println("\nTHE MAZE HAS NO SOLUTION.\n");
	}


	private boolean inBounds(int r, int c)
	// This method determines if a coordinate position is inbounds or not        
	{
      if(r >= 12 || r < 0)
      {
          return false;
      }
      
      if(c >= 12 || c < 0)
      {
          return false;
      }
      
	  return true;
	}
   
   
	private boolean getMove() 
	// This method checks eight possible positions in a counter-clock wise manner
	// starting with the (-1,0) position.  If a position is found the method returns
	// true and the currentMove coordinates are altered to the new position
	{    
   
      char move1, move2, move3, move4, move5, move6, move7, move8;
      move1 = move2 = move3 = move4 = move5 = move6 = move7 = move8 = 'X';
      
      if(inBounds(currentMove.getRPos(),currentMove.getCPos()-1))
      {move1 = mat[currentMove.getRPos()][currentMove.getCPos()-1];}
         //System.out.println("move1 = " + move1);}
      
      
      if(inBounds(currentMove.getRPos()+1,currentMove.getCPos()-1))
      {move2 = mat[currentMove.getRPos()+1][currentMove.getCPos()-1];}
      //System.out.println("move2 = " + move2);}
      
      
      if(inBounds(currentMove.getRPos()+1,currentMove.getCPos()))
      {move3 = mat[currentMove.getRPos()+1][currentMove.getCPos()];}
      //System.out.println("move3 = " + move3);}
     
      
      if(inBounds(currentMove.getRPos()+1,currentMove.getCPos()+1))
      {move4 = mat[currentMove.getRPos()+1][currentMove.getCPos()+1];}
      //System.out.println("move4 = " + move4);}
      
      
      if(inBounds(currentMove.getRPos(),currentMove.getCPos()+1))
      {move5 = mat[currentMove.getRPos()][currentMove.getCPos()+1];}
      //System.out.println("move5 = " + move5);}
   
      
      if(inBounds(currentMove.getRPos()-1,currentMove.getCPos()+1))
      {move6 = mat[currentMove.getRPos()-1][currentMove.getCPos()+1];}
      //System.out.println("move6 = " + move6);}
     
     
      if(inBounds(currentMove.getRPos()-1,currentMove.getCPos()))
      {move7 = mat[currentMove.getRPos()-1][currentMove.getCPos()];}
      //System.out.println("move7 = " + move7);}
  
      
      if(inBounds(currentMove.getRPos()-1,currentMove.getCPos()-1))
      {move8 = mat[currentMove.getRPos()-1][currentMove.getCPos()-1];}
      //System.out.println("move8 = " + move8);}
   
      
      
      if(move1 == 'O')
      {  
         currentMove.setPos(0,-1);
         mat[currentMove.getRPos()][currentMove.getCPos()] = '.';
         Coord tempMove = new Coord(currentMove.getRPos(),currentMove.getCPos());
         visitStack.push(tempMove);
         return true;
      }
      
      else if(move2 == 'O')
      {  
         currentMove.setPos(1,-1);
         //visitStack.push(currentMove);
         mat[currentMove.getRPos()][currentMove.getCPos()] = '.';
         Coord tempMove = new Coord(currentMove.getRPos(),currentMove.getCPos());
         visitStack.push(tempMove);
         return true;
      }
      
      else if(move3 == 'O')
      {  
         currentMove.setPos(1,0);
         //visitStack.push(currentMove);
         mat[currentMove.getRPos()][currentMove.getCPos()] = '.';
         Coord tempMove = new Coord(currentMove.getRPos(),currentMove.getCPos());
         visitStack.push(tempMove);
         return true;
      }
      
      else if(move4 == 'O')
      {  
         currentMove.setPos(1,1);
         //visitStack.push(currentMove);
         mat[currentMove.getRPos()][currentMove.getCPos()] = '.';
         Coord tempMove = new Coord(currentMove.getRPos(),currentMove.getCPos());
         visitStack.push(tempMove);
         return true;
      }
      
      else if(move5 == 'O')
      {  
         currentMove.setPos(0,1);
         //visitStack.push(currentMove);
         mat[currentMove.getRPos()][currentMove.getCPos()] = '.';
         Coord tempMove = new Coord(currentMove.getRPos(),currentMove.getCPos());
         visitStack.push(tempMove);
         return true;
      }


      else if(move6 == 'O')
      {  
         currentMove.setPos(-1,1);
         //visitStack.push(currentMove);
         mat[currentMove.getRPos()][currentMove.getCPos()] = '.';
         Coord tempMove = new Coord(currentMove.getRPos(),currentMove.getCPos());
         visitStack.push(tempMove);
         return true;
      }
      
      else if(move7 == 'O')
      {  
         currentMove.setPos(-1,0);
         //visitStack.push(currentMove);
         mat[currentMove.getRPos()][currentMove.getCPos()] = '.';
         Coord tempMove = new Coord(currentMove.getRPos(),currentMove.getCPos());
         visitStack.push(tempMove);
         return true;
      }

      else if(move8 == 'O')
      {  
         currentMove.setPos(-1,-1);
         //visitStack.push(currentMove);
         mat[currentMove.getRPos()][currentMove.getCPos()] = '.';
         Coord tempMove = new Coord(currentMove.getRPos(),currentMove.getCPos());
         visitStack.push(tempMove);
         return true;
      }
      //System.out.println("R = " + currentMove.getRPos() + " C = " + currentMove.getCPos());
	   return false;
	}
   
	private void pause() 
	{   
		Scanner input = new Scanner(System.in); 
		String dummy;
		System.out.print("\nPress <Enter> to continue  ===>>  ");						
		dummy = input.nextLine();								
	}


}

