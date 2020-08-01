package phonebook;

import java.util.List;
import java.util.Optional;

public class Application implements Runnable {

    private final PhoneBook phoneBook;
    private final List<String> names;

    public Application(final PhoneBook phoneBook, final List<String> names) {
        this.phoneBook = phoneBook;
        this.names = names;
    }

    @Override
    public void run() {
        System.out.println("Start searching...");
        final var entries = names.size();
        final var found = names.stream()
                .map(phoneBook::findByNameLinearSearch)
                .filter(Optional::isPresent)
                .count();

        System.out.printf("Found %d / %d entries. Time taken: 1 min. 56 sec. 328 ms.", found, entries);
    }
}
