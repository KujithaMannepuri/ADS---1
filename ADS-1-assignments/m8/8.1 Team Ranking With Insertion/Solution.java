import java.util.Scanner;

class Team implements Comparable<Team> {
	private String teamName;
	String wins;
	String losses;
	String draws;
	Team(String tName, String w, String l, String d) {
		this.teamName = tName;
		this.wins = w;
		this.losses = l;
		this.draws = d;
	}
	public String getName(){
		return teamName;
	}
	public int compareTo(Team game) {
		if (this.wins.compareTo(game.wins) < 0) {
			return 1;
		}
		if (this.losses.compareTo(game.losses) < 0) {
			return -1;
		}
		if (this.draws.compareTo(game.draws) < 0) {
			return 1;
		}
		return 0;
	}

}

class SelectionSort {
	Team[] obj;
	int size;
	SelectionSort() {
		obj = new Team[20];
		size = 0;
	}
	void add(Team o){
		obj[size++] = o;
	}
	void sorting() {
		int min;
		for (int i = 0; i < size-1; i++) {
			min = i;
			for (int j = i + 1; j < size; j++) {
				if (obj[j].compareTo(obj[min]) > 0) {
					min = j;
					// System.out.println("min is "+min);
				}
				//System.out.println("min is "+min);
			}

			Team temp = obj[min];
			obj[min] = obj[i];
			obj[i] = temp;
		}
	}
	void tostring() {
		for (int i = 0; i < size - 1; i++) {
            System.out.print(obj[i].getName() + ",");
        }
        System.out.print(obj[size - 1].getName());
    
	}

}
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SelectionSort ip = new SelectionSort();
		while (sc.hasNext()) {
			String[] token = sc.nextLine().split(",");
			Team games = new Team(token[0], token[1],
				token[2], token[3]);
			ip.add(games);
		}
		ip.sorting();
		ip.tostring();
	}
}