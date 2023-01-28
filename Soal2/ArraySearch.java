import java.util.Arrays;

public class ArraySearch {
    // Linear search function (iterative) untuk data pada posisi ganjil
    public static int linearSearchOdd(String[] arr, String target) {
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    // Binary search function (recursive) untuk data pada posisi genap
    public static int binarySearchEven(String[] arr, int low, int high, String target) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if (mid % 2 != 0) { // check if mid index is even
                mid--; // if not, decrement by 1 to make it even
            }
            if (arr[mid].equals(target)) {
                return mid;
            } else if (arr[mid].compareTo(target) > 0) {
                return binarySearchEven(arr, low, mid - 2, target);
            } else {
                return binarySearchEven(arr, mid + 2, high, target);
            }
        }
        return -1;
    }
    
    // Simple Bubble Sort
    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    // swap arr[j+1] dan arr[i]
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"Ayaka", "Ayato", "Rangga", "Booga", "Kom", "Prabu", "Rain", "Riot", "Sasa", "Zarman"};

        System.out.println("Berikut merupakan data - data.");
        System.out.println(Arrays.toString(arr) + "\n");
        
        // Linear Search Odd (Ganjil) untuk "Rain"
        System.out.println("Melakukan pencarian Menggunakan Linear Search Odd (Ganjil) dengan kata pencarian \"Rain\"");
        int result1 = linearSearchOdd(arr, "Riot");
        if (result1 == -1) {
            System.out.println("Maaf..., Data tidak di temukan.");
        } else {
            System.out.println("Yay..., Data di temukan pada index ke " + result1);
        }
        System.out.println("");

        // Binary Search Even (Genap) untuk "Sasa"
        System.out.println("Melakukan pencarian Menggunakan Binary Search Even (Genap) dengan kata pencarian \"Sasa\"");
        bubbleSort(arr); // Sortir data sebelum memulai binary search
        System.out.println("Lakukan Sorting sebelum melakukan Binary Search, Berikut data yang sudah di sortir");
        System.out.println(Arrays.toString(arr));
        int result2 = binarySearchEven(arr, 0, arr.length - 1, "Sasa");
        if (result2 == -1) {
            System.out.println("Maaf..., Data tidak di temukan.");
        } else {
            System.out.println("Yay..., Data di temukan pada index ke " + result2);
        }
    }
}