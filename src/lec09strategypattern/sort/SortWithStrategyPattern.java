package lec09strategypattern.sort;

public class SortWithStrategyPattern {

    public static void main(String[] args) {
        BankAccount a[] = { new BankAccount(5),
                new BankAccount(2),
                new BankAccount(7),
                new BankAccount(4)};
        sort(a, new BankAccountComparator());
        for (BankAccount data : a) {
            System.out.println("balance: "+data.getBalance());
        }
    }

    public static void sort(Object[] a, Comparator cmp) {
        for (int i = 0; i < a.length - 1; i++) {// i divides array into two parts: already-sorted, not sorted
            int minPos = i;
            for (int j = i + 1; j < a.length; j++) {  // loop to find index containing a minimum value
                if (cmp.compare(a[j], a[minPos]) < 0) {
                    minPos = j;
                }
            }
            // swap minPos and i so that data in minPos index will be the already-sorted part
            Object temp = a[minPos];
            a[minPos] = a[i];
            a[i] = temp;
        }
    }

}
