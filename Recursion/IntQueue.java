import java.util.*;

class IntQueue
{
	private LinkedList list;		// stores queue list
	private int size;		         // keeps queue size
	
	public IntQueue()
	// Initializes an empty array object with references of private variable list objects.
	{
		list = new LinkedList();
      size = 0;
	}
	
	public boolean isEmpty()
	// Returns true if list is empty, false otherwise
	{
		 if(size == 0)
       {return true;}
       
       return false;
	}
	
	public void enQueue (int x)
	// Adds variable x to the back of the queue
	{
		 list.add(x);
       size++;
	}
	
	public int deQueue()
	// Returns and removes the front element from the queue
	{
      size--;
		return (int)list.remove(0);
	}
	
	public int peekFront()
	// Returns the front element from the queue without removal
	{
		return (int)list.get(0);
	}
	
	
}