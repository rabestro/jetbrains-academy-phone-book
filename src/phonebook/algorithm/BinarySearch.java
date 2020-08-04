package phonebook.algorithm;

import phonebook.Contact;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class BinarySearch implements SearchAlgorithm {

    @Override
    public Optional<Contact> find(Contact[] phoneBook, String name) {
        final var index = Arrays.binarySearch(phoneBook,
                new Contact("001 " + name),
                Comparator.comparing(Contact::getName));

        return (index >= 0) ? Optional.of(phoneBook[index]) : Optional.empty();
    }

}
