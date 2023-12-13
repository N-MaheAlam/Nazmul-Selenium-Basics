import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class Demo_Collection_Framework {

	public static void main(String[] args) {

		// -----------List Start------------------//

		// ---> List<Integer> list = new List<Integer>(); --> List is an interface, so
		// interface can not be initiate

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
	

		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(40);
		l.add(50);
		l.add(60);

		Vector<Integer> v = new Vector<Integer>();
		v.add(70);
		v.add(80);
		v.add(90);

		Stack<Integer> s = new Stack<Integer>();
		s.add(11);
		s.add(22);
		s.add(33);
		s.add(44);

		// how many elements can be stored in current stack print the value of it
		System.out.println(s.capacity());

		// --------------List End------------

		// ------------- Set Start -----------

		// --> Set<Integer> s = new Set<Integer>(); can not be initiate because its an
		// interface

		HashSet<Integer> h = new HashSet<Integer>();

		h.add(9);
		h.add(8);
		h.add(7);
		// ouput -> [7, 8, 9]
		System.out.println(h);

		HashSet<Integer> h2 = new HashSet<Integer>();
		h2.add(5);
		h2.add(6);
		h2.add(7);

		// output-> [5, 6, 7]
		System.out.println(h2);

		// it adds all the value of h into h2 but dont have any duplicate value such as
		// there is only one 7
		// although both h and h2 has 7 but in new h2 there is only ine 7.
		// output->[5,6, 7, 8, 9]
		// Union
		h2.addAll(h);
		System.out.println(h2);

		// it now only has the common value which are present in both h and h2
		// output-> [7, 8, 9]
		// InterSection
		h2.retainAll(h);
		System.out.println(h2);

		// h2.containsAll(h)
		System.out.println(h2.containsAll(h));

		TreeSet<String> t = new TreeSet<String>();
		t.add("N");
		t.add("A");
		t.add("M");
		t.add("D");
		System.out.println(t);
		 // Creating list using the ArrayList class
        List<Integer> numbers = new ArrayList<>();

        // Add elements to the list
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("List: " + numbers);
        

        // Access element from the list
        int number = numbers.get(2);
        System.out.println("Accessed Element: " + number);

        // Remove element from the list
        int removedNumber = numbers.remove(1);
        System.out.println("Removed Element: " + removedNumber);

	}

}
