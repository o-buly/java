package shape;


public class Circle extends Shape {
	
	protected double r;
	
	
	public Circle(String n,double r)
	{   
		super(n);
		this.r=r;
	}
	
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	
	public double getArea()
	{
		return Math.PI*r*r;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Radius: " + r;
	}

	
	

}
