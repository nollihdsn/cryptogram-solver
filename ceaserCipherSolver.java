package cryptography;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ceaserCipherSolver {
	ArrayList<Cipher> cipherList = new ArrayList<Cipher>();
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("main");

		//Message messageList = new Message(2);//makes new message with default test
		//String message = messageList.toString();//make tostring
		String message = "EPMZM TWDM ZCTMA, BPMZM QA VW EQTT BW XWEMZ; IVL EPMZM XWEMZ XZMLWUQVIBMA, BPMZM TWDM QA TIKSQVO. BPM WVM QA BPM APILWE WN BPM WBPMZ.";
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
		System.out.println(message);
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		String codeMessage="";
		//fixing case for greater than alphabet length
		while (rotation>25){
			rotation=rotation-26;
		}
		for(int i=0; i<message.length(); i++) {
			message=message.toLowerCase();
			char letter=message.charAt(i); //picks next letter

			if (letter==' ') {
				codeMessage+=' ';
			}

			int codeIndex=alphabet.indexOf(letter)+rotation;
			while (codeIndex>25){
				codeIndex=codeIndex-26;
			}
			codeMessage+=alphabet.charAt(codeIndex); //adds letter at the encoded letter


		}
		System.out.println(codeMessage.toUpperCase());

		return codeMessage;
	}
}





