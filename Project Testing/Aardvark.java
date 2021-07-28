/**
 * Aardvark.java
 * The Aardvark class stores the total number of aardvarks in any Aardvark object.  
 * There is one constructor, one get method and one set method.
 * Goes with Java1509 folder
 **/
 
 
public class Aardvark
{
	/**
	 * numAardvark attribute store the total number of aardvarks.
	 **/
	private int numAardvarks;
	
	/**
	 * Aardvark one-parameter constructor, which constructs an object and
	 * initializes the numAardvarks attribute.
	 **/
	public Aardvark(int a)
	{
		numAardvarks = a;
	}

	/**
	 * getAardvarks returns the number of aardvarks stored.
	 **/	
	public int getAardvarks()
	{
		return numAardvarks;
	}
	
	/**
	 * setAardvarks assigns a new value to the number of aardvarks stored.
	 **/	
	public void setAardvarks(int a)
	{
		numAardvarks = a;
	}
	
}

