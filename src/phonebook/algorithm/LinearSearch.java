package phonebook.algorithm;

import phonebook.Record;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class LinearSearch implements SearchAlgorithm {

    @Override
    public long getNamesFound(Record[] phoneBook, String[] names) {
        final Function<String, Optional<Record>> linearSearch = name -> {
            for (int i = phoneBook.length; i-- > 0; ) {
                if (Objects.equals(name, phoneBook[i].getName())) {
                    return Optional.of(phoneBook[i]);
                }
            }
            return Optional.empty();
        };

        return Arrays.stream(names)
                .map(linearSearch)
                .filter(Optional::isPresent)
                .count();
    }

}
