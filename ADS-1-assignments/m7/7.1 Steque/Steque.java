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
	/** This insert method takes the time complexity O(1) and takes constant time.*/ 
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
	/* This delete method takes the time complexity O(1) and takes constant time.*/
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
	/* The time complexity for enque method is O(1) takes constant time.*/
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
	/* The time complexity for isEmpty method is O(1) takes constant time.*/
	boolean isEmpty() {
		if(size == 0) {
			return true;
		}
			return false;
	}
	/* The time complexity for size method is O(1) takes constant time.*/
	int size() {
		return size;
	}
}
class Steque {
	linkedList steq;
	Steque() {
		steq = new linkedList();
	}
	/* The time complexity for push method is O(1) takes constant time.*/
	void push(String item) {
		steq.insert(item);
	}
	/* The time complexity for pop method is O(1) takes constant time.*/
	String pop() throws Exception {
		return steq.delete();
	}
	/* The time complexity for enque method is O(1) takes constant time.*/
	void enqueue(String item) {
	 	steq.enque(item);
	}
	/* The time complexity for isEmpty method is O(1) takes constant time.*/
	boolean isEmpty() {
		return steq.isEmpty();
	}
	/* The time complexity for size method is O(1) takes constant time.*/
	int size() {
		return steq.size();
	}
	/** The time complexity for printStack method is O(N).*/
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