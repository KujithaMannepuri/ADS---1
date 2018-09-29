import java.util.Scanner;
import java.util.LinkedList;


class AddLargeNumbers {
    // LinkedList list;
    // AddLargeNumbers() {
    //     list = new LinkedList();
    // }
    public static LinkedList numberToDigits(String number) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < number.length(); i++) {
            list.addLast(Character.getNumericValue(number.charAt(i)));
        }
        
        return list;
    }

    public static String digitsToNumber(LinkedList list) {
        String str = "";
        //Node obj = new Node();
        System.out.println(list);
        // for (int i = 1; i < list.size(); i++) {
        //     str.concat(list.get(i));
        // }
        //StringBuilder str = new StringBuilder();
        // while (obj.next != null) {
        //     str.concat(obj.list);
        //     System.out.println(str);
        // }
        
        return str;

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
