/**
 * 
 */
package utility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author chenqian
 * This file is to parse data from gowalla dataset http://snap.stanford.edu/data/loc-gowalla.html.
 * It will will generate the rating/score for every location.
 * The format of original dataset is [user]	[check-in time]		[latitude]	[longitude]	[location id].
 * 
 * rate is to control the ratio of sqrt(z) weight compared with x,y. 
 * 
 */
public class gowallaParser {

	public static HashMap<Long, location> locations = new HashMap<Long, location>();
	public static double rate ;
	
	public static void loadData(String fileInputPath) throws FileNotFoundException{
		Scanner in = new Scanner(new BufferedInputStream(new FileInputStream(new File(fileInputPath))));
		while(in.hasNext()){
			String line = in.nextLine();
			String[] tks = line.split("\t");
			long locId = Long.parseLong(tks[4]);
			double lat = Double.parseDouble(tks[2]);
			double lng = Double.parseDouble(tks[3]);
			if(locations.containsKey(locId)){				
				locations.get(locId).addOneRating();
			}else{
				locations.put(locId, new gowallaParser().new location(locId, lat, lng));
			}
		}
		in.close();
	}
	
	public static void formatData(){
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length > 0){
			rate = Double.parseDouble(args[0]);
		}else{
			Scanner in = new Scanner(System.in);
			System.out.println("Please input the rate to convert:");
			rate = Double.parseDouble(in.nextLine());
		}
		
	}
	
	class location{
		long locId;
		long rating;
		double lat, lng;
		public location() {
			// TODO Auto-generated constructor stub
			rating = 0;
		}
		public location(long _locId, double _lat, double _lng){
			locId = _locId;
			lat = _lat;
			lng = _lng;
			rating = 1;
		}
		public void addOneRating(){
			++ rating ;
		}
	}

}
