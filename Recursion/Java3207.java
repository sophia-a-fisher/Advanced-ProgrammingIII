public class Java3207
{
   public static void main(String args[])
   {
      System.out.println("CALLING ITERATIVE SUM METHOD");
      System.out.println("1+2+3+4+5+6 = " + sum1(6));
      System.out.println("CALLING RECURSIVE SUM METHOD");
      System.out.println("1+2+3+4+5+6 = " + sum2(6));
      System.out.println("CALLING ITERATIVE SUM METHOD");
      System.out.println("sum1(-6) = " + sum1(-6));
      System.out.println("CALLING RECURSIVE SUM METHOD");
      System.out.println("sum2(-6) = " + sum2(-6));
   }
   
   public static int sum1(int n)
   {
      int sum = 0;
      for(int k = 1; k <= n; k++)
      {
         sum += k;
      }
      return sum;
   }
   
   public static int sum2(int n)
   {
      if(n == 0)
      {
         return 0;
      }
      
      else
      {
         return n + sum2(n-1);
      }
   }
}