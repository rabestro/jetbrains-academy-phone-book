package phonebook.algorithm;

import phonebook.Record;

import static java.lang.System.currentTimeMillis;

public class Statistics {
    private final Record[] book;
    private final String[] names;
    private long sortTime;
    private long searchTime;
    private long recordsFound;

    public Statistics(Record[] phoneBook, String[] names) {
        this.book = phoneBook;
        this.names = names;
    }

    public Statistics performSort(SortAlgorithm algorithm) {
        final var start = currentTimeMillis();
        algorithm.sort(book);
        sortTime = currentTimeMillis() - start;
        return this;
    }

    public Statistics performSearch(SearchAlgorithm algorithm) {
        final var start = currentTimeMillis();
        recordsFound = algorithm.getNamesFound(book, names);
        searchTime = currentTimeMillis() - start;
        return this;
    }

    public void printStatistics() {
        System.out.println("Found " + recordsFound + " / " + names.length + " entries. Time taken: "
                + formatTime(searchTime + sortTime));
        if (sortTime > 0) {
            System.out.println("Sorting time: " + formatTime(sortTime));
            System.out.println("Searching time: " + formatTime(searchTime));
        }
    }

    private String formatTime(final long timeMillis) {
        return String.format("%1$TM min. %1$TS sec. %1$TL ms.", timeMillis);
    }
}
