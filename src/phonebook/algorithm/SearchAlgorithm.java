package phonebook.algorithm;

import phonebook.Record;

@FunctionalInterface
public interface SearchAlgorithm {
    long getNamesFound(final Record[] phoneBook, final String[] names);
}
