package numberrangesummarizer;

import java.util.Scanner;

/*
 * Rauseenah Upadhey
 * 4/28/2023
 * NumberSummarizerApp
*/

public class NumberSummarizerApp extends NumberRangeSummarizerImpl {

	// run this for a default input
	public static void main(String[] args) {
		// asks user if they want the default input or to enter their own input
		System.out.println("Enter the D for default input or C for customized input");
		Scanner sc = new Scanner(System.in);
		String i = sc.nextLine();
		// checks if they want the default
		if (i.equals("D")) {
			System.out.println("3,3,1,2,10,11,12,25,24,33,26");
			System.out.println(run("3,3,1,2,10,11,12,25,24,33,26"));
		} else {
			// asks for customized input
			System.out.println("Please enter integer array separated by commas as input:");
			String input = sc.nextLine();
			System.out.println(run(input));
		}
		sc.close();
	}

}
