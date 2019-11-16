package LeetCode;

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
// order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//		You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//		Example:
//
//		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//		Output: 7 -> 0 -> 8
//		Explanation: 342 + 465 = 807.

import java.math.BigInteger;

class AddTwoNumbers{

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) { return createLinkedListFromInt(getNumberFromList(l1).add(getNumberFromList(l2)));	}

	private static BigInteger getNumberFromList(ListNode l) {
		StringBuilder res = new StringBuilder();
		while (l != null) {
			res.insert(0, l.val);
			l = l.next;
		}

		return new BigInteger(res.toString());
	}

	private static ListNode createLinkedListFromInt(BigInteger N){
		char[] aux = (new StringBuilder("" + N)).reverse().toString().toCharArray();
		ListNode res = new ListNode(Character.getNumericValue(aux[0]));
		ListNode curr = res;
		for (int i = 1; i < aux.length; i++) {
			ListNode newNode = new ListNode(Character.getNumericValue(aux[i]));
			curr.next = newNode;
			curr = curr.next;
		}
		return res;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(2);
		l.next = new ListNode(4);
		l.next.next = new ListNode(3);
		System.out.println(getNumberFromList(l));
		System.out.println(getNumberFromList(createLinkedListFromInt(new BigInteger("342"))).equals(new BigInteger("342")));

		// works

	}

}
