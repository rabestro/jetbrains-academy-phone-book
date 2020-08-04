package phonebook.algorithm;

import phonebook.Contact;

import java.util.Objects;
import java.util.Optional;

public class LinearSearch implements SearchAlgorithm {

    @Override
    public Optional<Contact> find(Contact[] phoneBook, String name) {
        for (int i = phoneBook.length; i-- > 0; ) {
            if (Objects.equals(name, phoneBook[i].getName())) {
                return Optional.of(phoneBook[i]);
            }
        }
        return Optional.empty();
    }

}
