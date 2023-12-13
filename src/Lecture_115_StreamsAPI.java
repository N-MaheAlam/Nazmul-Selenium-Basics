import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Streams;

public class Lecture_115_StreamsAPI {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Apple");
		names.add("Alam");
		names.add("Naz");
		names.add("Mahe");
		names.add("Alex");
		names.add("Adam");
		names.add("Rahman");
		int k = 0;

		// iterating through each elements
		for (int i = 0; i < names.size(); i++) {
			// int k = 0;
			String actualName = names.get(i);

			// if the name start with "A" then increase k value each time one
			if (actualName.startsWith("A")) {
				k++;
			}

		} // for loop

		System.out.println("=====1========\n");
		// print total number of names start with A
		System.out.println("Total " + k + " names");

		// Doing the same above function by using stream API
		// first, pass the arraylist into the stream, then filter with action where the
		// action is if name start with "A"
		// now hold the value in count. here count works as a terminal I mean final
		// action
		Integer nameWithStream = (int) names.stream().filter(name -> name.startsWith("A")).count();
		System.out.println();
		System.out.println("=====2========\n");
		// now print
		System.out.println("With Stream it is also " + nameWithStream + " times");
		System.out.println();
		System.out.println("=====3========\n");
		// printing all the values in arraylist using foreach loop via lambda expression
		names.forEach(name -> System.out.print(name + ", "));
		System.out.println("\n");

		System.out.println("=====4========\n");
		System.out.println("Names which have 5 or more than 5 letters ");
		// pass name through the stream, then filter with the condition where length is
		// 5 or more than 5,
		// then print those names
		names.stream().filter(name -> name.length() >= 5).forEach(na -> System.out.println(na));
		System.out.println();
		System.out.println("=====5========\n");

		// Create stream of name, filter the string which ends with "mul".
		// now use the map to make uppercase of every string from filters
		// now print the values
		System.out.println("=====6========\n");
		System.out.println("-- Name ends with mul---");
		Stream.of("Nazmul", "Manmul", "Zanmul", "Alam", "Rabbi").filter(name -> name.endsWith("mul"))
				.map(n -> n.toUpperCase()).forEach(z -> System.out.print(z + ", "));
		System.out.println();

		String[] array1 = { "Nazmul", "Alam", "Adam", "Azam", "Abhi" };

		// converting an array to list
		List<String> listOfarray1 = Arrays.asList(array1);
		

		System.out.println("=====7========\n");
		System.out.println("\nMaking array to List and printing string starts with 'A' and upper case");

		// passing array into stream, filtering by string start with "A"(case
		// sensitive),sorting that
		// using map now uppercasing every string then print
		listOfarray1.stream().filter(a -> a.startsWith("A")).sorted().map(m -> m.toUpperCase())
				.forEach(f -> System.out.print(f + ", "));
		System.out.println();
		System.out.println();

		// making one List and one ArrayList into streams then, concatenating two
		// streams into one,
		// now only adding distinct (both list has Alam and Adam one taking one adam and
		// one alam)
		// value in new stream then printing the values
		Stream<String> conCatStream = Streams.concat(names.stream(), listOfarray1.stream()).distinct();

		System.out.println("=====8========\n");
		System.out.println();
		conCatStream.forEach(s -> System.out.print(s + ", "));
		System.out.println();
		List<Integer> list2 = Arrays.asList(50, 20, 10, 90, 20, 30, 10, 50);

		List<Integer> newList = list2.stream().distinct().sorted().collect(Collectors.toList());

		Integer max = Collections.max(newList);

		newList.forEach(nam -> System.out.print(nam + ", "));
		// System.out.println(newList.lastIndexOf(newList));

	} // Main method

}
