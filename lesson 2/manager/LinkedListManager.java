package manager;

import java.util.Iterator;
import java.util.LinkedList;

import shape.Shape;

public class LinkedListManager 
{
	/**
	 * static member for same class
	 */
	private static LinkedListManager instance = null;

	/**
	 * private constructor
	 */
	private LinkedList<Shape> list = null;

	private LinkedListManager()
	{
		list = new LinkedList<Shape>();
	}

	/**
	 * In case instance is null ==> create it and return it
	 * otherwise, return it
	 * @return LinkedListManager
	 */
	public static LinkedListManager getInstance() {
		if(instance == null)
		{
			instance = new LinkedListManager();
		}

		return instance;
	}

	public void addToList(Shape obj) 
	{
		list.add(obj);
	}

	@Override
	public String toString() 
	{
		String str="";
		Iterator<Shape> iter = list.iterator();
		while(iter.hasNext())
		{
			str += iter.next().toString() + "\n";
		}
		return str;
	}
}
