package phonebook;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PhoneBook {
    private static final Logger log = Logger.getLogger(PhoneBook.class.getName());

    private List<PhoneBookEntry> records;

    public PhoneBook() {
        this.records = new ArrayList<>();
    }

    public PhoneBook(final String url) {
        load(url);
    }

    void load(final String data) {
        records = new Scanner(data)
                .useDelimiter("\\R")
                .tokens()
                .map(PhoneBookEntry::new)
                .collect(Collectors.toList());
    }

    public PhoneBookEntry getId(final int i) {
        return records.get(i);
    }

    public int size() {
        return records.size();
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
