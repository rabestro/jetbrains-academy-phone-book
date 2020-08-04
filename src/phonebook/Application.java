package phonebook;

import phonebook.algorithm.BubbleSort;
import phonebook.algorithm.JumpSearch;
import phonebook.algorithm.LinearSearch;
import phonebook.algorithm.Statistics;

import java.util.Arrays;
import java.util.logging.Logger;

public class Application implements Runnable {
    private static final Logger log = Logger.getLogger(Application.class.getName());

    private final Record[] phoneBook;
    private final String[] names;

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

        new Statistics(phoneBook, names)
                .performSearch(new LinearSearch())
                .printStatistics();
    }

    private void bubbleSortJumpSearch() {
        System.out.println("Start searching (bubble sort + jump search)...");

        new Statistics(Arrays.copyOf(phoneBook, phoneBook.length), names)
                .performSort(new BubbleSort())
                .performSearch(new JumpSearch())
                .printStatistics();
    }
}
