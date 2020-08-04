package phonebook.algorithm;

import phonebook.Contact;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSort implements SortAlgorithm {

    @Override
    public void sort(Contact[] phoneBook) {
        Arrays.sort(phoneBook, Comparator.comparing(Contact::getName));
    }
}
