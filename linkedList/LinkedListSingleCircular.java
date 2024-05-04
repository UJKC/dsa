package linkedList;
import java.util.Scanner;

class List {
    int data;
    List next = null;

    List(int data) {
        this.data = data;
    }
}

public class LinkedListSingleCircular {
    List temp;
    List tail;
    List next;
    List iterator;

    public void inserAtFirst(int data) {
        if (tail == null) {
            tail = new List(data);
            tail.next = tail;
        }
        else {
            next = tail.next;
            tail.next = null;
            temp = new List(data);
            temp.next = next;
            tail.next = temp;
        }
    }

    public void inserAtLast(int data) {
        if(tail == null) {
            tail = new List(data);
            tail.next = tail;
        }
        else {
            next = tail.next;
            tail.next = null;
            temp = new List(data);
            tail.next = temp;
            temp.next = next;
            tail = temp;
        }
    }

    public void insertAtIndex(int index, int data) {
        List head = tail.next;
        if (index < 0)
            return; // Index out of range
    
        List newTask = new List(data);
    
        // Special case for inserting at index 0
        if (index == 0) {
            if (head == null) {
                head = newTask;
                newTask.next = newTask; // Make it point to itself
                tail = newTask;
            } else {
                newTask.next = head; // Make the new node point to the current head
                tail.next = newTask; // Make the last node point to the new node
                head = newTask; // Update head to point to the new node
            }
            return;
        }
    
        iterator = head;
        int looper = 0;
    
        // Traverse to the node at position index - 1
        while (looper < index - 1) {
            iterator = iterator.next;
            // Check if we have looped back to the head before reaching the desired index
            if (iterator == head) {
                return; // Index out of range
            }
            looper++;
        }
    
        // Insert the new node after iterator
        newTask.next = iterator.next;
        iterator.next = newTask;
    
        // Update tail if the new node is inserted at the end
        if (iterator == tail) {
            tail = newTask;
        }
    }
    

    public static void main(String[] args) {
       LinkedListSingleCircular llsc = new LinkedListSingleCircular();
       Scanner scan = new Scanner(System.in);
       
       /* 
       System.out.println("Enter the element to add at first: ");
       int data = scan.nextInt();
       llsc.inserAtFirst(data);

       System.out.println("Enter the element to add at last: ");
       int data = scan.nextInt();
       llsc.inserAtLast(data);
       */

       System.out.println("Enter the element to add at index: ");
       int data = scan.nextInt();
       System.out.println("Enter the index to add: ");
       int index = scan.nextInt();
       llsc.insertAtIndex(index, data);
    }
}
