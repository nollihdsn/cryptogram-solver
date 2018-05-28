package cryptography;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> message = new ArrayList<String>();
	//private static final String testCipher = "DJMLWK YNIS DJSM NW ZTO PNSRF LG TJSF. LH LZ POSO OJGY, OVOSYENFY PNIRF FN LZ. EIZ LZ’G WNZ. LZ ZJMOG BJZLOWCO, LZ ZJMOG CNDDLZDOWZ, JWF LZ CNDOG PLZT BROWZY NH HJLRISO JRNWK ZTO PJY. ZTO SOJR ZOGZ LG WNZ PTOZTOS YNI JVNLF ZTLG HJLRISO, EOCJIGO YNI PNW’Z. LZ’G PTOZTOS YNI ROZ LZ TJSFOW NS GTJDO YNI LWZN LWJCZLNW, NS PTOZTOS YNI ROJSW HSND LZ; PTOZTOS YNI CTNNGO ZN BOSGOVOSO.";
	private static final String testCipher = "DJMLWK YNIS DJSM NW ZTO PNSRF LG TJSF LH LZ POSO OJGY OVOSYENFY PNIRF FN LZ EIZ LZG WNZ LZ ZJMOG BJZLOWCO LZ ZJMOG CNDDLZDOWZ JWF LZ CNDOG PLZT BROWZY NH HJLRISO JRNWK ZTO PJY ZTO SOJR ZOGZ LG WNZ PTOZTOS YNI JVNLF ZTLG HJLRISO EOCJIGO YNI PNWZ LZG PTOZTOS YNI ROZ LZ TJSFOW NS GTJDO YNI LWZN LWJCZLNW NS PTOZTOS YNI ROJSW HSND LZ PTOZTOS YNI CTNNGO ZN BOSGOVOSO";

	private Scanner console;
	private static String originalCipher= "";

	public Message(String m){
		m=removePunctuation(m);
		message = new ArrayList<String>(Arrays.asList(m.split(" ")));
	}

	public void message(String m){
		originalCipher=m;
		m=removePunctuation(m);
		message = new ArrayList<String>(Arrays.asList(m.split(" ")));

	}

	// appropriatly constructs based on int option
	public Message(int option) throws FileNotFoundException{
		//option one reads from console
		if (option==1){
			console = new Scanner (System.in);
			System.out.println("input cipher, you idiot: ");
			while (console.hasNextLine()){
				String line = console.nextLine();
				message.add(removePunctuation(line));
				originalCipher+=(line);
			}
		}
		//options 2 uses test cipher
		if (option==2){
			originalCipher=testCipher;
			message = new ArrayList<String>(Arrays.asList(removePunctuation(testCipher).split(" ")));
		}
		//option 3 reads from file
		if (option==3){
			String m = cyptogramFromFile();
			m=removePunctuation(m);

			originalCipher=m;
			message = new ArrayList<String>(Arrays.asList(m.split(" ")));

		}
		removePunctuation();
	}


	/* raw code to be modified
	 * will read ciphers in from a text file
	 * 
	 */
	public static String cyptogramFromFile() throws FileNotFoundException {
		//reads a file into an String
		String m="";
		Scanner scan = new Scanner("wordlist (1).txt");
		while (scan.hasNextLine()) {
			m+=(scan.nextLine());
		}
		scan.close();
		return m;
	}

	public static String get(int index) {
		return message.get(index);
	}

	public static String getOriginal(){
		return originalCipher;
	}
	public static void set(ArrayList<String> message) {
		Message.message = message;
	}

	public static void removePunctuation() {
		boolean test;
		String m;
		String str = "";
		char[] punctuation = {',', '.', ';', '/', ':', '|', '\'', '"', '(', ')', '`'};
		for (int k=0; k<=message.size()-1; k++){
			m = message.get(k);
			for (int i = 0; i < m.length(); i++) {
				test = true;
				for (int j =0; j<=punctuation.length-1; j++){
					if (m.charAt(i)==punctuation[j]){
						test = false;
					}
				}
				if (test == true){
					str += m.charAt(i);
				}
			}
			m=str;
		}
	}
	
	public static String removePunctuation(String str) {
		ArrayList<Character> tempList = new ArrayList<Character>();
		char[] punctuation = {',', '.', ';', '/', ':', '|', '\'', '"', '(', ')', '`'};
		for (int j=0; j<=tempList.size()-1; j++){
			for (int i=0; i<=punctuation.length-1; i++ ){
				if (tempList.get(j) == punctuation[i]){
					tempList.remove(j);
					i=punctuation.length-1;
				}
			}
			
		}
		String finalStr="";
		for (char n: tempList){
			finalStr +=n;
		}
		return finalStr;
	}

	public int size() {
		return message.size();
	}

	public String toString(){
		String str="";
		for (String n: message){
			str+=n;
		}
		return str;
	}
	
	public void print(){
		for (String n: message){
			System.out.print(n);
		}
	}

}
