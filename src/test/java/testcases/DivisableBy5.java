package testcases;

public class DivisableBy5 {
	
	/*
	 * String name = "Bhavin Kumar"; name = "Bhavin Rana";
	 */
	public static void main(String args[]) {

		for(int i=1;i<=100;i++) {
			
			if(i%5==0) {
				
				System.out.println(i+" divisable by 5");
			}
			else {
				
				System.out.println(i);
			}
			
		}
		
	}
}
