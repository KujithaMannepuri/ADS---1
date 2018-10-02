import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SelectionSort ip = new SelectionSort();
		while (sc.hasNext()) {
			String[] token = sc.nextLine().split(",");
			Team games = new Team(token[0], Integer.parseInt(token[1]),
				Integer.parseInt(token[2]), Integer.parseInt(token[3]));
			ip.add(games);
		}
		ip.sorting();
		ip.tostring();
	}
}