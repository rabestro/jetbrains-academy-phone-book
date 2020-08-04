package phonebook;

import java.util.*;
import java.util.logging.Logger;

public class PhoneBook {
    private static final Logger log = Logger.getLogger(PhoneBook.class.getName());

    private Contact[] contacts;

    public PhoneBook(final String url) {
        load(url);
    }

    void load(final String data) {
        contacts = new Scanner(data)
                .useDelimiter("\\R")
                .tokens()
                .map(Contact::new)
                .toArray(Contact[]::new);
    }

    public Contact get(final int i) {
        return contacts[i];
    }

    public void set(final int i, final Contact entry) {
        contacts[i] = entry;
    }

    public String getName(final int i) {
        return contacts[i].getName();
    }

    public int size() {
        return contacts.length;
    }

    public Optional<Contact> findByNameLinearSearch(final String name) {
        log.fine("Looking for a name = " + name);
        for (final var record : contacts) {
            if (Objects.equals(record.getName(), name)) {
                return Optional.of(record);
            }
        }
        return Optional.empty();
    }
}
