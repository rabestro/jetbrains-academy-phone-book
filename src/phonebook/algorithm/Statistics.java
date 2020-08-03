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

    public Statistics performSort(SortAlgorithm algorithm, long maxTime) {
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
        System.out.printf(
                "Found %d / %d entries. Time taken: %3$TM min. %3$TS sec. %3$TL ms.%n",
                recordsFound, names.length, searchTime);
    }

    public long getSearchTime() {
        return searchTime;
    }

    public void addTime(long time) {
        searchTime += time;
    }
}
