package cryptography;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	
	private static final String dictionaryLocation = "wordlist (1).txt";
	
	private static String[] dictionary;
	
	/*	reads a file into an arraylist 
	 * populates dictionary array
	 */
	public static String[] getNew() throws FileNotFoundException {
		Scanner scan = new Scanner(dictionaryLocation);
		ArrayList<String> tempDictionary = new ArrayList<String>();
		while (scan.hasNextLine()) {
			tempDictionary.add(scan.nextLine());
		}
		dictionary = new String[tempDictionary.size()];

		// ArrayList to Array Conversion
		for (int i =0; i < tempDictionary.size(); i++)
			dictionary[i] = tempDictionary.get(i);
		scan.close();
		return dictionary;
	}
	

}
