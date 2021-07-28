public class Java3309
{
   public static void main(String args[])
   {
      System.out.println("\nJAVA3309.JAVA\n");
      ListNode p;
      ListNode temp = null;
      
      p = new ListNode();
      p.value = "John";
      p.next = temp;
      temp = p;
      
      p = new ListNode();
      p.value = "Greg";
      p.next = temp;
      temp = p;
      
      p = new ListNode();
      p.value = "David";
      p.next = temp;
      temp = p;
      
      while(p != null)
      {
         System.out.println(p.value);
         p = p.next;
      }
      System.out.println();
   }
}

class ListNode
{
   public Object value;
   public ListNode next;
}

