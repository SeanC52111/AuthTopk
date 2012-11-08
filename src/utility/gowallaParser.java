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
 */
public class gowallaParser {

	HashMap<Integer, ArrayList<Integer>> pointsList = new HashMap<Integer, ArrayList<Integer>>();
	
	public static void loadData(String fileInputPath) throws FileNotFoundException{
		Scanner in = new Scanner(new BufferedInputStream(new FileInputStream(new File(fileInputPath))));
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
