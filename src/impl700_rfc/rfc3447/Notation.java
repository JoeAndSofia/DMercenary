package impl700_rfc.rfc3447;

public class Notation {

	/**
	 * ciphertext representative, an integer between 0 and n-1
	 */
	public int c;
	
	/**
	 * ciphertext, an octet string
	 */
	public String C;
	
	/**
	 * RSA private exponent
	 */
	public int d;
	
	/**
	 * additional factor r_i's CRT exponent, a positive integer such that<br>
	 * e * d_i == 1 (mod (r_i-1)), i = 3, ..., u
	 */
	public int d_i;
	
	/**
	 * p's CRT exponent, a positive integer such that
	 * e * dP == 1 (mod (p-1))
	 */
	public int dP;
	
	/**
	 * q's CRT exponent, a positive integer such that
	 * e * dQ == 1 (mod (q-1))
	 */
	public int dQ;
	
	/**
	 * RSA public exponent
	 */
	public int e;
	
	/**
	 * encoded message, an octet string
	 */
	public String EM;
	
	/**
	 * (intended) length in bits of an encoded message EM
	 */
	public int emBits;
	
	/**
	 * (intended) length in octets of an encoded message EM
	 */
	public int emLen;
	
	/**
	 * greatest common divisor of two nonnegative integers
	 * @param a
	 * @param b
	 * @return
	 */
	public int GCD(int a, int b){
		int temp;
		if(a<b){
			temp = a;
			a = b;
			b = temp;
		}
		
		if((temp = a % b) == 0){
			return b;
		}else{
			return GCD(b, temp);
		}
	}
	
	
	
	
	public String Hash(String param){
		return null;
	}
}
