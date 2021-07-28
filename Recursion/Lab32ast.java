// Lab32ast.java
// The student version of the Lab32a assignment.


import java.awt.*;
import java.awt.event.*;


public class Lab32ast
{
	public static void main(String args[])
	{
		Windows win = new Windows();
		win.setSize(1000,750);
		win.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		win.show();
	}
}


class Windows extends Frame
{
   public Windows()
   {
      
   }
	public void paint(Graphics g)
   {
      g.setColor(Color.BLUE);
      drawSquare1(0, 200, g);
      drawSquare2(800, 200, g);
      //System.out.println("cat");
      //g.drawString("Hello World", 20, 20);
   }
   
   public void drawSquare1(int startPos, int side, Graphics g)
   {
      g.fillRect( startPos, 100, side, side );
      
      if(startPos + side < 1000 && side > 4)
      {
         drawSquare1(startPos + side + 10, side - (int)(side*.25), g);
      }
      
   }
   
   public int drawSquare2(int startPos, int side, Graphics g)
   {
     
      if(startPos > 0 && side > 4)
      {
         g.fillRect( startPos, 450, side, side );
         drawSquare2(startPos - (side - (int)(side*.25)) - 10, side - (int)(side*.25), g);

      }
      
      return side;
      
   }




}


