import java.util.Scanner;

/**
 * node class.
 */
class Node { 
 String data;
 Node next;

 /**
  * constructor.
  *
  * @param      data  The data
  */
 Node (String data) {
 	this.data = data;
 }
}

/**
 * List of linkeds.
 */
class LinkedList {
	Node head;
	int size;

	/**
	 * constructor.
	 */
	LinkedList() {
		head = null;
		size = 0;
	}

	// void insertAt(int pos, String data) {
	// 	Node obj = new Node(data);
	// 	if (pos == 0) {
	// 		obj.next = head;
	// 		head = obj;
	// 		size++;
	// 		return;
	// 	}
	// 	Node previous = null;
	// 	Node temp = head;
	// 	int count = 0;
	// 	while (temp != null) {
	// 		if (count == pos) {
	// 			previous.next = obj;
	// 			obj.next = temp;
	// 			size++;
	// 			return;
	// 		}
	// 		previous = temp;
	// 		temp = temp.next;
	// 		count++;
	// 	}
	// }
	
	/**
	 * insertAt function.
	 *
	 * @param      pos        The position
	 * @param      data       The data
	 *
	 * @throws     Exception  { exception_description }
	 */
	void insertAt(int pos, String data) throws Exception {
		if (pos < 0 || pos > size) {
			throw new Exception();
		}
		Node obj = new Node(data);
		// if (pos == 0) {
		// 	obj.next = head;
		// 	head = obj;
		// 	size++;
		// 	return;
		// }
		head = insertAt (pos, head, obj, 0);
	}

	/**
	 * { function_description }.
	 *
	 * @param      pos    The position
	 * @param      first  The first
	 * @param      obj    The object
	 * @param      count  The count
	 *
	 * @return     { description_of_the_return_value }
	 */
	Node insertAt (int pos, Node first, Node obj, int count) {
		if (pos == count) {
			obj.next = first;
			size++;
			return obj;
		}
		first.next = insertAt(pos, first.next, obj, count+1);
		return first;
	}

	/**
	 * { function_description }
	 */
	void reverse() {
		reverse (null, head);
	}

	/**
	 * { function_description }
	 *
	 * @param      previous  The previous
	 * @param      current   The current
	 */
	void reverse(Node previous, Node current) {
		if (current != null) {
			reverse(current, current.next);
			current.next = previous;
		} else {
			head = previous;
		}
	}

	/**
	 * { function_description }
	 */
	void tostring() {
		Node temp = head;
		String str = "";
		while (temp != null) {
			str += temp.data+", ";
			temp = temp.next;
		}
		System.out.println(str.substring(0, str.length() - 2));
	}
}

/**
 * solution class.
 */
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		while(sc.hasNextLine()) {
			String[] token = sc.nextLine().split(" ");
			switch (token[0]) {
				case "insertAt":
				try{
				ll.insertAt(Integer.parseInt(token[1]), token[2]);
				ll.tostring();
			} catch (Exception e) {
				System.out.println("Can't insert at this position.");
			}
				break;
				case "reverse":
				try {
				ll.reverse();
				ll.tostring();
			} catch (Exception e) {
				System.out.println("No elements to reverse.");
			}
			}
		}
	}
}

