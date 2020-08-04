package phonebook.algorithm;

import phonebook.Record;

@FunctionalInterface
public interface SortAlgorithm {
    void sort(final Record[] phoneBook);
}
