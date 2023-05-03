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
import java.util.stream.Collectors;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

	public static String run(String input) {
		NumberRangeSummarizerImpl nrs = new NumberRangeSummarizerImpl();
		try {
			// this removes all the spaces in the string
			input = input.replaceAll(" ", "");
			// This calls on the method that converts the string to a list of integers
			Collection<Integer> collectionInput = (List<Integer>) nrs.collect(input);

			// calls the method to summarize the list as well as returns the results
			return (nrs.summarizeCollection(collectionInput));

		} catch (Exception e) {// This exception catches any cases where the input supplied is valid

			// for example if the input has characters like letters or *&^%$#@!)( and more
			return ("Error with input!! The input has incorrect format or may contain invalid characters.");
		}
	}

	@Override
	public Collection<Integer> collect(String input) {

		String[] array = input.split(",");// Convert the string to an Array

		// checks for empty items in the array and removes them
		array = Arrays.stream(array).filter(x -> !x.isEmpty()).toArray(String[]::new);
		int[] ints = new int[array.length];
		// Saves each item as an integer to the array
		for (int i = 0; i < array.length; i++) {
			ints[i] = Integer.parseInt(array[i]);
		}

		Arrays.sort(ints); // This Sorts the Array in Ascending order
		// converts array to List<Integer> type so that it can be returned
		List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
		return list;
	}

	@Override
	public String summarizeCollection(Collection<Integer> input) {

		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<Integer>(input);
		int length = list.size();

		if (length < 2) {// this checks if the list size is less then 2
			if (length == 0) {
				return "The list of numbers entered is empty.";// If it is empty it returns text.
			}
			return list.get(0).toString();// if it is of size 1 it returns item 1
		}

		int start = 0; // Start keeps track of starting points in ranges
		sb.append(list.get(start));// Add the first item in the list to the string

		for (int x = 1; x < length; x++) {

			// If the number at position x is one more then the previous number
			// or if the number at position x is equal to the previous number it goes into
			// the if statement as it means that it is in x range.
			if (list.get(x - 1) + 1 == list.get(x) || list.get(x - 1) == list.get(x)) {

				// If it is the end and the last number is not equal to the first number in
				// the range then it adds the last number as the end of that range.
				if (length - 1 == x && !(list.get(start) == list.get(x))) {
					sb.append("-" + (Integer) list.get(x));
				}
			}

			else { // if it enters the else the current number is out of the range.
					// If start is greater and the two numbers are different then it adds the end of
					// the range to the string.
				if (start < x - 1 && !(list.get(start) == list.get(x - 1))) {
					sb.append("-" + (Integer) list.get(x - 1) + ", " + list.get(x));
				}
				// if the previous was not a range it adds a comma and adds the number at the
				// current position to the string.
				else {
					sb.append(", " + list.get(x));
				}
				start = x;// sets start to a so the range is being tracked from a new starting point.
			}
		}
		return sb.toString();

	}
}
