public class Line {
	private double slope;
	private double y_intercept;

	public Line(Point first, Point second) {
		slope = (second.getY()-first.getY())/(second.getX()- first.getX());
		y_intercept = first.getY() - slope*first.getX();
		
	} // end 2-arg constructor

	public String toString() {	
		return ("y = " + slope + "x + " + y_intercept); 
	} // end toString()

	public double getSlope(){
		return slope;
	}
	
	public double gety_intercept(){
		return y_intercept;
	}
	
	public boolean intersects(Line another) {
		boolean tf;
		if(another.getSlope() == slope){
			
			if (another.gety_intercept() == y_intercept){
				tf = true;
			}else{
				tf = false;
			}
		}else{
			tf = true;
		}
		return tf;
	} // end intersects()

} // end class