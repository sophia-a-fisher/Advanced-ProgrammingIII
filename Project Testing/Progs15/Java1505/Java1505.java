// Java1505.java
// This program is identical to Java1503.java.
// The files are still the same directory, but this time
// you are expected to use a project.


public class Java1505
{ 
	public static void main(String args[])
	{
		System.out.println("\nJava1505.java\n");

		Widget w = new Widget(10);
		System.out.println("Starting with " + w.getWidgets() + " widgets");
		w.setWidgets(30);
		System.out.println("Ending with   " + w.getWidgets() + " widgets");
		System.out.println();

		Aardvark a = new Aardvark(20);
		System.out.println("Starting with " + a.getAardvarks() + " aardvarks");
		a.setAardvarks(50);
		System.out.println("Ending with   " + a.getAardvarks() + " aardvarks");
		System.out.println();
		
		Mango m = new Mango(25);
		System.out.println("Starting with " + m.getMangos() + " mangos");
		m.setMangos(75);
		System.out.println("Ending with   " + m.getMangos() + " mangos");
		System.out.println();		
	}
}

	