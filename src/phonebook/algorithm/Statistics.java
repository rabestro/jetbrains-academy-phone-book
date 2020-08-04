package phonebook.algorithm;

import phonebook.Record;

import java.util.concurrent.*;

import static java.lang.System.currentTimeMillis;

public class Statistics {
    private static long maxTime = 100_000;

    private final Record[] book;
    private final String[] names;
    private long sortTime;
    private long searchTime;
    private long recordsFound;
    private boolean isSorted = false;

    public Statistics(Record[] phoneBook, String[] names) {
        this.book = phoneBook;
        this.names = names;
    }

    public Statistics performSort(SortAlgorithm algorithm) {
        final var executor = Executors.newFixedThreadPool(4);
        final var start = currentTimeMillis();

        Future<?> future = executor.submit(() -> algorithm.sort(book));
        executor.shutdown();

        try {
            future.get(maxTime, TimeUnit.MILLISECONDS);
            isSorted = true;
        } catch (InterruptedException e) {
            System.out.println("job was interrupted");
        } catch (ExecutionException e) {
            System.out.println("caught exception: " + e.getCause());
        } catch (TimeoutException e) {
            future.cancel(true);
            System.out.println("timeout");
        }
//        if(!executor.awaitTermination(2, TimeUnit.SECONDS)){
            executor.shutdownNow();
//        }
        sortTime = currentTimeMillis() - start;
        return this;
    }

    public Statistics performSearch(SearchAlgorithm algorithm) {
        final var start = currentTimeMillis();
        if (!isSorted) {
            algorithm = new LinearSearch();
        }
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
        System.out.println();
    }

    private String formatTime(final long timeMillis) {
        return String.format("%1$TM min. %1$TS sec. %1$TL ms.", timeMillis);
    }

    public static void setMaxTime(long time) {
        maxTime = time;
    }
}
