/**
 * 
 */
package Math;

/**
 * @author chenqian
 *
 */
public class MathPoint {

	private double[] coords;
	
	public MathPoint(MathPoint p){
		coords = new double[p.getCoordsLen()];
		for(int i = 0; i < p.getCoordsLen(); i++){
			coords[i] = p.getCoord(i);
		}
	}
	
	public MathPoint(){
		coords = new double[2];
	}
	
	public static MathPoint add(MathPoint p, MathPoint q){
		MathPoint res = new MathPoint();
		res.coords[0] = p.getX() + q.getX();
		res.coords[1] = p.getY() + q.getY();
		return res;
	}
	public MathPoint(double _x, double _y){
		coords = new double[2];
		setX(_x); setY(_y);
	}
	public MathPoint(double[] coords){
		this.coords = new double[coords.length];
		for(int i = 0; i < coords.length; i++){
			this.coords[i] = coords[i];
		}
	}
	public MathPoint(float[] coords){
		this.coords = new double[coords.length];
		for(int i = 0; i < coords.length; i++){
			this.coords[i] = coords[i];
		}
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
		return coords[0];
	}
	public void setX(double x) {
		this.coords[0] = x;
	}
	public double getY() {
		return coords[1];
	}
	public void setY(double y) {
		this.coords[1] = y;
	}

	public double[] getCoords(){
		return coords;
	}
	
	public int getCoordsLen(){
		return coords.length;
	}
	
	public double getCoord(int i){
		if(i >= coords.length)System.err.println("i is out of range");
		return coords[i];
	}
}
