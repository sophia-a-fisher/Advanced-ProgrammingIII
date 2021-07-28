public class Runner
{
   public static void main(String[] args)
   {
      IntQueue test1 = new IntQueue();
      System.out.println(test1.isEmpty());
      test1.enQueue(1);
      test1.enQueue(2);
      test1.enQueue(3);
      System.out.println(test1.isEmpty());
      System.out.println(test1.deQueue());
      System.out.println(test1.peekFront());
   }

}