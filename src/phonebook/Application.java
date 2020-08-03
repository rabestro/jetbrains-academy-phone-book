package phonebook;

import phonebook.algorithm.JumpSearch;
import phonebook.algorithm.LinearSearch;
import phonebook.algorithm.Statistics;

import java.util.logging.Logger;

import static java.lang.System.currentTimeMillis;

public class Application implements Runnable {
    private static final Logger log = Logger.getLogger(Application.class.getName());

    private final Record[] phoneBook;
    private final String[] names;
    private long bubbleSortMaxTime;

    public Application(final Record[] phoneBook, final String[] names) {
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
        final var stats = new Statistics(phoneBook, names);
        stats.performSearch(new LinearSearch());
        stats.printStatistics();
        bubbleSortMaxTime = stats.getSearchTime() * 500;
    }

    private void bubbleSortJumpSearch() {
        System.out.println("Start searching (bubble sort + jump search)...");
        final var start = currentTimeMillis();
        var isBreak = false;
        for (int i = 0; i < phoneBook.length - 1; i++) {
            isBreak = currentTimeMillis() - start > bubbleSortMaxTime;
            if (isBreak) {
                break;
            }
            for (int j = 0; j < phoneBook.length - i - 1; j++) {
                if (phoneBook[j].getName().compareTo(phoneBook[j + 1].getName()) > 0) {
                    final var temp = phoneBook[j];
                    phoneBook[j] = phoneBook[j + 1];
                    phoneBook[j + 1] = temp;
                }
            }
        }

        final var sortingTime = currentTimeMillis() - start;
        final var stats = new Statistics(phoneBook, names);
        stats.performSearch(isBreak ? new LinearSearch() : new JumpSearch());
        final var searchTime = stats.getSearchTime();
        stats.addTime(sortingTime);
        stats.printStatistics();

        System.out.print("Sorting time: " + formatTime(sortingTime));
        System.out.println(isBreak ? " - STOPPED, moved to linear search" : "");
        System.out.println("Searching time: " + formatTime(searchTime));
    }

    private String formatTime(final long timeMillis) {
        return String.format("%1$TM min. %1$TS sec. %1$TL ms.", timeMillis);
    }
}
