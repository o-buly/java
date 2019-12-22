package main;
//import java.sql.Date;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
//import java.util.List;

import person.Person;
//import person.Person;
import shape.*;

public class MainApp {
	public static void main(String[] args)  {
		/*String str = "abc";//immutable
		str+="d";//new object
		
		StringBuilder sb = new StringBuilder("xyz");//mutable
		sb.append("w");//same object*/
		
		LinkedList<Shape> list=new LinkedList<Shape>();
		//list.add("hello");
		list.add(new Circle("Shape1",2));
		list.add(new Circle("Circle2",4));
		list.add(new Circle("Circle3",6));
		list.add(new Circle("Circle4",8));
		list.add(new Circle("Circle5",10));

		list.add(new Cylinder("Shape1",12,12.4));
		list.add(new Cylinder("Cylinder2",14,13.4));
		list.add(new Cylinder("Cylinder3",16,17.4));
		list.add(1, new Cylinder("Cylinder4",18,18.9));
		list.addFirst(new Cylinder("Cylinder5",20,20.1));
	
		//Print I
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		System.out.println();

		//Print II
		for (Shape shape : list) {
			System.out.println(shape);
		}
		System.out.println();
		
		//Print III
		System.out.println(list);
		System.out.println();
		
		//Print IV - Iterator
		Iterator<Shape> iter = list.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println();

		System.out.println("****************Area******************");
		for (Shape shape : list) {
			System.out.printf("Name: %s, Area: %.2f\n", shape.getName(), shape.getArea());
		}
		System.out.println();

		System.out.println("****************Sort for list******************");
		// sort in ascending order
		//Collections.sort(list);

		// sort in descending order		
		Collections.sort(list, Collections.reverseOrder());

		System.out.println("Print after sorting");
		for (Shape shape : list) {
			System.out.println(shape);
		}
		System.out.println();
		
		System.out.println("****************Sort for array******************");
		Integer[] arr = {1,2,310,9,8,311,300,0,-10,-100};
		//Arrays.sort(arr);//Ascending
		Arrays.sort(arr, Collections.reverseOrder());//Descending
		for (int val : arr)
			System.out.print(val + " ");
		System.out.println();
		/* we must implement Comparable
		Person[] arrShapes = new Person[2];
		arrShapes[0] = new Person("Yinon");
		arrShapes[1] = new Person("Noy");
		Arrays.sort(arrShapes);
		*/
	}

}