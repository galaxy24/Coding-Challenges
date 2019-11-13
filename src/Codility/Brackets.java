package Codility;

import java.util.Stack;

public class Brackets {
//	A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
//
//	S is empty;
//	S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
//	S has the form "VW" where V and W are properly nested strings.
//	For example, the string "{[()()]}" is properly nested but "([)()]" is not.
//
//	Write a function:
//
//	class Solution { public int solution(String S); }
//
//	that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
//
//	For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
//
//	Write an efficient algorithm for the following assumptions:
//
//	N is an integer within the range [0..200,000];
//	string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".

	public static int solution(String S) {
		System.err.println(S);
		Stack<Character> brackets = new Stack<>();
		char[] string = S.toCharArray();
		for (int i = 0; i < string.length; i++) {
			if      (string[i] == '{') brackets.push('{');
			else if (string[i] == '[') brackets.push('[');
			else if (string[i] == '(') brackets.push('(');
			else if (string[i] == '}' || string[i] == ']' || string[i] == ')' && brackets.isEmpty()) return 0;
			else if (string[i] == '}') {if (brackets.pop() != '{') return 0;}
			else if (string[i] == ']') {if (brackets.pop() != '[') return 0;}
			else if (string[i] == ')') {if (brackets.pop() != '(') return 0;}
		}
		return (brackets.size() == 0 ? 1 : 0);
	}

	public static void main(String[] args) {
		String S = "{[()()]}";
		System.out.println(solution(S));
		// doesn't work
	}
}