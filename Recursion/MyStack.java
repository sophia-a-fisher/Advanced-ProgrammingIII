import java.util.*;

class MyStack
{
	private LinkedList list;	// stores Stack list
	private int size;		    // store the number of elements in the list
	   
	public MyStack()
	// Initializes an empty array object with references of private variable list objects.
	{
		list = new LinkedList();
      size = 0;
 	}
	
	public boolean isEmpty()
	// Returns true if the stack is empty, false otherwise
	{
      if(size == 0)
      {return true;}
      
		return false;
	}
	
	public void push (Object x)
	// Adds variable x to the top of the Stack
	{
      list.add(x);
      size++;
	}
	
	public Object pop()
	// Returns and removes the top element from the Stack
	{
		Object topElement = list.remove(size-1);
      size--;
      return topElement;
	}
	
	public Object peekTop()
	// Returns the top element from the Stack without removal
	{
      return list.get(size-1);
	}
	
}
