package testcases;

public class SumOf100 {

	public static int sum = 0;

	public static void main(String args[]) {

		for (int i = 0; i <= 100; i++) {

			sum = sum + i;

		}

		System.out.println("sum " + sum);

	}

}
