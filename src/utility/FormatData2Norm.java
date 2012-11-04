/**
 * 
 */
package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author chenqian
 *
 */
public class FormatData2Norm {

	public static void loadFile(String sourceFileName, String destFileName) throws FileNotFoundException{
		Scanner filein = new Scanner(new File(sourceFileName));
		PrintWriter pw = new PrintWriter(new File(destFileName));
		ArrayList<double[]> points = new ArrayList<double[]>();
		double minx = 1e20, maxx=-1e20, miny = 1e20, maxy = -1e20;
		while(filein.hasNext()){
			/**
			 * data format : operation, id, x1, y1, x2, y2
			 * */
			String line = filein.nextLine();
			String[] tks = line.split(" ");
			double[] point = new double[]{Double.parseDouble(tks[2]), Double.parseDouble(tks[3])};
			points.add(point);
			if(minx > point[0]) minx = point[0];
			if(maxx < point[0]) maxx = point[0];
			if(miny > point[1]) miny = point[1];
			if(maxy < point[1]) maxy = point[1];
		}
		filein.close();
		for(int i = 0; i < points.size(); i++){
			double[] point = points.get(i);
			pw.print(point[0] / (maxx - minx));
			pw.print("\t");
			pw.println(point[1] / (maxy - miny));
		}
		pw.flush();
		pw.close();
	}
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		String line = "Choose dataset \n(a) NE\n(b) User input";
		System.out.println(line);
		String option = in.nextLine(), sourceFileName, destFileName;
		if(option.equalsIgnoreCase("a")){
			
		}else if(option.equalsIgnoreCase("b")){
			System.out.println("Please input source file name:");
			sourceFileName = in.nextLine();
			System.out.println("Please input destination file name:");
			destFileName = in.nextLine();
			loadFile(sourceFileName, destFileName);
		}
		System.out.println("Finished!");
	}

}
