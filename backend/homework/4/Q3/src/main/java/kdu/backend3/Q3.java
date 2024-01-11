package kdu.backend3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Q3{

    Logging logger = new Logging();

    public static <T> void swap(T[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length || index1 == index2) {
            // Check for null array, valid indices, and distinct indices
            logger.logInfo("Invalid parameters. Unable to swap elements.");
            return;
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static <T> void swap(List<T> list, int index1, int index2) {
        if (list == null || index1 < 0 || index1 >= list.size() || index2 < 0 || index2 >= list.size() || index1 == index2) {
            // Check for null list, valid indices, and distinct indices
            logger.logInfo("Invalid parameters. Unable to swap elements.");
            return;
        }

        Collections.swap(list, index1, index2);
    }

    public static void main(String[] args) {
        Logging logger = new Logging();
        // Example usage with an array of integers
        Integer[] intArray = {1, 2, 3, 4, 5};
        logger.logInfo("Original array: " + Arrays.toString(intArray));

        // Swap elements at index 1 and index 3
        swap(intArray, 1, 3);

        logger.logInfo("Array after swapping: " + Arrays.toString(intArray));

        // Example usage with an array of strings
        String[] stringArray = {"apple", "banana", "cherry", "date"};
        logger.logInfo("\nOriginal array: " + Arrays.toString(stringArray));

        // Swap elements at index 0 and index 2
        swap(stringArray, 0, 2);

        logger.logInfo("Array after swapping: " + Arrays.toString(stringArray));

        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        swap(intList, 1, 3);
        logger.logInfo("List after swapping: " + intList);

    }
}
