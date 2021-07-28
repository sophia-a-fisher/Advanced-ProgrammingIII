import java.util.*;

public class Quiz316
{
	public static LinkedList list;
	
	public static void main(String args[])
	{
		list = new LinkedList();
		for (int j = 1; j <= 23; j++)	
		   list.addLast(new Integer(j*j));   	
		lastFirst();
		System.out.println("\n");
	}
	
	public static void lastFirst()
   {
      for(int i = list.size()-1; i >= 0; i--)
      {
         System.out.print(list.remove(i) + " ");
      }
	}
}