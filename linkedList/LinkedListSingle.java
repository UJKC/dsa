package linkedList;
import java.util.Scanner;

class List {
    int data;
    List next;

    List(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListSingle {
    List head;
    List iterator;

    public void insertAtBeginning(int data) {
        System.out.println("Inserting " + data + " at start: ");
        if (head == null) {
            head = new List(data);
        }
        else {
            List newList = new List(data);
            newList.next = head;
            head = newList;
        }
    }

    public void insertAtLast(int data) {
        System.out.println("Inserting " + data + " at end: ");
        if (head == null) {
            head = new List(data);
        } else {
            List iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            List newList = new List(data);
            iterator.next = newList;
        }
    }
    

    public void insertAtIndex(int index, int data) {
        System.out.println("Inserting " + data + " at " + index + ": ");
        int looper;
        iterator = head;
        for (looper = 1; looper < index - 1; looper++) {
            iterator = iterator.next;
        }
        List temp = iterator.next;
        iterator.next = null;
        List newList = new List(data);
        iterator.next = newList;
        newList.next = temp;
    }

    public void deleteAtFirst() {
        System.out.println("Deleting first");
        if (head == null) {
            System.out.println("Empty");
        }
        else if (head.next == null) {
            head = null;
        }
        else {
            List temp = head;
            head = head.next;
            temp.next = null;
            temp = null;
        }
    }

    public void deleteAtLast() {
        System.out.println("Deleting last");
        if (head == null) {
            System.out.println("List empty");
        }
        else {
            iterator = head;
            List back = head;
            while (iterator.next != null) {
                back = iterator;
                iterator = iterator.next;
            }
            back.next = null;
            iterator = null;
        }
    }

    public void deleteAtIndex(int index) {
        System.out.println("Deleting at " + index + ": ");
        int looper;
        if (head == null) {
            System.out.println("Empty");
        }
        else if (index == 1) {
            deleteAtFirst();
        }
        else {
            iterator = head;
            List back = head;
            List temp;
            for (looper = 0; looper < index - 1; looper++) {
                back = iterator;
                iterator = iterator.next;
            }
            temp = iterator.next;
            back.next = temp;
            iterator.next = null;
            iterator = null;
        }
    }

    public void accessAll() {
        System.out.println("All elements: ");
        if (head == null) {
            System.out.println("No List");
        }
        else {
            iterator = head;
            while (iterator != null) {
                System.out.println(iterator.data);
                iterator = iterator.next;
            }
        }
    }

    public void searching(int ele) {
        iterator = head;
        System.out.println("Searching " + ele + ": ");
        int looper = 0;
        boolean flag = true;
        while (iterator.next != null) {
            looper++;
            if (iterator.data == ele) {
                System.out.println("It was found at " + looper);
                flag = false;
            }
            iterator = iterator.next;
        }
        if (flag) {
            System.out.println("Not found");
        }
    }

    public void accessAtIndex(int index) {
        System.out.println("Searching for element at " + index);
        iterator = head;
        for(int i = 0; i < index - 1; i++) {
            iterator = iterator.next;
        }
        System.out.println(iterator.data);
    }

    /*
    public void Concatenation() {
        if (head == null) {
            System.out.println(head);
        }
    }
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListSingle linkedListSingle = new LinkedListSingle();
        System.out.println("Single Linked List");

        System.out.println("Initialization: ");
        linkedListSingle.insertAtBeginning(10);
        linkedListSingle.insertAtLast(20);
        linkedListSingle.insertAtLast(30);

        linkedListSingle.accessAll();

        /* 
        System.out.println("Enter the element to insert: ");
        int element_lls = scanner.nextInt();
        System.out.println("Enter the index to insert: ");
        int index_lls = scanner.nextInt();

        linkedListSingle.insertAtIndex(index_lls, element_lls);
        linkedListSingle.accessAll();

        linkedListSingle.deleteAtFirst();
        linkedListSingle.accessAll();

        linkedListSingle.deleteAtLast();
        linkedListSingle.accessAll();

        linkedListSingle.deleteAtIndex(2);
        linkedListSingle.accessAll();

        linkedListSingle.accessAtIndex(2);

        linkedListSingle.searching(20);
        */
    }
}
