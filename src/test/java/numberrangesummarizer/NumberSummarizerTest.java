package numberrangesummarizer;
/**
 * Rauseenah Upadhey
 * 4/28/2023
 * NumberSummarizerTest
 */

import org.testng.Assert;
import org.testng.annotations.Test;


public class NumberSummarizerTest extends NumberRangeSummarizerImpl {
	/**
	 * Run this for various inputs to be run to check if the code runs correctly
	 */

	@Test
	public void shortStringTest() {
		System.out.println("This input tests if the code can handle lists of size 1.");
		String out = run("1");
		Assert.assertTrue(out.equals("1"));
		System.out.println("Input: 1  Output: " + out);
	}

	@Test
	public void consecutivePairTest() {
		System.out.println("This input tests if the code ignores duplicates in a list of size 2.");
		String out = run("3,3");
		Assert.assertTrue(out.equals("3"));
		System.out.println("Input: 3,3  Output: " + out);
		
		System.out.println("This input tests if the code still includes ranges between consecutive numbers in a list of range 2.");
		String out2 = run("3,4");
		Assert.assertTrue(out2.equals("3-4"));
		System.out.println("Input: 3,4  Output: " + out2);
	}

	@Test
	public void duplicateTest() {
		System.out.println("This input tests if the code ignores duplicates in the middle of the list.");
		String out = run("1,3,3,6,7,7,7,8,12,13,14,15,21,22,23,24,31");
		Assert.assertTrue(out.equals("1, 3, 6-8, 12-15, 21-24, 31"));
		System.out.println("Input: 1,3,3,6,7,7,7,8,8,8,12,13,14,15,21,22,23,24,31  Output: " + out);

		System.out.println("This input tests if the code ignores duplicates at the end of the list.");
		String out2 = run("1,3,3,6,7,8,12,13,14,15,21,22,23,24,31,31,31,32,32");
		Assert.assertTrue(out2.equals("1, 3, 6-8, 12-15, 21-24, 31-32"));
		System.out.println("Input: 1,3,3,6,7,8,12,13,14,15,21,22,23,24,31,31,31,32,32  Output: " + out2);

	}

	@Test
	public void unorderedTest() {
		String out = run("3,3,1,2,10,11,12,25,24,33,26");
		System.out.println("This input tests if the code reorders the list.");
		Assert.assertTrue(out.equals("1-3, 10-12, 24-26, 33"));
		System.out.println("Input: 3,3,1,2,10,11,12,25,24,33,26  Output: " + out);
	}
	@Test
	public void listsWithSpacesTest() {
		String out = run("3, 3,   1,2   ,10,11,12,25,24,33,26");
		System.out.println("This input tests if the code ignores the spaces in the list.");
		Assert.assertTrue(out.equals("1-3, 10-12, 24-26, 33"));
		System.out.println("Input: 3, 3,   1,2   ,10,11,12,25,24,33,26  Output: " + out);
	}
	@Test
	public void listWithLettersTest() {
		String out = run("3, 3,  DFG,DD 1,2   ,10,11,12,25,24,33,26");
		System.out.println("This input tests if the code catches the error in the list with the letters.");
		Assert.assertTrue(out.equals("Error with input!! The input has incorrect format."));
		System.out.println("Input: 3, 3,  DFG,DD 1,2   ,10,11,12,25,24,33,26  Output: " + out);
	}
	@Test
	public void listExtraCommasTest() {
		String out = run("1,,,3,4,2,5,8,10");
		System.out.println("This tests if the code can ignore extra commas in the list.");
		Assert.assertTrue(out.equals("0-5, 8, 10"));
		System.out.println("Input: 1,,,3,4,2,5,8,10  Output: " + out);
	}

}
