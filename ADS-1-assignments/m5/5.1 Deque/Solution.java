import java.util.Scanner;

class Node {
	int num;
	Node next;
}
class Deque {
	Node first;
	Node last;
	int size;

	Deque() {
		first = null;
		last = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		// if (size == 0) {
		// 	return true;
		// }
		// return false;
		return first == null;
	}

	public void pushRight(int num1) {
		if (last == null) {
			Node obj = new Node();
			obj.num = num1;
			obj.next = null;
			//first = obj;
		} else {
			Node temp = last;
			Node obj = new Node();
			obj.num = num1;
			obj.next = null;
			temp.next = obj;
		}
		size++;
	}
	public void pushLeft(int num1) {
		if (first == null) {
			Node obj = new Node();
			obj.num = num1;
			obj.next = null;
			last = obj;
		} else {
			Node temp = first;
			Node obj = new Node();
			obj.num = num1;
			//obj.next = null;
			obj.next = temp;
		}
		size++;
	}
	public void popRight() {
		if (last != null) {
			Node temp = first;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
			last = temp;
			size--;
		}
	}
	public void popLeft() {
		if (first != null) {
			first = first.next;
			size--;
		}
	}
	public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String s = "[";
            Node num1 = first;
            while (num1 != null) {
                s += num1.num + ", ";
                num1 = num1.next;
            }
            return s.substring(0, s.length() - 2) + "]";
        }
    }
}

class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ip;
		Deque deq = new Deque();
		ip = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < ip; i++) {
			String[] token = scan.nextLine().split(" ");
			switch (token[0]) {
			case "size":
			System.out.println(deq.size());
			break;
			case "pushRight":
			deq.pushRight(Integer.parseInt(token[1]));
			System.out.println(deq.toString());
			break;
			case "pushLeft":
			deq.pushLeft(Integer.parseInt(token[1]));
			System.out.println(deq.toString());
			break;
			case "popRight":
			if (!deq.isEmpty()) {
				deq.popRight();
				System.out.println(deq.toString());
			} else {
				System.out.println("Deck is empty");
			}
			break;
			case "popLeft":
			if (!deq.isEmpty()) {
				deq.popLeft();
				System.out.println(deq.toString());
			} else {
				System.out.println("Deck is empty");
			}
			break;
			default:
			break;
			}
		}
	}
}