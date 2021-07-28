public class Coord
{
   final public int yCoord;
   final public int xCoord;
   final public int counter;
   
   public Coord(int xCoord, int yCoord, int counter)
   {
      this.xCoord = xCoord;
      this.yCoord = yCoord;
      this.counter = counter;
   }
   
   public Coord(int xCoord, int yCoord)
   {
      this.xCoord = xCoord;
      this.yCoord = yCoord;
      counter = 0;
   }
   
   public Coord()
   {
      xCoord = 0;
      yCoord = 0;
      counter = 0;
   }
   
}