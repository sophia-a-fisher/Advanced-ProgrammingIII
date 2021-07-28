/**
 * Widget.java
 * The Widget class stores the total number of widgets in any
 * Widget object.  There is one constructor, one get method and
 * one set method.
 * Goes with Java1509 folder
 **/
 
 
public class Widget
{
	
	/**
	 * numWidgets attribute stores the total number of widgets.
	 **/
	private int numWidgets;
		
	/**
	 * Widget one-parameter constructor, which constructs an object and
	 * initializes the numWidget attribute.
	 **/	
	public Widget(int w)
	{
		numWidgets = w;
	}

	/**
	 * getWidgets returns the number of widgets stored.
	 **/	
	public int getWidgets()
	{
		return numWidgets;
	}

	/**
	 * setWidgets assigns a new value to the number of widgets stored.
	 **/		
	public void setWidgets(int w)
	{
		numWidgets = w;
	}
	
}
