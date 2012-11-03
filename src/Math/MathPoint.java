/**
 * 
 */
package Math;

/**
 * @author chenqian
 *
 */
public class MathPoint {

	private double x;
	private double y;
	public MathPoint(){}
	public MathPoint(double _x, double _y){
		setX(_x); setY(_y);
	}
	public MathPoint(double[] coords){
		setX(coords[0]);
		setY(coords[1]);
	}
	public MathPoint(float[] coords){
		setX(coords[0]);
		setY(coords[1]);
	}
	public void show(){
		System.out.println(getX() + " " + getY());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

}
