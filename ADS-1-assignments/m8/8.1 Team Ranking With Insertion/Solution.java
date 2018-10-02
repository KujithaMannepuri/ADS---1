import java.util.Scanner;

class Team implements Comparable<Team> {
	private String teamName;
	int wins;
	int losses;
	int draws;
	Team(String tName, int w, int l, int d) {
		this.teamName = tName;
		this.wins = w;
		this.losses = l;
		this.draws = d;
	}
	public String getName(){
		return teamName;
	}
	public int compareTo(Team game) {
		if (this.wins > game.wins) {
			return 1;
		}
		if (this.wins < game.wins) {
			return -1;
		}
		if (this.losses > game.losses) {
			return -1;
		}
		if (this.losses < game.losses) {
			return 1;
		}
		if (this.draws > game.draws) {
			return 1;
		}
		if (this.draws < game.draws) {
			return -1;
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
		for (int i = 0; i < size; i++) {
			min = i;
			for (int j = i + 1; j < size; j++) {
				if (obj[j].compareTo(obj[min]) > 0) {
					min = j;	
				}
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
			Team games = new Team(token[0], Integer.parseInt(token[1]),
				Integer.parseInt(token[2]), Integer.parseInt(token[3]));
			ip.add(games);
		}
		ip.sorting();
		ip.tostring();
	}
}