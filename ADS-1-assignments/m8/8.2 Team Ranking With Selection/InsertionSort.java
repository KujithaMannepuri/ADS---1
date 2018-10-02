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

class InsertionSort {
	Team[] obj;
	int size;
	InsertionSort() {
		obj = new Team[20];
		size = 0;
	}
	void add(Team o){
		obj[size++] = o;
	}
	boolean less(Team[] obj, int i, int j) {
		return obj[i].compareTo(obj[j]) > 0;
	}
	void sorting() {
		int min;
		for (int i = 0; i < size; i++) {
			// Team temp = obj[i];
			// int j = 0;
			for (int j = i + 1; j < 0; j++) {
				if (less(obj, j - 1, j)) {
					// obj[j + 1] = obj[j];
					// j -= 1;
					Team temp = obj[j-1];
					obj[j-1] = obj[j];
					obj[j] = temp;
				}
			}
			//obj[j + 1] = temp;
		}
	}
	void tostring() {
		for (int i = 0; i < size - 1; i++) {
            System.out.print(obj[i].getName() + ",");
        }
        System.out.print(obj[size - 1].getName());
    
	}
}