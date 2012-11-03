/**
 * 
 */
package Math;

/**
 * @author chenqian
 *
 */
public class MathUtility {

public static double eps = 1e-8;
	

	/**
	 * D(x) < 0, x < 0
	 * D(x) == 0, x == 0
	 * D(x) > 0, x > 0
	 * */
	public static int D(double x){
		if(x < -eps)return -1;
		if(x > eps)return 1;
		return 0;
	}
	
	/**
	 * Determinant
	 * */
	public static double Det(MathPoint a, MathPoint b, MathPoint c){
		return (b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY());
	}
	
	
	/**
	 * Calculate the cross point of two lines. Before all, we need to judge two lines are not parallel.
	 * */
	public static MathPoint getCross2Lines(MathPoint u1, MathPoint u2, MathPoint v1, MathPoint v2){
		MathPoint ret=u1;
		double t=((u1.getX()-v1.getX())*(v1.getY()-v2.getY())-(u1.getY()-v1.getY())*(v1.getX()-v2.getX()))
			/((u1.getX()-u2.getX())*(v1.getY()-v2.getY())-(u1.getY()-u2.getY())*(v1.getX()-v2.getX()));
		ret.setX(ret.getX() + (u2.getX()-u1.getX())*t);
		ret.setY(ret.getY() + (u2.getY()-u1.getY())*t);
		return ret;
	}
	
	
	/**
	 * To judge whether two lines are parallel.
	 * */
	public static boolean isParallel(MathPoint u1, MathPoint u2, MathPoint v1, MathPoint v2){
		return D((u1.getX()-u2.getX())*(v1.getY()-v2.getY())-(v1.getX()-v2.getX())*(u1.getY()-u2.getY()))==0;
	}

	
	/**
	 * To judge whether two points locate two sides of a line strictly.
	 * 
	 * */
	public static boolean isOppoSide(MathPoint u1, MathPoint u2, MathPoint v1, MathPoint v2){
		return D(Det(u1, v1, v2) * Det(u2, v1, v2)) < 0;
	}
	
	public static boolean isInsideRect(MathPoint x, MathPoint[] rect){
		if(D(Det(x, rect[0], rect[1]) * Det(x, rect[3], rect[2])) > 0)return false;
		if(D(Det(x, rect[0], rect[3]) * Det(x, rect[1], rect[2])) > 0)return false;
		//System.err.println("inside");
		return true;
	}
	
	
	/**
	 * To judge whether two segments are intersected.
	 * */
	public static boolean is2SegmentsCrossed(MathPoint u1, MathPoint u2, MathPoint v1, MathPoint v2){
		return isOppoSide(u1, u2, v1, v2) && ( D(Det(v1, u1, u2) * Det(v2, u1, u2)) <= 0 ) || ( D(Det(u1, v1, v2) * Det(u2, v1, v2)) <= 0 ) && isOppoSide(v1, v2, u1, u2);
	}
	
	public static boolean isSegmentIntersectWithRect(MathLine l, MathPoint[] rect){
		for(int i = 0; i < 4; i++){
			if(is2SegmentsCrossed(l.u, l.v, rect[i], rect[(i + 1) % 4])){
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isSegmentInterOrInsideWithRect(MathLine l, MathPoint[] rect){
		if(isInsideRect(l.u, rect) || isInsideRect(l.v, rect) || isSegmentIntersectWithRect(l, rect)){
			return true;
		}
		return false;
	}
	
	public static boolean isSegmentInterOrInsideWithRect(MathPoint p1, MathPoint p2, MathPoint p3, MathPoint p4){
		MathLine seg = new MathLine(p1, p2);
		MathPoint[] rect = new MathPoint[4];
		rect[0] = new MathPoint(p3.getX(), p3.getY());
		rect[1] = new MathPoint(p3.getX(), p4.getY());
		rect[2] = new MathPoint(p4.getX(), p4.getY());
		rect[3] = new MathPoint(p4.getX(), p3.getY());
		if(isSegmentInterOrInsideWithRect(seg, rect)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
