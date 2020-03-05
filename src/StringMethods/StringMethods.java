package StringMethods;

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
		char one = ' ';
		char two = ' ';
		char three = ' ';
		
		s1 = s1.trim();
		for(int i = 0; i < s1.length(); i++) {
			for(int j = s1.length()-1; j > 0; j++) {
				if(s1.charAt(i)!=' ' && s1.charAt(j)!=' ') {
					s1 = s1.substring(i, j+1);
					one = s1.charAt(s1.indexOf(' ')+1);
					System.out.println(one);
					break;
				}
			}
		}
		
		for(int i = 0; i < s2.length(); i++) {
			for(int j = s2.length()-1; j > 0; j++) {
				if(s2.charAt(i)!=' ' && s2.charAt(j)!=' ') {
					s2 = s2.substring(i, j+1);
					two = s2.charAt(s2.indexOf(' ')+1);
					System.out.println(two);
					break;
				}
			}
		}
		for(int i = 0; i < s3.length(); i++) {
			for(int j = s3.length()-1; j > 0; j++) {
				if(s3.charAt(i)!=' ' && s3.charAt(j)!=' ') {
					s3 = s3.substring(i, j+1);
					three = s3.charAt(s3.indexOf(' ')+1);
					System.out.println(three+"\n");
					break;
				}
			}
		}
		
		if(one<two && one<three) {
			System.out.println(s1);
			return s1;
		} 
		if(two<one && two<three) {
			System.out.println(s2);
			return s2;
		} 
		if(three<one && three<two) {
			System.out.println(s3);
			return s3;
		}

		return "";
		
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		return 0;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		return 0;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		return null;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return null;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		return 0;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		return 0;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
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
