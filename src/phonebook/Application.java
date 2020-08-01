package phonebook;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class Application implements Runnable {
    private static final Logger log = Logger.getLogger(Application.class.getName());

    private final PhoneBook phoneBook;
    private final List<String> names;

    public Application(final PhoneBook phoneBook, final List<String> names) {
        this.phoneBook = phoneBook;
        this.names = names;
    }

    @Override
    public void run() {
        log.info("Start searching...");
        final var start = System.currentTimeMillis();
        System.out.println("Start searching...");
        final var entries = names.size();
        final var found = names.stream()
                .map(phoneBook::findByNameLinearSearch)
                .filter(Optional::isPresent)
                .count();
        final var timeMillis = System.currentTimeMillis() - start;

        System.out.printf(
                "Found %d / %d entries. Time taken: %3$TM min. %3$TS sec. %3$TL ms.%n",
                found, entries, timeMillis);
    }
}
