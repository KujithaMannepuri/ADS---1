import java.util.Scanner;
class Node{
	String data;
	Node next;
	Node() {

	}
	Node(String item){
		this.data = item;
	}
}
class linkedList {
	Node first;
	Node last;
	int size;
	linkedList() {
		first = new Node();
		last = new Node();
		size = 0;
	}
	void insert(String item) {
		Node obj = new Node();
		obj.data = item;
		if (size == 0) {
			first = obj;
			last = obj;
			size++;
			return;
		}
		obj.next = first;
		first = obj;
		size++;

	}
	String delete() throws Exception {
		if(size() == 0){
			//try{
			throw new Exception("Steque is empty.");
			//}
			// catch(Exception e){
			// 	System.out.println("sdfasdgds");
			// 	return null;
			// }
		}
		String data = first.data;
		first = first.next;
		size--;
		return data;
	}
	void enque(String item) {
		//Node obj = new Node(item);
		if(size == 0) {
		 	last.data = item;
		 	last.next = null;
		 	first = last;
		// 	last = obj;
		 	size++;
		 	return;
		 } else {
		 	Node obj = new Node(item);
		 	// obj.data = item;
		 	// obj.next = null;
		 	last.next = obj;
		 	last = obj;
		 	//System.out.println("enque");
		 }
		size++;
	}
	boolean isEmpty() {
		if(size == 0) {
			return true;
		}
			return false;
	}
	int size() {
		return size;
	}
}
class Steque {
	linkedList steq;
	Steque() {
		steq = new linkedList();
	}

	void push(String item) {
		steq.insert(item);
	}
	String pop() throws Exception {
		return steq.delete();
	}
	void enqueue(String item) {
	 	steq.enque(item);
	}
	boolean isEmpty() {
		return steq.isEmpty();
	}
	int size() {
		return steq.size();
	}
	void printStack() {
		Node temp = steq.first;
		// if (size() == 0) {
		// 	System.out.println("Steque is empty");
		// 	return;
		// }
		if(size() == 0){
			//throw new Exception("Steque is empty");
			System.out.println("Steque is empty.");
			return;
		}
		while(temp.next != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
}

class Solution {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Steque ste = new Steque();
	String num = sc.nextLine();
	while (sc.hasNext()) {
		String[] token = sc.nextLine().split(" ");
		// if(token.length==1 && !token[0].equals("pop")){
		// 	ste = new Steque();
		// 	System.out.println();
		// 	continue;
		// }
		switch (token[0]) {
			case "push":
				ste.push(token[1]);
				ste.printStack();
			break;
			case "pop":
			try{
			ste.pop();
			ste.printStack();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			break;
			case "enqueue":
			ste.enqueue(token[1]);
			ste.printStack();
			break;
			default:
			System.out.println();
			ste = new Steque();
			break;
		}
	}
}
}