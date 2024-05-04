package linkedList;
import java.util.Scanner;

class List {
    int data;
    List next = null;
    List prev = null;

    List(int data) {
        this.data = data;
    }
}

public class LinkedListDouble {
    List head;
    List temp;
    List next;
    List prev;
    List iterator;

    public void insertionAtFirst(int data) {
        System.out.println("Adding " + data + " at first!");
        if (head == null) {
            head = new List(data);
        }
        else {
            temp = new List(data);
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public void insertAtLast(int data) {
        System.out.println("Adding " + data + " at last!");
        if (head == null) {
            head = new List(data);
        }
        else {
            iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            temp = new List(data);
            iterator.next = temp;
            temp.prev = iterator;
        }
    }

    public void insertAtIndex(int data, int index) {
        System.out.println("Adding " + data + " at " + index + " !");
        if (head == null) {
            head = new List(data);
        }
        else {
            iterator = head;
            temp = new List(data);
            int looper = 0;
            for (looper = 0; looper < index - 1; looper++) {
                prev = iterator;
                iterator = iterator.next;
            }
            prev.next = temp;
            iterator.prev = temp;
            temp.next = iterator;
            temp.prev = prev;
        }
    }

    public void deleteAtFirst() {
        System.out.println("deleting at first!");
        if(head == null) {
            System.out.println("Its not exits");
        }
        else if (head.next == null) {
            head = null;
        }
        else {
            temp = head;
            head = head.next;
            temp = null;
        }
    }

    public void deleteAtLast() {
        System.out.println("deleting at last!");
        if (head == null) {
            System.out.println("Error at deleting");
        }
        else if (head.next == null) {
            head = null;
        }
        else {
            iterator = head;
            prev = head;
            while (iterator.next != null) {
                prev = iterator;
                iterator = iterator.next;
            }
            prev.next = null;
            iterator.prev = null;
            iterator = null;
        }
    }

    public void deleteAtIndex(int index) {
        int looper = 0;
        iterator = head;
        prev = head;
        next = head;
        for (looper = 0; looper < index - 1; looper++) {
            prev = iterator;
            iterator = iterator.next;
            next = iterator.next;
        }
        prev.next = next;
        iterator.prev = null;
        iterator.next = null;
        next.prev = prev;
    }

    public void accessAll() {
        iterator = head;
        while (iterator != null) {
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
    }

    public void searchEle(int data) {
        int looper = 0;
        iterator = head;
        if (head == null) {
            System.out.println("No list found!");
        }
        else if (head.data == data) {
            System.out.println("Found at 1");
        }
        else {
            while (iterator != null) {
                looper++;
                if (iterator.data == data) {
                    System.err.println("Found at " + (looper));
                    break;
                }
                iterator = iterator.next;
            }
        }
    }

    public void length() {
        int looper = 0;
        iterator = head;
        if (head == null) {
            System.out.println("Length is 0");
        }
        else if (head.next == null) {
            System.out.println("Length is 1");
        }
        else {
            while (iterator != null) {
                looper++;
                iterator = iterator.next;
            }
            System.err.println("Length is " + looper);
        }
    }

    public static void main(String[] args) {
        LinkedListDouble lld = new LinkedListDouble();
        Scanner scan = new Scanner(System.in);
        System.out.println("Doubly linked List: ");
        lld.insertionAtFirst(10);
        lld.insertionAtFirst(20);
        lld.insertionAtFirst(30);
        lld.insertionAtFirst(40);
        lld.insertionAtFirst(50);
        lld.accessAll();

        System.out.println("Insert at First");
        System.out.println("Enter the number to insert at first: ");
        int data = scan.nextInt();
        lld.insertionAtFirst(data);
        lld.accessAll();

        System.out.println("Insert at last: ");
        System.out.println("Enter the number to insert at last: ");
        data = scan.nextInt();
        lld.insertAtLast(data);
        lld.accessAll();

        System.out.println("Insert at index: ");
        System.out.println("Enter element to insert: ");
        data = scan.nextInt();
        System.out.println("Enter index position: ");
        int index = scan.nextInt();

        lld.insertAtIndex(data, index);
        lld.accessAll();
        
        lld.deleteAtFirst();
        lld.accessAll();

        lld.deleteAtLast();
        lld.accessAll();

        System.out.println("Enter the element to search");
        data = scan.nextInt();

        lld.searchEle(data);

        lld.length();
    }
}