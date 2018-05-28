package cryptography;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ceaserCipherSolver {
	ArrayList<Cipher> cipherList = new ArrayList<Cipher>();
	public static void main(String[] args) throws FileNotFoundException{
		Message messageList = new Message(2);//makes new message with default test
		String message = messageList.toString();//make tostring
		System.out.println(message);
		ArrayList<Message> options = new ArrayList<Message>();
		for (int i =1; i<=26; i++){
			options.add(new Message(encode(message, i)));
		}
		for (Message m: options){
			m.print();
			System.out.println("");
		}
	}
	public static String encode(String message, int rotation) {
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		String codemessage="";
		//fixing case for greater than alphabet length
		while (rotation>25){
			rotation=rotation-26;
		}
		for(int i=0; i<message.length(); i++) {
			String messageLower=message.toLowerCase();
			char letter=messageLower.charAt(i); //picks next letter
			if (letter==" ".charAt(0)) {
				codemessage=codemessage+" ";
				continue;
			}
			int letterIndex = alphabet.indexOf(letter);
			if (letterIndex==-1) {
				throw new IllegalArgumentException("Only letters a-z and whitespace accepted.");
			}
			int y=alphabet.indexOf(letter)+rotation; //position of coded letter
			while (y>26) {
				y=y-26;
			}

			char codeletter=alphabet.charAt(y); //converts letter to code letter based on rotation
			codemessage=codemessage+codeletter;
		}
		System.out.println(codemessage.toUpperCase());
		return codemessage.toUpperCase();
	}



}

