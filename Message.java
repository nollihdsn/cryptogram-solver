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
    private static final String testCipher = "DJMLWK YNIS DJSM NW ZTO PNSRF LG TJSF. LH LZ POSO OJGY, OVOSYENFY PNIRF FN LZ. EIZ LZ’G WNZ. LZ ZJMOG BJZLOWCO, LZ ZJMOG CNDDLZDOWZ, JWF LZ CNDOG PLZT BROWZY NH HJLRISO JRNWK ZTO PJY. ZTO SOJR ZOGZ LG WNZ PTOZTOS YNI JVNLF ZTLG HJLRISO, EOCJIGO YNI PNW’Z. LZ’G PTOZTOS YNI ROZ LZ TJSFOW NS GTJDO YNI LWZN LWJCZLNW, NS PTOZTOS YNI ROJSW HSND LZ; PTOZTOS YNI CTNNGO ZN BOSGOVOSO.";
	private Scanner console;
	private static String originalCipher= "";
	
	public Message(String m){
		originalCipher=m;
		message = new ArrayList<String>(Arrays.asList(m.split(" ")));
		removePunctuation();
	}
	
	public void message(String m){
		originalCipher=m;
		message = new ArrayList<String>(Arrays.asList(m.split(" ")));
		removePunctuation();
	}

	// appropriatly constructs based on int option
	public Message(int option) throws FileNotFoundException{
		//option one reads from console
		if (option==1){
			console = new Scanner (System.in);
			System.out.println("input cipher, you idiot: ");
			while (console.hasNextLine()){
				String line = console.nextLine();
			message.add(line);
			originalCipher+=(line);
			}
		}
		//options 2 uses test cipher
		if (option==2){
			originalCipher=testCipher;
			message = new ArrayList<String>(Arrays.asList(testCipher.split(" ")));
		}
		//option 3 reads from file
		if (option==3){
			String m = cyptogramFromFile();
			originalCipher=m;
			message = new ArrayList<String>(Arrays.asList(m.split(" ")));
			removePunctuation();

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

	public static ArrayList<String> get() {
		return message;
	}

	public static String getOriginal(){
		return originalCipher;
	}
	public static void set(ArrayList<String> message) {
		Message.message = message;
	}

	public static void removePunctuation() {
		boolean test;
		String str = "";
		char[] punctuation = {',', '.', ';', '/', ':', '|', '\'', '"', '(', ')', '`'};
		for (String m: message){
			for (int i = 0; i < m.length(); i++) {
				test = true;
				for (int j =0; j<=punctuation.length; j++){
					if (m.charAt(i)==punctuation[j]){
						test = false;
					}
				}
				if (test == true){
					str += m.charAt(i);
				}
			}
			m = str;
		}
	}

}
