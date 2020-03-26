package StringMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length()>s2.length()) {
			return s1;
		} else if(s2.length()>s1.length()) {
			return s2;
		}
		return "equal";
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		if(s.contains("underscores")) {
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i)==' ') {
					s = s.substring(0, i) + "_" + s.substring(i+1,s.length());
				}
			}
		}
		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();
		char one = s1.charAt(s1.indexOf(' ')+1);
		char two = s2.charAt(s2.indexOf(' ')+1);
		char three = s3.charAt(s3.indexOf(' ')+1);
		if(one<two && one<three) {
			return s1;
		} else if(two<one && two<three) {
			return s2;
		}
		return s3;
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		s = s.replaceAll("\\D", "");
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			int x = Integer.parseInt(s.substring(i,i+1));
			sum += x;
		}
		return sum;
	}
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int count = 0;
		int ssLength = substring.length();
		for(int i = 0; i < s.length() - ssLength + 1; i++) {
			if(s.substring(i,i+ssLength).equals(substring)) {
				count++;
			}
		}
		return count;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		byte[] a = new byte[s.length()];
		for(int i = 0; i < s.length(); i++) {
			a[i] = (byte) s.charAt(i);
		}
		String encrypted = Utilities.encrypt(a , (byte)key);
		return encrypted;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		String decrypted = Utilities.decrypt(s, (byte)key);
		return decrypted;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int count = 0;
		while(s.length()>0) {
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i)==' ') {
					if(i-substring.length()<0) {
						break;
					}
					if(s.substring(i-substring.length(),i).equals(substring)) { 
							count++;
						
					}
					break;
				}
			}
			if(s.indexOf(' ')!=-1) {
				s = s.substring(s.indexOf(' ') + 1, s.length());
			} else {
				s = "";
				break;
			}
		}
		return count;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int firstOccurIndex = 0;
		int lastOccurIndex = 0;
		for(int i = 0; i <= s.length()-substring.length(); i++) {
			if(s.substring(i, i + substring.length()).equals(substring)) {
				firstOccurIndex = i;
				break;
			}
		}
		
		for(int i = s.length()-substring.length(); i >= 0; i--) {
			if(s.substring(i, i + substring.length()).equals(substring)) {
				lastOccurIndex = i;
				break;
			}
		}
		return lastOccurIndex - firstOccurIndex - substring.length();
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String norm = "";
		String reverse = "";
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i)>=65 && s.charAt(i)<=90) || (s.charAt(i)>=97 && s.charAt(i)<=122)) {
				norm = norm + s.charAt(i);
			}
		}
		for(int i = s.length()-1; i >= 0; i--) {
			if((s.charAt(i)>=65 && s.charAt(i)<=90) || (s.charAt(i)>=97 && s.charAt(i)<=122)) {
				reverse = reverse + s.charAt(i);
			}
		}
		norm = norm.toLowerCase();
		reverse = reverse.toLowerCase();
		System.out.println(norm);
		System.out.println(reverse + "\n");
		if(norm.equals(reverse)) {
			return true;
		}
		return false;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
