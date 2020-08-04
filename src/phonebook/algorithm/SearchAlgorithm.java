package phonebook.algorithm;

import phonebook.Contact;

import java.util.Arrays;
import java.util.Optional;

@FunctionalInterface
public interface SearchAlgorithm {
    Optional<Contact> find(final Contact[] phoneBook, final String name);

    default long entriesFound(final Contact[] phoneBook, final String[] names) {
        return Arrays.stream(names)
                .map(name -> find(phoneBook, name))
                .filter(Optional::isPresent)
                .count();
    }
}
