package shape;

public abstract class Shape implements Comparable<Shape> {

	public static int globalInt = 0;

	protected String name;
	protected int id=0;

	public Shape(String name) {
		this.name=name;
		id=globalInt;
		globalInt++;
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



	public int compareTo(Shape o) {
		int comparedSize = o.name.length();
		if (this.name.length() > comparedSize) {
			return 1;
		} else if (this.name.length() == comparedSize) {
			return 0;
		} else {
			return -1;
		}
	}


}
