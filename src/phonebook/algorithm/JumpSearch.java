package phonebook.algorithm;

import phonebook.Record;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class JumpSearch implements SearchAlgorithm {
    @Override
    public long getNamesFound(Record[] phoneBook, String[] names) {

        final Function<String, Optional<Record>> jumpSearch = name -> {
            if (Objects.equals(name, phoneBook[0].getName())) {
                return Optional.of(phoneBook[0]);
            }
            final var jumpLength = (int) Math.sqrt(phoneBook.length);

            int currentRight = 0; // right border of the current block
            int prevRight = 0; // right border of the previous block

            /* Finding a block where the element may be present */
            while (currentRight < phoneBook.length - 1) {

                /* Calculating the right border of the following block */
                currentRight = Math.min(phoneBook.length - 1, currentRight + jumpLength);

                if (phoneBook[currentRight].getName().compareTo(name) >= 0) {
                    break; // Found a block that may contain the target element
                }
                prevRight = currentRight; // update the previous right block border
            }


            /* If the last block is reached and it cannot contain the target value => not found */
            if ((currentRight == phoneBook.length - 1) && name.compareTo(phoneBook[currentRight].getName()) > 0) {
                return Optional.empty();
            }

            for (int i = currentRight; i > prevRight; --i) {
                if (Objects.equals(name, phoneBook[i].getName())) {
                    return Optional.of(phoneBook[i]);
                }
            }
            return Optional.empty();
        };

        return Arrays.stream(names)
                .map(jumpSearch)
                .filter(Optional::isPresent)
                .count();

    }
}
