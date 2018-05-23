package cryptography;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StandardCryptogramSolver {
	//private static Dictionary wordList = new Dictionary(); //attempting to read in dictionary subject to change
	
	
	public static ArrayList<ArrayList<Integer>> findDoubles(String word) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>(); //stores combination representing identical letters
		for (int i = 0; i < word.length()-1; i++) { //iterate through word
			char c = word.charAt(i); //just for making it faster
			for (int j = i; j < word.length(); j++) {
				if (word.charAt(j) == c) {
					ArrayList<Integer> q = new ArrayList<Integer>();//make elements for main arraylist
					q.add(i);
					q.add(j);
					a.add(q);
				}
			}
		}
		return a;
	}

    public static char fillPossibilities(String word, int i, int j, char letter, ArrayList<ArrayList<Integer>> doubles){
  		 return wordList[i].charAt(doubles.get(j).get(0));
  	 
   }

   public static ArrayList<Cipher> findCiphers(String word) {
  	 ArrayList<ArrayList<Integer>> doubles = findDoubles(word);
  	 int wordLength = word.length(); //making it slightly faster
  	 ArrayList<Cipher> ciphers = new ArrayList<Cipher>(); //stores strings that match the criteria
  	 for (int i = 0; i < wordList.length; i++) {//iterate through word list (long, but I have no better schemes)
  		 Cipher possibility = new Cipher();
  		 char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
  		 if (wordList[i].length() == wordLength) {
  			 for (int j = 0; j < doubles.size(); j++) {
  				 if (wordList[i].charAt(doubles.get(j).get(0)) == wordList[i].charAt(doubles.get(j).get(1))) {//test if the doubles are in the right place
  					 for (int k = 0; k<=25; k++){
  						 possibility.set(k, fillPossibilities(word, i, j, letters[k], doubles)); //fill possibilities
  					 }
  				 }
  			 }
  			 ciphers.add(possibility);
  		 }
  	 }
  	 return ciphers;
   }



	/* takes arraylist of arraylist of Strings
	 * combines and eliminates each row
	 * left with an arraylist of one arraylist of one string (more than one is techically possible but highly unlikely
	 */

	public static ArrayList<ArrayList<Cipher>> eliminateOptions(ArrayList<ArrayList<Cipher>> cipherList){
		//makes new arrayList and sets size to one less than cipher list
		ArrayList<ArrayList<Cipher>> newList = cipherList;
		ArrayList<Cipher> tempList = new ArrayList<Cipher>();
		newList.remove(0); //gets rid of the first list bc/s it will get combined with the next

		for (Cipher i: cipherList.get(0)){ //iterate first word possibilities
			for (Cipher j: cipherList.get(1)){//iterate through next set of possibilities
				if (Cipher.worksWith(i, j)==false){ //if the two ciphers work together
					tempList.add(Cipher.combine(i, j));
				}
			}
		}
		
		newList.set(0, tempList);
		newList=eliminateOptions(newList);
		return newList;
	}




	public static void main(String[] args) throws FileNotFoundException {
		String[] wordList = Dictionary.main(); //attempting to read in dictionary subject to change
		System.out.println(wordList[6]); //testing dictionary
		long startTime = System.currentTimeMillis();

		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}





