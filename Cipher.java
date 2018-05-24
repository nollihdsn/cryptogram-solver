package cyrptogramChallenge;

public class Cipher {
	/* cipher object
	 *  do chars for indvidual get set you know
	 */
	private static char[] cipher = new char[26];

	public Cipher(){
		for (int i = 0; i<26; i++){
			cipher[i]='#';
		}
	}
	// takes array of 26 chars makes string
	public Cipher(char[] array){
		cipher = array;
	}
	
	public Cipher(String str){
		for (int i = 0; i<=25; i++){
			cipher[i] = str.charAt(i);
		}
	}

	public char get(int index){
		return cipher[index];
	}

	public void set(int index, char Char){
		cipher[index]=Char;
	}
	public static boolean worksWith(Cipher cipher_1, Cipher cipher_2){
		for (int i = 0; i<= 26; i++) {
			for (int j = 0; j<= 26; j++) {
				if (cipher_1.get(i)!='#'&&cipher_1.get(i)!=cipher_2.get(j)) { //if the characters....you know what it does
					return false;
				}
			}
		}
		return true;
	}

	public static String decodeCipher(String code, Cipher cipher) {
		String  message = code;
		Cipher abc = new Cipher("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		String solved="";
		//fixing case for greater than alphabet length
		for(int i=0; i<message.length()-1; i++) {
			message.replace(cipher.get(i), abc.get(i));
		}
		return solved;
	}

	public static Cipher combine(Cipher cipher1, Cipher cipher2) throws IllegalArgumentException{
		String finalCipher="";
		if (worksWith(cipher1, cipher2)==false){
			throw new IllegalArgumentException();
		}

		for (int i = 0; i<=25; i++){
			if (cipher1.get(i)!='#'){
				finalCipher+=cipher1.get(i);
			}
			else if(cipher2.get(i)!='#') {
				finalCipher+=cipher2.get(i);
			}
		}
		Cipher result = new Cipher(finalCipher);
		return result;
	}
}


