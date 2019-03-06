package lec09strategypattern.sort;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Object[] characters = {'r', 'n', 'c', '0', 'i', 's', 'a', 'f'};
        Object[] numbers = {5, 0, 20 , 19 , 97, 4, 7, 98, 69};

        Comparator sortAlphabet = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if((char) o1 < (char) o2) {
                    return -1;
                }
                else if((char) o1 > (char) o2){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        };
        Comparator sortAscending = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if((int) o1 < (int) o2) {
                    return -1;
                }
                else if((int) o1 > (int) o2){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        };
        Comparator sortDescending = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if((int) o1 > (int) o2) {
                    return -1;
                }
                else if((int) o1 < (int) o2){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        };

        System.out.println("Before Sort");
        printArray(characters);
        sort(characters, sortAlphabet);
        System.out.println("After Sort");
        printArray(characters);

        System.out.println("ASCENDING SORT");
        System.out.println("Before Sort");
        printArray(numbers);
        sort(numbers, sortAscending);
        System.out.println("After Sort");
        printArray(numbers);

        System.out.println("DESCENDING SORT");
        System.out.println("Before Sort");
        printArray(numbers);
        sort(numbers, sortDescending);
        System.out.println("After Sort");
        printArray(numbers);



    }

    public static void sort(Object[] data, Comparator cmp) {
        // i divides array into two parts: already-sorted, not sorted
        for (int i = 0; i < data.length - 1; i++) {
            int minPos = i;
            // loop to find index containing a minimum value
            for (int j = i + 1; j < data.length; j++) {
                if (cmp.compare(data[j], data[minPos]) < 0) {
                    minPos = j;
                }
            }
            // swap minPos and i so that data in minPos index will
            // be the already-sorted part
            Object temp = data[minPos];
            data[minPos] = data[i];
            data[i] = temp;
        }
    }

    public static void printArray(Object[] array){
        for (Object i: array) {
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println();
    }


}
