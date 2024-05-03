import java.util.Scanner;;

public class Array {
    int max_SEQ = 10;
    int length;
    int[] array;

    Array(int arr_length) {
        array = new int[arr_length];
    }

    public void accessAll() {
        System.out.println("All elements: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void AccessEle(int index) {
        System.out.println("Elements to get from " + index + ": ");
        System.out.println(array[index - 1]);
    }

    public void AccessFirst() {
        System.out.println("Get First Element: ");
        System.out.println(array[0]);
    }

    public void AccessLast() {
        System.out.println("Get Last Element: ");
        System.out.println(array[array.length - 1]);
    }

    public void insertionatFirst(int ele) {
        int[] newArray = new int[array.length + 1];

        newArray[0] = ele;
        for (int i = 0; i < array.length; i++) {
            newArray[i + 1] = array[i];
        }
        array = newArray;
    }

    public void insertionatLast(int ele) {
        System.out.println("Inserting " + ele + " at last: ");
        int[] newArray = new int[array.length + 1];

        newArray[array.length] = ele;
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        accessAll();
    }

    public void insertionAtIndex(int ele, int index) {
        System.out.println("Inserting " + ele + " at " + index + ": ");
        int[] newArray = new int[array.length + 1];
    
        for (int i = 0; i < index - 1; i++) {
            newArray[i] = array[i];
        }
        newArray[index - 1] = ele;
    
        for (int i = index - 1; i < array.length; i++) {
            newArray[i + 1] = array[i];
        }
        array = newArray;
    }

    public void deleteAtIndex(int index) {
        int[] newArray = new int[array.length - 1];

        for (int i = 0; i <= index - 1; i++) {
            newArray[i] = array[i];
        }
        for (int i = index; i < array.length; i++) {
            newArray[i - 1] = array[i];
        }
        array = newArray;
    }

    public void modifyAtIndex(int index, int ele) {
        array[index - 1] = ele;
    }

    public void concatentaion(Array arr1) {
        int totalarraylength = array.length + arr1.array.length;
        int[] newArray = new int[totalarraylength];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        for (int i = 0; i < arr1.array.length; i++) {
            newArray[array.length + i] = arr1.array[i];
        }
        array = newArray;
    }

    public void slicing(int start, int end) {
        int tot_length = end - start + 1;
        System.out.println(tot_length);

        int[] newArray = new int[tot_length];

        for (int i = 0; i < tot_length; i++) {
            newArray[i] = array[start - 1 + i];
        }
        array = newArray;
    }

    public void Ascending() {
        System.out.println("Sorting Ascending: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void Descending() {
        System.out.println("Soring Descending: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void searching(int ele) {
        boolean flag = true;
        System.out.println("Seaching for " + ele + ": ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ele) {
                System.out.println("Element found at " + (i + 1));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Element not found!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the no of elements: ");
        int max_index = scanner.nextInt();
        
        Array arr = new Array(max_index);

        System.out.println("Initial access: ");
        for (int i = 0; i < max_index; i++) {
            int ujj = scanner.nextInt();
            arr.array[i] = ujj;
        }

        arr.accessAll();
        
        System.out.println("Enter array index to grab: ");
        int index = scanner.nextInt();

        arr.AccessEle(index);

        System.out.println("Enter array to insert at first: ");
        int first = scanner.nextInt();

        arr.insertionatFirst(first);
        arr.accessAll();

        System.out.println("Enter array to insert at last: ");
        int last = scanner.nextInt();

        arr.insertionatLast(last);
        arr.accessAll();

        System.out.println("Enter array element to insert at index: ");
        int element_array = scanner.nextInt();
        System.out.println("Enter array index to insert at index: ");
        int index_array = scanner.nextInt();

        arr.insertionAtIndex(element_array, index_array);
        arr.accessAll();

        System.out.println("Enter array element to delete at index: ");
        int delete_index = scanner.nextInt();

        arr.deleteAtIndex(delete_index);
        arr.accessAll();

        System.out.println("Enter array element to modify at index: ");
        element_array = scanner.nextInt();
        System.out.println("Enter array index to modify at index: ");
        index_array = scanner.nextInt();

        arr.modifyAtIndex(index_array, element_array);
        arr.accessAll();

        arr.AccessFirst();
        arr.AccessLast();
        arr.accessAll();

        System.out.println("Concatenation of two arrays: ");
        System.out.println("Enter the no of elements: ");
        int max_index1 = scanner.nextInt();

        Array arr1 = new Array(max_index1);

        System.out.println("Initial access: ");
        for (int i = 0; i < max_index1; i++) {
            int ujj = scanner.nextInt();
            arr1.array[i] = ujj;
        }

        arr.concatentaion(arr1);
        arr.accessAll();

        System.out.println("Enter array element to start at index: ");
        int start_array = scanner.nextInt();
        System.out.println("Enter array index to end at index: ");
        int end_array = scanner.nextInt();

        arr.slicing(start_array, end_array);
        arr.accessAll();

        System.out.println("Enter array element to search: ");
        int search_ele = scanner.nextInt();

        arr.searching(search_ele);
        arr.accessAll();

        arr.Ascending();
        arr.accessAll();

        arr.Descending();
        arr.accessAll();
        
        scanner.close();
    }
}
