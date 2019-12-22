package shape;


public class Cylinder extends Circle {

	private double h;

	public Cylinder(String n, double r, double h)
	{
		super(n,r);
		this.h=h;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	@Override
	public String toString() {
		return super.toString() + " Height: " + getH();
	}

	public double getArea()
	{
		return 2*Math.PI*r*getH();
	}


}
