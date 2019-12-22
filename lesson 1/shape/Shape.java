package shape;

public abstract class Shape implements Comparable<Shape> 
{

	protected String name;

	public Shape(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name: " + name;
	}

	public abstract double getArea();

	@Override
	public int compareTo(Shape obj) 
	{
		//return name.compareTo(o.name);//ascending
		//return -1 * name.compareTo(o.name);//descending
		
		int res = name.compareTo(obj.name);//First sort by name - ascending
		if (res == 0)
		{
			return this.getClass().getSimpleName().compareTo(obj.getClass().getSimpleName());//Second sort by class name - ascending
		}
		
		return res;
	}
}
