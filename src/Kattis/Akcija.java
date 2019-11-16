import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Akcija {

	/**
	 * https://open.kattis.com/problems/akcija
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int noOfBoughtBooks = scanner.nextInt();
		ArrayList<Integer> bookPrices = new ArrayList<>();
		ArrayList<Integer> booksToPay = new ArrayList<>();
		int price = 0;

		for (int i = 0; i < noOfBoughtBooks; i++){
			bookPrices.add(scanner.nextInt());
		}

		while (bookPrices.size() > 2){
			booksToPay.add(Collections.max(bookPrices));
			bookPrices.remove(bookPrices.indexOf(Collections.max(bookPrices)));
			booksToPay.add(Collections.max(bookPrices));
			bookPrices.remove(bookPrices.indexOf(Collections.max(bookPrices)));
			bookPrices.remove(bookPrices.indexOf(Collections.max(bookPrices)));
		}

		if (bookPrices.size() != 0){
			for (int i = 0; i < bookPrices.size(); i++){
				booksToPay.add(bookPrices.get(i));
				bookPrices.remove(i);
			}
		}

		for (int i = 0; i < booksToPay.size(); i++) {
			price = price + booksToPay.get(i);
		}

		System.out.println(price);
	}
}