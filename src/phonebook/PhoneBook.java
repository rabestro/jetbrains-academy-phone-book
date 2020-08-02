package phonebook;

import java.util.*;
import java.util.logging.Logger;

public class PhoneBook {
    private static final Logger log = Logger.getLogger(PhoneBook.class.getName());

    private PhoneBookEntry[] records;

    public PhoneBook(final String url) {
        load(url);
    }

    void load(final String data) {
        records = new Scanner(data)
                .useDelimiter("\\R")
                .tokens()
                .map(PhoneBookEntry::new)
                .toArray(PhoneBookEntry[]::new);
    }

    public PhoneBookEntry get(final int i) {
        return records[i];
    }

    public void set(final int i, final PhoneBookEntry entry) {
        records[i] = entry;
    }

    public String getName(final int i) {
        return records[i].getName();
    }

    public int size() {
        return records.length;
    }

    public Optional<PhoneBookEntry> findByNameLinearSearch(final String name) {
        log.fine("Looking for a name = " + name);
        for (final var record : records) {
            if (Objects.equals(record.getName(), name)) {
                return Optional.of(record);
            }
        }
        return Optional.empty();
    }
}
