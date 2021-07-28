// Lab31st.java
// This is the student version of the Lab31 assignment.
// The main method is ready for the 80-point version and needs
// to be altered for the 90 point and 100 point versions.


import java.util.Random;

public class Lab31ast
{
	public static void main(String args[])
	{
		System.out.println("\nLab31 80 Point Version\n");
		MyList list1 = new MyStack(100);
		MyList list2 = new MyQueue(100);
		Random rnd = new Random(12345);
		for (int k = 1; k <= 20; k++)
		{
			int rndInt = rnd.nextInt(20) + 10;
			addData(list1,rndInt);
			addData(list2,rndInt);
		}
		showData(list1,list2);
		System.out.println();
		
		for (int k = 1; k <= 5; k++)
		{
			removeData(list1);
			removeData(list2);
		}
		showData(list1,list2);	
		System.out.println();
	}
   
   public void addData(MyList obj, int element)
   {
      obj.add(element);
   }
   
   public void removeData(MyList obj)
   {
      obj.remove();
   }
   
   public void showData(MyList ob1, MyList ob2)
   {
      System.out.println(ob1);
      System.out.println();
      System.out.println(ob2);
   }
	
}



abstract interface MyList
{
	public abstract void add(int x);
	
	public abstract int remove();
	
	public abstract boolean isEmpty();
	
	public abstract int getSize();
}

public class MyStack implements MyList
{
   private int capacity;
   private int size;
   private int front;
   private int[] intArray;

   public MyStack(int capacity)
   {
      this.capacity = capacity;
      intArray = new int[this.capacity];
      front = 0;
      size = 0;
   }

   public void add(int x)
   {
      intArray[front] = x;
      size++;
   }
	
	public int remove()
   {
      intArray[front] = 0;
      front++;
      size--;
   }
	
	public boolean isEmpty()
   {
      if(size == 0)
      {
         return true;
      }
      return false;
   }
	
	public int getSize()
   {
      return size;
   }
}

public class MyQueue implements MyList
{
   private int capacity;
   private int size;
   private int front;
   private int back;
   private int[] intArray;

   public MyQueue(int capacity)
   {
      this.capacity = capacity;
      intArray = new int[this.capacity];
      front = 0;
      back = 0;
      size = 0;
   }

   public void add(int x)
   {
      intArray[back] = x;
      size++;
      back++;
   }
	
	public int remove()
   {
      intArray[front] = 0;
      front++;
      size--;
   }
	
	public boolean isEmpty()
   {
      if(size == 0)
      {
         return true;
      }
      return false;
   }
	
	public int getSize()
   {
      return size;
   }
}