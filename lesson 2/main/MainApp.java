package main;
import classes.ClassA;
import manager.*;
import shape.Circle;
import shape.Cylinder;

public class MainApp {

	public static void main(String[] args) 
	{
		//LinkedListManager manager = new LinkedListManager();
		LinkedListManager manager = LinkedListManager.getInstance();
		
		manager.addToList(new Circle("cir1", 23.5));
		manager.addToList(new Circle("cir2", 23.5));
		manager.addToList(new Circle("cir3", 23.5));
		manager.addToList(new Circle("cir4", 23.5));
		manager.addToList(new Circle("cir5", 23.5));

		manager.addToList(new Cylinder("cyl1", 44.5, 5.6));
		manager.addToList(new Cylinder("cyl2", 23.5,4.5));
		manager.addToList(new Cylinder("cyl3", 23.5,8.9));
		manager.addToList(new Cylinder("cyl4", 23.5,2.9));
		manager.addToList(new Cylinder("cyl5", 23.5,55.6));

		System.out.println("*************************10 objects:************************");
		System.out.println(manager.toString());
		
		createNewLink();
		
		System.out.println("*************************20 objects:************************");
		System.out.println(manager.toString());
		
		ClassA objA = new ClassA();
		objA.addObjects();
		
		System.out.println("*************************30 objects:************************");
		System.out.println(manager.toString());
	}

	public static void createNewLink()
	{
		LinkedListManager manager = LinkedListManager.getInstance();

		manager.addToList(new Circle("cir6", 23.5));
		manager.addToList(new Circle("cir7", 23.5));
		manager.addToList(new Circle("cir8", 23.5));
		manager.addToList(new Circle("cir9", 23.5));
		manager.addToList(new Circle("cir10", 23.5));

		manager.addToList(new Cylinder("cyl6", 44.5, 5.6));
		manager.addToList(new Cylinder("cyl7", 23.5,4.5));
		manager.addToList(new Cylinder("cyl8", 23.5,8.9));
		manager.addToList(new Cylinder("cyl9", 23.5,2.9));
		manager.addToList(new Cylinder("cyl10", 23.5,55.6));


	}

}
