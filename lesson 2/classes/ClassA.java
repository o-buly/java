package classes;

import manager.LinkedListManager;
import shape.Circle;
import shape.Cylinder;

public class ClassA 
{
	public void addObjects()
	{
		LinkedListManager manager = LinkedListManager.getInstance(); 
		
		manager.addToList(new Circle("cir61", 23.5));
		manager.addToList(new Circle("cir71", 23.5));
		manager.addToList(new Circle("cir81", 23.5));
		manager.addToList(new Circle("cir91", 23.5));
		manager.addToList(new Circle("cir101", 23.5));

		manager.addToList(new Cylinder("cyl61", 44.5, 5.6));
		manager.addToList(new Cylinder("cyl71", 23.5,4.5));
		manager.addToList(new Cylinder("cyl81", 23.5,8.9));
		manager.addToList(new Cylinder("cyl91", 23.5,2.9));
		manager.addToList(new Cylinder("cyl101", 23.5,55.6));
	}
}
