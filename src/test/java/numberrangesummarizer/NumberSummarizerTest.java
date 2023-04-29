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
	public void emptyListTest() {
		System.out.println("Test 1: Empty List Test");
		System.out.println("This tests with an empty list as input.");
		String out = run("");
		System.out.println("Input: 1  Output: " + out + "\n");
		Assert.assertTrue(out.equals("The list of numbers entered is empty."));

	}

	@Test
	public void shortStringTest() {
		System.out.println("Test 2: Short String Test");
		System.out.println("This tests if the code can handle lists of size 1.");
		String out = run("1");
		System.out.println("Input: 1  Output: " + out + "\n");
		Assert.assertTrue(out.equals("1"));
	}

	@Test
	public void emptyListWithCommasTest() {
		System.out.println("Test 3: Empty List With Commas Test");
		System.out.println("This tests a list containing spaces & commas only.");
		String out = run(" , ,,");
		System.out.println("Input: 1  Output: " + out + "\n");
		Assert.assertTrue(out.equals("The list of numbers entered is empty."));
	}

	@Test
	public void listWith1ItemCommasTest() {
		System.out.println("Test 4: List With 1 Item & Commas Test");
		System.out.println("This tests if the code can handle lists of size 1 with commas & spaces.");
		String out = run(",  , 1,");
		System.out.println("Input: 1  Output: " + out + "\n");
		Assert.assertTrue(out.equals("1"));
	}

	@Test
	public void consecutivePairTest() {
		System.out.println("Test 5: Consecutive Pair Test");
		System.out.println("This tests if the code ignores duplicates in a list of size 2.");
		String out = run("3,3");
		System.out.println("Input: 3,3  Output: " + out + "\n");
		Assert.assertTrue(out.equals("3"));

		System.out.println("This tests if the code still includes ranges of only 2 numbers.");
		String out2 = run("3,4");
		System.out.println("Input: 3,4  Output: " + out2 + "\n");
		Assert.assertTrue(out2.equals("3-4"));
	}

	@Test
	public void duplicateTest() {
		System.out.println("Test 6: Duplicate Test");
		System.out.println("This tests if the code ignores duplicates in the middle of the list.");
		String out = run("1,3,3,6,7,7,7,8,12,13,14,15,21,22,23,24,31");
		System.out.println("Input: 1,3,3,6,7,7,7,8,8,8,12,13,14,15,21,22,23,24,31  Output: " + out + "\n");
		Assert.assertTrue(out.equals("1, 3, 6-8, 12-15, 21-24, 31"));

		System.out.println("This tests if the code ignores duplicates at the end of the list.");
		String out2 = run("1,3,3,6,7,8,12,13,14,15,21,22,23,24,31,31,31,32,32");
		System.out.println("Input: 1,3,3,6,7,8,12,13,14,15,21,22,23,24,31,31,31,32,32  Output: " + out2 + "\n");
		Assert.assertTrue(out2.equals("1, 3, 6-8, 12-15, 21-24, 31-32"));

	}

	@Test
	public void unorderedTest() {
		System.out.println("Test 7: Unordered Test");
		String out = run("3,3,1,2,10,11,12,25,24,33,26");
		System.out.println("This tests if the code reorders the list.");
		System.out.println("Input: 3,3,1,2,10,11,12,25,24,33,26  Output: " + out + "\n");
		Assert.assertTrue(out.equals("1-3, 10-12, 24-26, 33"));
	}

	@Test
	public void listsWithSpacesTest() {
		System.out.println("Test 8: Lists With Spaces Test");
		String out = run("3, 3,   1,2   ,10,11,12,25,24,33,26");
		System.out.println("This tests if the code ignores input with spaces in it.");
		System.out.println("Input: 3, 3,   1,2   ,10,11,12,25,24,33,26  Output: " + out + "\n");
		Assert.assertTrue(out.equals("1-3, 10-12, 24-26, 33"));
	}

	@Test
	public void listWithLettersTest() {
		System.out.println("Test 9: List With Letters Test");
		String out = run("3, 3,  DFG,DD 1,2   ,10,11,12,25,24,33,26");
		System.out.println("This tests if the error message shows for input with letters.");
		System.out.println("Input: 3, 3,  DFG,DD 1,2   ,10,11,12,25,24,33,26  Output: " + out + "\n");
		Assert.assertTrue(
				out.equals("Error with input!! The input has incorrect format or may contain invalid characters."));
	}

	@Test
	public void listExtraCommasTest() {
		System.out.println("Test 10: List Extra Commas Test");
		String out = run("1,,,3,4,2,5,8,10");
		System.out.println("This tests if the code can ignore extra commas in the list.");
		System.out.println("Input: 1,,,3,4,2,5,8,10  Output: " + out + "\n");
		Assert.assertTrue(out.equals("1-5, 8, 10"));
	}

}
