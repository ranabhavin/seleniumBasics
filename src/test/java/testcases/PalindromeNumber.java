package testcases;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String args[]) {

		String original, reverse = "";

		Scanner in = new Scanner(System.in);
		System.out.println("Ënter a Palindrome Number");
		original = in.nextLine();

		int length = original.length();

		for (int i = length - 1; i >= 0; i--) {

			reverse = reverse + original.charAt(i);

		}
		if (original.equals(reverse)) {

			System.out.println("Paliindorme");
		} else {

			System.out.println("Not Palindrome");
		}

	}

}
