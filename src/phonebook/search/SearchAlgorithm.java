package phonebook.search;

import phonebook.PhoneBook;

@FunctionalInterface
public interface SearchAlgorithm {
    long getNamesFound(final PhoneBook phoneBook, final String[] names);
}
