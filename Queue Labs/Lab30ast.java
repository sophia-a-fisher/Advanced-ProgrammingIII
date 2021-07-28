// Lab30ast.java
// The Screen Saver Program
// Student Version



import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.*;



public class Lab30ast
{    
	public static void main(String args[])  
	{
      String circles = JOptionPane.showInputDialog("Enter Circle Count");
		String size = JOptionPane.showInputDialog("Enter Circle Size");
      GfxApp gfx = new GfxApp(Integer.parseInt(circles), Integer.parseInt(size));
      gfx.setSize(800,600);
      gfx.setBackground(Color.white);
		gfx.addWindowListener(new WindowAdapter() {public void
			windowClosing(WindowEvent e) {System.exit(0);}});
		gfx.show();
	}
}




class GfxApp extends Frame
{
	
	private int circleCount, circleSize;
   private Queue coordQueue;
	
	public GfxApp()
	{
		circleCount = 50;
		circleSize  = 30;
      coordQueue = new LinkedList();
	}
   
   public GfxApp(int circle, int size)
	{
		circleCount = circle;
		circleSize  = size;
      coordQueue = new LinkedList();
	}

			

	class Coord
	{
		private int xPos;
		private int yPos;

		public Coord(int x, int y) 
		{
			xPos = x;
			yPos = y;
		}
      
      public int getXPos()
      {
         return xPos;
      }
      public int getYPos()
      {
         return yPos;
      }
	}
   	
	public void paint(Graphics g)
	{
		int incX = 5;
		int incY = 5;
		int diameter = circleSize;
		int timeDelay = 10;
		Circle c = new Circle(g,diameter,incX,incY,timeDelay);
      coordQueue.add(new Coord(c.getTLX(), c.getTLY()));
		for (int k = 1; k <= 2000; k++)
		{	
			
         if(coordQueue.size()<circleCount)
         {
            c.drawCircle(g);
            coordQueue.add(new Coord(c.getTLX(), c.getTLY()));
            //System.out.println("Adding to the quueeu");
         }
      
         else
         {
            Coord tempCoord = (Coord)coordQueue.remove();
            c.eraseCircle(tempCoord.getXPos(),tempCoord.getYPos());
            //System.out.println("removing from the quueeu");

         }

			c.hitEdge();
         
		}

	} 
}
      
      

class Circle
{
	private int tlX;		// top-left X coordinate
	private int tlY;		// top-left Y coordinate
	private int incX;		// increment movement of X coordinate
	private int incY;		// increment movement of Y coordinate
	private boolean addX;	// flag to determine add/subtract of increment for X
	private boolean addY;	// flag to determine add/subtract of increment for Y
	private int size;		// diameter of the circle
	private int timeDelay;	// time delay until next circle is drawn
   private Graphics g;
      
	public Circle(Graphics g, int s, int x, int y, int td)
	{
		incX = x;
		incY = y;
		size = s;
		addX = true;
		addY = false;
		tlX = 400;
		tlY = 300;
		timeDelay = td;
      this.g = g;
	}
   
	public void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.currentTimeMillis();	
	}

	public void drawCircle(Graphics g)
	{
		g.setColor(Color.blue);
		g.drawOval(tlX,tlY,size,size);
      
            
		delay(timeDelay);
		if (addX)
			tlX+=incX;
		else
			tlX-=incX;
		if (addY)
			tlY+=incY;
		else
			tlY-=incY;
	}
   
   	 
	public void newData()
	{
		incX = (int) Math.round(Math.random() * 7 + 5);
		incY = (int) Math.round(Math.random() * 7 + 5);
	}

	public void hitEdge()
	{
		boolean flag = false;
		if (tlX < incX)
		{
			addX = true;
			flag = true;
		}
		if (tlX > 800 - (30 + incX)) 
		{
			addX = false;
			flag = true;
		}
		if (tlY < incY + 30) // The +30 is due to the fact that the title bar covers the top 30 pixels of the window
		{
			addY = true;
			flag = true;
		}
		if (tlY > 600 - (30 + incY)) 
		{
			addY = false;
			flag = true;
		}
		if (flag)
			newData();
	}
   
   // erases the circle, which is drawn with top-left coordinate at (x,y)
   public void eraseCircle(int x, int y)
   {
      g.setColor(Color.white);
		g.drawOval(x,y,size,size);     
   }
   
   // returns the value of the top-left corner X-value of the current circle drawn
   public int getTLX()
   {
      return tlX;
   }

   // returns the value of the top-left corner Y-value of the current circle drawn
   public int getTLY()
   {
      return tlY;
   }

}











