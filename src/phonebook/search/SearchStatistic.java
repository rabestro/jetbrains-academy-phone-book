package phonebook.search;

import phonebook.PhoneBook;

import static java.lang.System.currentTimeMillis;

public class SearchStatistic {
    private final PhoneBook book;
    private final String[] names;
    private long searchTime;
    private long recordsFound;

    public SearchStatistic(PhoneBook book, String[] names) {
        this.book = book;
        this.names = names;
    }

    public SearchStatistic performSearch(SearchAlgorithm algorithm) {
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
}
