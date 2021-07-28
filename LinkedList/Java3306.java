import java.util.*;

public class Java3306
{
   public static void main(String args[])
   {
      System.out.println("\nJAVA3306.JAVA\n");
      LinkedList list = new LinkedList();
      
      for(int k = 1000; k <= 5000; k +=1000)
      {
         list.add(new Integer(k));
      }
      
      System.out.println(list);
      System.out.println();
      ListIterator iter = list.listIterator();
      while(iter.hasNext())
      {
         iter.next();
         iter.set(new Integer(9000));
         iter.add(new Integer(1111));
      }
      System.out.println(list);
      System.out.println();

   }
   
}