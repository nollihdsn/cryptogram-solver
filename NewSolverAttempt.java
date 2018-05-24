package cyrptogramChallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class NewSolverAttempt {
	public static void main(String args[]) throws FileNotFoundException {
		//String[] wordList = readFile();
		//for (String s: wordList) {
		//	System.out.println(s);
		//}
		String[] wordList = {"PERSEVERE", "AVOCADO", "DUCK", "POTATO", "BOSGOVOSO"};
		ArrayList<Cipher> cipherList = makeCipherList("BOSGOVOSO", wordList);
		System.out.println(cipherList.size());
		for (Cipher c: cipherList) {
			for (int i = 0; i < 26; i++) {
				System.out.print(c.get(i));
			}
			System.out.println("");
		}
		
	}
	//find letters the same as and different from each index
	//check similarities and differences on words from wordlist
	public static ArrayList<ArrayList<Integer>> findSimilarities(String w) {
		ArrayList<ArrayList<Integer>> similarities = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < w.length()-1; i++) {
			char c = w.charAt(i);
			ArrayList<Integer> same = new ArrayList<Integer>();
			for (int j = i+1; j < w.length(); j++) {
				if (w.charAt(j) == c) {
					same.add(j);
				} else {
					same.add(100);
				}
			}
			similarities.add(same);
		}
		return similarities;
	}
	
	public static ArrayList<Cipher> makeCipherList(String w, String[] wordList) {
		ArrayList<ArrayList<Integer>> similarities = findSimilarities(w);
		System.out.println(similarities.size());
		boolean pass = true;
		ArrayList<Cipher> cipherList = new ArrayList<Cipher>();
		for (String possible: wordList) { //iterate through wordlist
			System.out.println(possible);
		    if (possible.length() != w.length()) {
			    pass = false;
		    } else if (possible.length() == w.length()) {//test for correct length
		    	System.out.println("same length");
		        for (int i = 0; i < similarities.size(); i++) { //iterate through similarities, representing each character from the start of the word
		        	System.out.println(i);
		    	    char c = possible.charAt(i); // stores the character at i of possible
		    	    System.out.println(c);
		    	    ArrayList<Integer> characteristics = similarities.get(i); //a copy of the element, to avoid long impossible to read if statements
		    	    for (int j = 0; j < characteristics.size(); j++) { //iterate through each element of similarities, representing each subsequent letter's relation to the first
		    	    	if (characteristics.get(j) == 100) {
		    	    		if (possible.charAt(j+i) == c) {
		    	    			pass = false;
		    	    			System.out.println("false at line 65");
		    	    			
		    	    		}
		    	    	}
		    	    	else if (possible.charAt(j+i) != c) {
		    	    		pass = false;
		    	    		System.out.println("false at line 70");
		    	    		
		    	    	} 
		    	    }
		        }
			} 
		    System.out.println(pass);
			if (pass == true) {//make the Cipher object for this word
				System.out.println("true");
				Cipher possibility = new Cipher();
				for (int i = 0; i < w.length(); i++) {
					int index = w.charAt(i)-65;
					possibility.set(index, possible.charAt(i));
				}
				cipherList.add(possibility);
				System.out.println("added");
			}
		}
		return cipherList;
	}
	
	
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
