package phonebook.algorithm;

import phonebook.Record;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSort implements SortAlgorithm {

    @Override
    public void sort(Record[] phoneBook) {
        Arrays.sort(phoneBook, Comparator.comparing(Record::getName));
    }
}
