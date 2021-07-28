// Java3030.java
// Complete the <compareTo> method below to order the priority queue from highest to lowest gpa. // Redefine the <toString> method to display student records in the format [Tom, 21, 2.785];
import java.util.*;

public class Java3030 
{
   public static void main(String args[]) 
   {
      System.out.println("Java3030.java\n\n");
      PriorityQueue<Student> pqueue = new PriorityQueue<Student>();
      pqueue.add(new Student("Tom",21,2.785)); pqueue.add(new Student("Ann",40,3.555)); pqueue.add(new Student("Joe",61,2.015)); pqueue.add(new Student("Bob",35,3.275)); pqueue.add(new Student("Dee",55,3.999));
      
      while(!pqueue.isEmpty()) 
      {
         System.out.println(pqueue.remove()); 
      }
      System.out.println("\n\n"); 
   }
}

class Student implements Comparable 
{
   private String name; private int age; public double gpa;
   public Student(String n, int a, double g) 
   {
      name = n; age = a; gpa = g;
   }
   
   public int compareTo (Object source) 
   {
      Student temp = (Student)source;
      Double obGPA = temp.gpa;
      return obGPA.compareTo(this.gpa);
   }
   
   public String toString() 
   {
      return "[" + name + ", " + age + ", " + gpa + "]";
   }
}