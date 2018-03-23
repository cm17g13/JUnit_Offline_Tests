package code;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		System.out.println(doubleChar("thing"));
		System.out.println(getSandwich("breadthingbread"));
		System.out.println(evenlySpaced(2, 4, 6));
		System.out.println(evenlySpaced(4, 6, 2));
		System.out.println(evenlySpaced(4, 6, 3));
		System.out.println(nTwice("Hello", 2));
		System.out.println(nTwice("Chocolate", 3));
		System.out.println(nTwice("Chocolate", 1));


		System.out.println(stringClean("yyzzza")); //"yza"
		System.out.println(stringClean("abbbcdd")); //"abcd"
//		 stringClean("Hello") "Helo"
		
		
	}
	
	public static String doubleChar(String word) {
		if(word.length() == 1) {
			return word + word;
		}
		String currentLetter = Character.toString(word.charAt(0));
		String restOfWord = word.substring(1);
		return currentLetter + currentLetter + doubleChar(restOfWord);
	}
	
	public static String getSandwich(String input) {
		String sanitized = input.toLowerCase().trim();
		int breadLoc1 = sanitized.indexOf("bread") + "bread".length();
		if(breadLoc1 != -1) {
			if(sanitized.substring(breadLoc1).contains("bread")) {
				return sanitized.substring(breadLoc1, sanitized.indexOf("bread", breadLoc1));
			}
		}
		return "";
	}

	public static boolean evenlySpaced(int a, int b, int c) {
		int[] numbers = {a, b, c};
		Arrays.sort(numbers);
		if(((2*numbers[1]) - numbers[0]) == numbers[2]) {
			return true;
		}
		return false;
	}
	
	public static String nTwice(String input, int a) {
		char[] output = new char[a*2];
		input.getChars(0, a, output, 0);
		input.getChars(input.length() - a, input.length(), output, a);
		return String.valueOf(output);
	}
	

	public static String stringClean(String input) {
		if(input.length() == 1) {
			return input;
		} 
		String currentLetter = Character.toString(input.charAt(0));
		String nextLetter = Character.toString(input.charAt(1));
		if(currentLetter.equals(nextLetter)) {
			return stringClean(input.substring(1));
		} else {
			return currentLetter + stringClean(input.substring(1));
		}
		
	}

}
