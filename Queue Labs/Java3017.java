// Java3017.java
// Complete method <reverse> so that it reverses the queue members.
import java.util.*;
public class Java3017 
{
   public static void main(String args[]) 
   {
      System.out.println("Java3017.java\n\n"); Queue<Integer> queue = new LinkedList<Integer>(); for (int k = 1; k <= 10; k++)
      queue.add(k); System.out.println(queue); reverse(queue); System.out.println(queue); System.out.println("\n\n");
   }
   
   public static void reverse(Queue<Integer> q) 
   {
      Stack temp = new Stack();
      while(!q.isEmpty())
      {
         temp.push(q.remove());
      }
      
      while(!temp.isEmpty())
      {
      
         System.out.print(temp.pop() + " ");
         //q.add((Integer)temp.pop());
      }
      
   }
}