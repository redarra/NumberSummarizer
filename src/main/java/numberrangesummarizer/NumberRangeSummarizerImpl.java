package numberrangesummarizer;

/*
 * Rauseenah Upadhey
 * 4/28/2023
 * NumberRangeSummarizerImpl
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

	public static String run(String input) {
		NumberRangeSummarizerImpl nrs = new NumberRangeSummarizerImpl();
		try {

			// this removes all the spaces in the string so that the code can run
			input = input.replaceAll(" ", "");

			// this checks if the input list size is less then 2 and if it is then it
			// returns that number
			if (!input.contains(",")) {
				return (input.toString());
			} else {
				// This calls on the method that converts the string to a list of integers
				Collection<Integer> collectionInput = (List<Integer>) nrs.collect(input);

				// calls the method to summarize the list as well as returns the results
				return (nrs.summarizeCollection(collectionInput));
			}
		} catch (Exception e) {
			// This exception catches any cases where the input supplied is valid
			// for example if it has letters or special characters in it or if there is more
			// then one comma.
			return ("Error with input!! The input has incorrect format.");
		}
	}

	@Override
	public Collection<Integer> collect(String input) {
		// Convert the string to an Array
		String[] array = input.split(",");
		int[] ints = new int[array.length];
		//checks for empty items in the array and removes them
		array=Arrays.stream(array)
				.filter(x -> !x.isEmpty())
				.toArray(String[]::new);
		// Saves each item as an integer to the array
		for (int i = 0; i < array.length; i++) {
			//if(array[i]=="")
			ints[i] = Integer.parseInt(array[i]);
		}

		// This Sorts the Array in Ascending order
		Arrays.sort(ints);
		// converts array to List<Integer> type so that it can be returned
		List<Integer> list = Arrays.stream(ints).boxed().toList();
		return list;
	}

	@Override
	public String summarizeCollection(Collection<Integer> input) {

		StringBuilder sb = new StringBuilder();

		ArrayList<Integer> inputList = new ArrayList<Integer>(input);
		int length = inputList.size();
		// Start keeps track of starting points in ranges
		// this allows for the correct ranges to be added.
		int start = 0;
		// Add the first item in the list to the string
		sb.append(inputList.get(start));
		for (int a = 1; a < length; a++) {

			// if the number at position a is one more then the number the previous number
			// or if the number at position a is equal to the previous number it goes into
			// the if statement as it means that it is in a range.
			if (inputList.get(a - 1) + 1 == inputList.get(a) || inputList.get(a - 1) == inputList.get(a)) {

				// if it is the end and the last number is not equal to the first number in
				// the range then it adds the last number as the end of that range.
				if (length - 1 == a && !(inputList.get(start) == inputList.get(a))) {
					sb.append("-" + (Integer) inputList.get(a));
				}
			}

			else {
				// when it enters the else statement it means number at position a is out of the
				// range.
				// if start is greater and the two numbers are different then it adds the end of
				// the range to the string.
				if (start < a - 1 && !(inputList.get(start) == inputList.get(a - 1))) {
					sb.append("-" + (Integer) inputList.get(a - 1) + ", " + inputList.get(a));
				}
				// if the previous was not a range it adds a comma and adds the number at the
				// current position to the string.
				else {
					sb.append(", " + inputList.get(a));
				}
				// sets start to a so the range is being tracked from a new starting point.
				start = a;
			}

		}

		return sb.toString();
	}

}
