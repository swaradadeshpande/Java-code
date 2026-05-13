import java.util.Scanner;

class PuzzleSolver {
    private int n;
    private int[] arr;

    public void setSize(int num) {   // Set size
        n = num;
    }
    public void setArray(int[] a) {   // Set array
        arr = a;
    }

    public int missing(int s,int s1){   // Missing number using sums from user
		int result = s-s1;
		return result;
    }

    public void sortArray() {  // Sort array using Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.print("Sorted Array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void searchElement(int key) {// Searching  element
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                found = true;
                break;
            }
        }

        if (found)
            System.out.println("Element Found!");
        else
            System.out.println("Element Not Found!");
    }

    public int findMax() {     // Find maximum element
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public int findMin() {   // Find minimum element
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public void sumPairs(int target) {     // Sum pair puzzle
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(arr[i] + " , " + arr[j]);
                    found = true;
                }
            }
        }

        if (!found)
            System.out.println("No pairs found!");
    }

   public static void main(String[] args) { // Main
        Scanner sc = new Scanner(System.in);
        PuzzleSolver ps = new PuzzleSolver();
        System.out.println("Array Puzzle Solver!!");
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();
        ps.setSize(size);

        int[] array = new int[size];
        int expectedSum = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
            expectedSum += array[i];
        }
        ps.setArray(array);
        int choice;
        do {  // Menu-driven loop
            System.out.println("\nMENU");
            System.out.println("1. Find Missing Number");
            System.out.println("2. Sort the Array");
            System.out.println("3. Search an Element");
            System.out.println("4. Find Largest Element");
            System.out.println("5. Find Smallest Element");
            System.out.println("6. Sum Pair Puzzle");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                int[] arr1 = new int[size];
                int actualSum = 0;
                System.out.println("Enter array elements:");
                for (int i = 0; i < size-1; i++) {
                    arr1[i] = sc.nextInt();
                    actualSum += arr1[i];
                }
                    System.out.println("Missing Number: " +
                            ps.missing(expectedSum , actualSum));
                    break;
                case 2:
                    ps.sortArray();
                    break;
                case 3:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    ps.searchElement(key);
                    break;
                case 4:
                    System.out.println("Largest Element: " + ps.findMax());
                    break;
                case 5:
                    System.out.println("Smallest Element: " + ps.findMin());
                    break;
                case 6:
                    System.out.print("Enter target sum: ");
                    int target = sc.nextInt();
                    ps.sumPairs(target);
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
        sc.close();
    }
}
