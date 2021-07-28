/**
 * Mango.java
 * The Mango class stores the total number of mangos in any
 * Mango object.  There is one constructor, one get method and
 * one set method.
 * Goes with Java1509 folder
 **/
 
 
public class Mango
{
	/**
	 * numMangos attribute store the total number of mangos.
	 **/
	protected int numMangos;

	/**
	 * Mango one-parameter constructor, which constructs an object and
	 * initializes the numMangos attribute.
	 **/	
	public Mango(int m)
	{
		numMangos = m;
	}
	
	/**
	 * getMangos returns the number of mangos stored.
	 **/	
	public int getMangos()
	{
		return numMangos;
	}
	
	/**
	 * setMangos assigns a new value to the number of mangos stored.
	 **/		
	public void setMangos(int m)
	{
		numMangos = m;
	}
	
}

	