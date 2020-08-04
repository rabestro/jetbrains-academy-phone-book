package phonebook.algorithm;

import phonebook.Contact;

@FunctionalInterface
public interface SortAlgorithm {
    void sort(final Contact[] phoneBook);
}
