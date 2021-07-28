// Java3016.java
// Complete method <delete> so that it removes the parameter number, but // leaves the remaining queue intact.
import java.util.*;
public class Java3016 
{
   public static void main(String args[]) 
   {
      System.out.println("Java3016.java\n\n"); Queue<Integer> queue = new LinkedList<Integer>(); for (int k = 1; k <= 10; k++)
      queue.add(k); System.out.println(queue); delete(queue,5); System.out.println(queue); System.out.println("\n\n");
   }
   
   public static void delete(Queue<Integer> q, int number) 
   {
      Queue temp = new LinkedList();
      int tempInt = 0;
      
      while(!q.isEmpty())
      {
         tempInt = q.remove();
         if(tempInt != number)
         {
            temp.add(tempInt);
         }
      }
      
      while(!temp.isEmpty())
      {
         q.add((Integer)temp.remove());
      }
      
   }
}