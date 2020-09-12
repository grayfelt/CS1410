/**
 * Assignment 4 for CS 1410
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 *
 * @author
 */
public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;

    public static void main(String[] args) {

        demoLinearSearchUnsorted();
        demoLinearSearchSorted();
        demoBinarySearchSelectionSort();
        demoBinarySearchFastSort();
    }

    public static int[] generateNumbers(int howMany, int maxValue){
        if(howMany > 0) {
            int[] array = new int[howMany];
            for(int i = 0; i < howMany; i++){
                array[i] = (int) (Math.random() * maxValue);
            }
            return array;
        }
        else {
            return null;
        }

    }

    public static boolean linearSearch(int[] data, int search){
        boolean found = false;
        for (int datum : data) {
            if (datum == search) {
                found = true;
                break;
            }
        }
        return found;
    }
    public static boolean binarySearch(int[] data, int search){
        boolean found = false;
        int max = data.length - 1;
        int min = 0;

        while (max >= min) {
            int mid = (min + max) / 2;
            if (search < data[mid]) {
                max = mid - 1;
            }
            else if (search == data[mid]) {
                found = true;
                break;
            }
            else {
                min = mid + 1;
            }
            }
        return found;
        }
    public static void selectionSort(int[] data) {
        for(int i = 0; i < data.length - 1; i++){
            int min = data[i];
            int minIndex = i;

            for(int a = i + 1; a < data.length; a++) {
                if (min > data[a]){
                    min = data[a];
                    minIndex = a;
                }
            }

            if(minIndex != i){
                data[minIndex] = data[i];
                data[i] = min;
            }
            }
        }


    public static void demoLinearSearchUnsorted() {
        System.out.println("--- Linear Search Timing (unsorted) ---");
        for(int a = ARRAY_INCREMENT; a <= MAX_ARRAY_SIZE; a+= ARRAY_INCREMENT) {
            int foundCount = 0;
            int array[] = generateNumbers(a, MAX_VALUE);
            long start = System.currentTimeMillis();

            for(int b = 0; b <= NUMBER_SEARCHES; b++){
                int key = (int) (Math.random() * MAX_VALUE);
                if (linearSearch(array, key)){
                    foundCount += 1;
                }
            }
            long end = System.currentTimeMillis();
            long totalTime = end - start;
            System.out.printf("%-22s", "Number of items");
            System.out.println(": " + a);
            System.out.printf("%-22s", "Times value was found");
            System.out.println(": " + foundCount);
            System.out.printf("%-22s", "Total search time");
            System.out.println(": " + totalTime + "ms");
            System.out.println();

        }

    }

    /**
     * Demonstrates linear searching over a sorted array
     *
     */
    public static void demoLinearSearchSorted() {
        System.out.println("--- Linear Search Timing (Selection Sort) ---");
        for(int a = ARRAY_INCREMENT; a <= MAX_ARRAY_SIZE; a+= ARRAY_INCREMENT) {
            int foundCount = 0;
            int array[] = generateNumbers(a, MAX_VALUE);
            long start = System.currentTimeMillis();
            selectionSort(array);

            for(int b = 0; b <= NUMBER_SEARCHES; b++){
                int key = (int) (Math.random() * MAX_VALUE);
                if (linearSearch(array, key)){
                    foundCount += 1;
                }
            }
            long end = System.currentTimeMillis();
            long totalTime = end - start;
            System.out.printf("%-22s", "Number of items");
            System.out.println(": " + a);
            System.out.printf("%-22s", "Times value was found");
            System.out.println(": " + foundCount);
            System.out.printf("%-22s", "Total search time");
            System.out.println(": " + totalTime + "ms");
            System.out.println();

        }

    }

    /**
     * Demonstrates binary searching when using a Selection Sort
     *
     */
    public static void demoBinarySearchSelectionSort() {
        System.out.println("--- Binary Search Timing (Selection Sort) ---");
        for(int a = ARRAY_INCREMENT; a <= MAX_ARRAY_SIZE; a+= ARRAY_INCREMENT) {
            int foundCount = 0;
            int array[] = generateNumbers(a, MAX_VALUE);
            long start = System.currentTimeMillis();
            selectionSort(array);

            for(int b = 0; b <= NUMBER_SEARCHES; b++){
                int key = (int) (Math.random() * MAX_VALUE);
                if (binarySearch(array, key)){
                    foundCount += 1;
                }
            }
            long end = System.currentTimeMillis();
            long totalTime = end - start;
            System.out.printf("%-22s", "Number of items");
            System.out.println(": " + a);
            System.out.printf("%-22s", "Times value was found");
            System.out.println(": " + foundCount);
            System.out.printf("%-22s", "Total search time");
            System.out.println(": " + totalTime + "ms");
            System.out.println();

        }

    }

    /**
     * Demonstrates binary searching when using the build in Arrays.sort
     *
     */
    public static void demoBinarySearchFastSort() {
        System.out.println("--- Binary Search Timing (Arrays.sort) ---");
        for(int a = ARRAY_INCREMENT; a <= MAX_ARRAY_SIZE; a+= ARRAY_INCREMENT) {
            int foundCount = 0;
            int array[] = generateNumbers(a, MAX_VALUE);
            long start = System.currentTimeMillis();
            java.util.Arrays.sort(array);

            for(int b = 0; b <= NUMBER_SEARCHES; b++){
                int key = (int) (Math.random() * MAX_VALUE);
                if (binarySearch(array, key)){
                    foundCount += 1;
                }
            }
            long end = System.currentTimeMillis();
            long totalTime = end - start;
            System.out.printf("%-22s", "Number of items");
            System.out.println(": " + a);
            System.out.printf("%-22s", "Times value was found");
            System.out.println(": " + foundCount);
            System.out.printf("%-22s", "Total search time");
            System.out.println(": " + totalTime + "ms");
            System.out.println();

        }
    }
}
