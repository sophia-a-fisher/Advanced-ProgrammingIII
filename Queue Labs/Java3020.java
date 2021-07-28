// Java3020.java
// Complete method <copy> so that the second parameter becomes a correct copy of the first parameter.
import java.util.*;

public class Java3020 
{
   public static void main(String args[]) 
   {
      System.out.println("Java3020.java\n\n"); Queue<Integer> queue1 = new LinkedList<Integer>(); Queue<Integer> queue2 = new LinkedList<Integer>(); for (int k = 1; k <= 10; k++)
      queue1.add(k); copy(queue1,queue2); queue2.remove(); System.out.println(queue1); System.out.println(queue2); System.out.println("\n\n");
   }
   public static void copy(Queue<Integer> q1, Queue<Integer> q2) 
   {
      Queue temp = new LinkedList();
      while(!q1.isEmpty())
      {
         int tempInt = q1.remove();
         q2.add(tempInt);
         temp.add(tempInt);
      }
      
      while(!temp.isEmpty())
      {
         Integer tempInt = (Integer)temp.remove();
         q1.add(tempInt);
      }
   }
}