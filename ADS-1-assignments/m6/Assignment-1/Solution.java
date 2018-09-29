import java.util.Scanner;
import java.util.Arrays;
class Node {
    String data;
    Node next;
}
class LinkedList {
    Node start;
    int size;
    LinkedList() {
        start = new Node();
        size = 0;
    }
    void insert(String item) {
        Node obj = new Node();
        obj.data = item;
        if(size == 0) {
            start = obj;
            size++;
            return;
        }
        obj.next = start;
        start = obj;
    }
    // public void resize(int capacity) {
    //     if (capacity >= size) {
    //         String data = Arrays.copyOf(start, capacity);
    //     }
    // }
}
class Stack {
    LinkedList list;
    Stack() {
        list = new LinkedList();
    }
    void push (String item){
        list.insert(item);
    }
}
class AddLargeNumbers {
    // LinkedList list;
    // AddLargeNumbers() {
    //     list = new LinkedList();
    // }
    public static LinkedList numberToDigits(String number) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < number.length(); i++) {
            String ch = number.charAt(i)+ "";
            list.insert(ch);
        }
        return list;
    }

    public static String digitsToNumber(LinkedList list) {
        return null;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return null;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
