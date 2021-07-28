import java.util.*;

public class Quiz317
{
	public static TreeSet tree;
	
	public static void main(String args[])
	{
		tree = new TreeSet();
		for (int j = 1; j <= 23; j++)	
		    tree.add(new Integer(j*j));   	
		firstLast();
		System.out.println("\n");
	}
	
	public static void firstLast()
	{
	   Iterator it = tree.iterator();
      while(it.hasNext())
      {
         System.out.print(it.next() + " ");
      }
	}
}