package phonebook;

import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Logger;

public class Application implements Runnable {
    private static final Logger log = Logger.getLogger(Application.class.getName());

    private final PhoneBook phoneBook;
    private final String[] names;
    private long bubbleSortMaxTime;

    public Application(final PhoneBook phoneBook, final String[] names) {
        this.phoneBook = phoneBook;
        this.names = names;
    }

    @Override
    public void run() {
        log.info("Start searching...");
        linearSearch();
        bubbleSortJumpSearch();
    }

    private void linearSearch() {
        System.out.println("Start searching (linear search)..");
        final var start = System.currentTimeMillis();

        final var found = Arrays.stream(names)
                .map(phoneBook::findByNameLinearSearch)
                .filter(Optional::isPresent)
                .count();
        final var timeMillis = System.currentTimeMillis() - start;

        System.out.printf(
                "Found %d / %d entries. Time taken: %3$TM min. %3$TS sec. %3$TL ms.%n",
                found, names.length, timeMillis);

        bubbleSortMaxTime = timeMillis * 500;
    }

    private void bubbleSortJumpSearch() {
        System.out.println("Start searching (bubble sort + jump search)...");
        final var start = System.currentTimeMillis();

    }
}
