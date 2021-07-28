import java.util.*;

public class AStar
{
   public char[][] maze;
   public char[][] updateMaze;
   public int startX;
   public int startY;
   public int destX;
   public int destY;
   public ArrayList<Coord> coordList = new ArrayList<Coord>();
   
   public AStar()
   {
      maze = new char[][] {{'#','#','#','#','#'},
                           {'#','O','#','O','O'},
                           {'O','O','O','#','O'},
                           {'O','#','O','#','#'},
                           {'O','O','O','O','O'}};
                           
      maze = new char[][] {{'#','#','#','#','#','#'},
                           {'#','O','O','O','O','O'},
                           {'O','O','O','#','O','O'},
                           {'O','#','O','#','#','#'},
                           {'O','#','O','#','#','O'},
                           {'O','O','O','O','O','O'}};
                           
      maze = new char[][] {{'#','#','#','#','#','#'},
                           {'#','O','O','O','O','O'},
                           {'O','O','O','#','O','O'},
                           {'O','#','O','O','#','#'},
                           {'O','#','O','#','#','O'},
                           {'O','#','#','#','#','#'},
                           {'O','#','O','#','O','O'},
                           {'O','#','O','#','O','#'},
                           {'O','#','O','#','O','O'},
                           {'O','#','O','#','#','O'},
                           {'O','#','#','#','#','#'},
                           {'O','#','O','#','O','O'},
                           {'O','#','O','#','O','#'},
                           {'O','#','O','#','O','O'},
                           {'O','#','O','#','#','O'},
                           {'O','#','#','#','#','#'},
                           {'O','#','O','#','O','O'},
                           {'O','#','O','#','O','#'},
                           {'O','#','O','#','O','O'},
                           {'O','O','O','O','O','O'}};
                           
      updateMaze = new char[maze.length][maze[0].length];
                           
      for(int i = 0; i < maze.length; i++)
      {
         for(int j = 0; j < maze[0].length; j++)
         {
            //System.out.println("I = " + i);
            //System.out.println("J = " + j);
            updateMaze[i][j] = maze[i][j];
         }
      }

   }
   
   public static void main(String[] args)
   {
      AStar test = new AStar();
      System.out.println("\t\t\tA* Testing Algorithm\n");
      System.out.println("\t\t\t\t:Original maze:\n");
      test.printMaze(test.maze);
      
      test.startX = 5;
      test.startY = 16;
      test.destX = 1;
      test.destY = 1;
      
      test.aPathfinding(test.startX,test.startY,test.destX,test.destY);
      test.modifyMaze(test.updateMaze);
      System.out.println("\n\t\t\t\t:Finished maze:\n");
      test.printMaze(test.updateMaze);
      
      System.out.println("Final Counter = " + test.coordList.get(test.coordList.size()-1).counter);
      System.out.println("List Size = " + test.coordList.size());
      test.printList(test.coordList);
      
   }
   
   public int aPathfinding(int src, int src2, int des1, int des2)
   {
      int counter = 0;
      boolean searching = true;
      ArrayList<Coord> toAdd = new ArrayList<Coord>();
      Coord adjRight = null;
      Coord adjLeft = null;
      Coord adjDown = null;
      Coord adjUp = null;
      
      coordList.add(new Coord(src,src2,counter));
      
      do{
         counter++;
         
         for(Coord item : coordList)
         {
            if(item.counter == counter - 1)
            {
               //adjacent down
               //something wrong?
               if(item.yCoord < maze.length-1 && maze[item.yCoord + 1][item.xCoord] == 'O')
               {toAdd.add(new Coord(item.xCoord,item.yCoord + 1, counter));}
               
               //adjacent up
               if(item.yCoord > 0 && maze[item.yCoord - 1][item.xCoord] == 'O')
               {toAdd.add(new Coord(item.xCoord,item.yCoord - 1, counter));}
               
               //adjacent right
               if(item.xCoord < maze[0].length-1 && maze[item.yCoord][item.xCoord + 1] == 'O')
               {toAdd.add(new Coord(item.xCoord + 1,item.yCoord, counter));}
               
               //adjacent left
               if(item.xCoord > 0 && maze[item.yCoord][item.xCoord - 1] == 'O')
               {toAdd.add(new Coord(item.xCoord - 1,item.yCoord, counter));}
            }
         }
         
         //transfering adjacents to the coordList
         int initialSize = coordList.size();
         boolean removed = false;
         while(!toAdd.isEmpty())
         {  
            initialSize = coordList.size();
            removed = false;
            for(int i = 0; i < initialSize; i++)
            {
               if(toAdd.get(0).xCoord == coordList.get(i).xCoord && toAdd.get(0).yCoord == coordList.get(i).yCoord)
               {toAdd.remove(0);removed = true; break;}
               
            }
             if(!removed)
             {coordList.add(toAdd.remove(0));}

         }
         
         //checking if reached target
         for(Coord item : coordList)
         {
            //System.out.print("Entered check");
            //System.out.println("X = " + item.xCoord);
            //System.out.println("Y = " + item.yCoord);
            if(item.xCoord == des1 && item.yCoord == des2)
            {searching = false;}  
         }
         //System.out.println("Final Counter = " + coordList.get(coordList.size()-1).counter);
         //System.out.println("List Size = " + coordList.size());
         //printList(coordList);
               
      }while(searching);
      
      //System.out.println("\ncounter = " + counter);
      return 1;
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
   
   public void modifyMaze(char[][] maze)
   {
      Coord chosen = null;
      for(Coord item : coordList)
         {
            if(item.xCoord == destX && item.yCoord == destY)
            {
               chosen = item;
            }
         }

      boolean searching = true;
      Coord adjRight = null;
      Coord adjLeft = null;
      Coord adjDown = null;
      Coord adjUp = null;
      int lowCounter = chosen.counter;
      Coord lowCoord = chosen;
      maze[chosen.yCoord][chosen.xCoord] = 'A';
      
      //System.out.println("Low counter = " + lowCounter);
      do{
         for(Coord item : coordList)
         {
            //checking if down adjacent in list
            if(item.xCoord == chosen.xCoord && item.yCoord == chosen.yCoord + 1)
            {
               //System.out.println("item counter1 = " + item.counter);
               if(item.counter < lowCounter)
               {
                  lowCoord = item;
                  lowCounter = lowCoord.counter;
               }
            }
            
            //checking if up adjacent in list
            if(item.xCoord == chosen.xCoord && item.yCoord == chosen.yCoord - 1)
            {
               //System.out.println("item counter2 = " + item.counter);
               if(item.counter < lowCounter)
               {
                  lowCoord = item;
                  lowCounter = lowCoord.counter;
               }
            }
            
            //checking if right adjacent in list
            if(item.xCoord == chosen.xCoord + 1 && item.yCoord == chosen.yCoord)
            {
               //System.out.println("item counter3 = " + item.counter);
               if(item.counter < lowCounter)
               {
                  lowCoord = item;
                  lowCounter = lowCoord.counter;
               }
            }
            
            //checking if left adjacent in list
            if(item.xCoord == chosen.xCoord - 1 && item.yCoord == chosen.yCoord)
            {
               //System.out.println("item counter4 = " + item.counter);
               if(item.counter < lowCounter)
               {
                  lowCoord = item;
                  lowCounter = lowCoord.counter;
               }
            }
            
            
         }
         
         chosen = lowCoord;
         maze[chosen.yCoord][chosen.xCoord] = 'A';
                  
         //checking if reached target
         //System.out.println("Fin low counter = " + lowCounter);
         if(chosen.counter == 0)
            {searching = false;}  
            
      
               
      }while(searching);
      
   }
   
   public void printList(ArrayList<Coord> Alist)
   {
      for(Coord item : Alist)
      {
         System.out.print("X : " + item.xCoord);
         System.out.print("  Y : " + item.yCoord);
         System.out.print("  Counter : " + item.counter);
         System.out.println();
      }
   }
}