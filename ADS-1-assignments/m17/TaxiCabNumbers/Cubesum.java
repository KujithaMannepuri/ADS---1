class Cubesum implements Comparable<Cubesum> {
    int i,j;
    long sum;
    public Cubesum(int i, int j) {
        this.sum = (long) i * i * i + (long) j * j * j;
        this.i = i;
        this.j = j;
    }
    public int compareTo(Cubesum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        else if (this.sum > that.sum) {
            return +1;
        } else {
            return  0;
        }
    }
    public String toString() {
        return i + "^3 + " + j + "^3";
    }
}