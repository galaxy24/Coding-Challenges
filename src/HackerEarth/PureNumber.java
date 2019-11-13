package HackerEarth;

import java.util.*;

public class PureNumber {
//	You are given a special set of pure numbers.
//
//	A pure number has the following properties:
//
//	It comprises only 4 and 5.
//	It is a palindrome number.
//	The number of digits in a pure number is even.
//	For example, 4444, 5445, 44 are the pure numbers while 12, 444, 4545 are not. You have to generate a list of pure
//	numbers in an ascending order. So, pureNumber[1] < pureNumber[2].
//
//	The first few elements in the list are as follows: 44, 55, 4444,...
//
//	You will be given an integer N and you have to find Nth pure number from the generated list.
//
//
//  Input format
//
//	First line: T denoting the number of test cases
//	Next T lines: A number N
//
//
//
//
//	Output format
//
//	Print the Nth pure number.
//
//			Constraints
//          1≤T≤10^6
//			1≤N≤10^6
//
//
//
//	How to win:
//
//	Make the shortest possible working solution, where the participant with the lowest character count wins.
//
//	Only the function given a single input N is measured
//	The signature of the function also counts
//	Defining sub-functions is allowed, but these will be included in the character-count

	List<Integer> pures;

	public PureNumber(){
		Set<Integer> pureSet = new TreeSet<>();
		Random r = new Random();
		do {
			int n = r.nextInt(Integer.MAX_VALUE);
			if (isPure(n)) {
				pureSet.add(n);
				System.out.println("just added " + n + " to the list");
			}
		} while (pureSet.size() < 1_000);
		pures.addAll(pureSet);
	}

	public int NthEntry(int N){ return pures.get(N); }


	// this works:
	private static boolean isPure(int N) {
		char[] n = String.valueOf(N).toCharArray();
		if (n.length % 2 != 0) return false;
		else {
			for (int i = 0; i < n.length/2; i++) {
				char c = n[i];
				if (!(c == '4' || c == '5')) return false;
				if (n[i] != n[n.length-i-1]) return false;
			}
		}
		return true;
	}

	public static String[] getAllLists(String[] elements, int lengthOfList)	{

		//lists of length 1 are just the original elements
		if(lengthOfList == 1) return elements;
		else {
			//initialize our returned list with the number of elements calculated above
			String[] allLists = new String[(int)Math.pow(elements.length, lengthOfList)];

			//the recursion--get all lists of length 3, length 2, all the way up to 1
			String[] allSublists = getAllLists(elements, lengthOfList - 1);

			//append the sublists to each element
			int arrayIndex = 0;

			for(int i = 0; i < elements.length; i++){
				for(int j = 0; j < allSublists.length; j++){
					//add the newly appended combination to the list
					allLists[arrayIndex] = elements[i] + allSublists[j];
					arrayIndex++;
				}
			}
			return allLists;
		}
	}



	public static void main(String[] args) {
		PureNumber n = new PureNumber();
		System.out.println(n.NthEntry(10));
		int[] T = {44, 4444, 12, 444, 4545};
//		int debug = 54554528;
//		System.out.println(isPure(54554528));

	}
}