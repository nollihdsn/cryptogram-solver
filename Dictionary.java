
package cyrptogramChallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	
	private static final String dictionaryLocation = "wordlist (1).txt";
	
	private static String[] dictionary;
	
	/*	reads a file into an arraylist 
	 * populates dictionary array
	 */
	public static String[] readFile() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("H:/My Documents/Eclipse/wordlist.txt"));
		ArrayList<String> a = new ArrayList<String>();
		while (scan.hasNextLine()) {
			a.add(scan.nextLine());
		}
		String[] w = new String[a.size()];
		for (int i = 0; i < a.size(); i++) {
			w[i] = a.get(i);
		}
		scan.close();
		return w;
	}
	

}