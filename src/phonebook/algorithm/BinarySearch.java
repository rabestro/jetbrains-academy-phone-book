package phonebook.algorithm;

import phonebook.Record;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

public class BinarySearch implements SearchAlgorithm {

    @Override
    public long getNamesFound(Record[] phoneBook, String[] names) {

        final Function<String, Optional<Record>> binarySearch = name -> {
            final var index = Arrays.binarySearch(phoneBook,
                    new Record("001 " + name),
                    Comparator.comparing(Record::getName));

            return (index >= 0) ? Optional.of(phoneBook[index]) : Optional.empty();
        };

        return Arrays.stream(names)
                .map(binarySearch)
                .filter(Optional::isPresent)
                .count();
    }
}
