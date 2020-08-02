package phonebook.search;

import phonebook.PhoneBook;
import phonebook.PhoneBookEntry;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class JumpSearch implements SearchAlgorithm {
    @Override
    public long getNamesFound(PhoneBook phoneBook, String[] names) {

        final Function<String, Optional<PhoneBookEntry>> jumpSearch = name -> {
            if (Objects.equals(name, phoneBook.get(0).getName())) {
                return Optional.of(phoneBook.get(0));
            }
            final var jumpLength = (int) Math.sqrt(phoneBook.size());

            int currentRight = 0; // right border of the current block
            int prevRight = 0; // right border of the previous block

            /* Finding a block where the element may be present */
            while (currentRight < phoneBook.size() - 1) {

                /* Calculating the right border of the following block */
                currentRight = Math.min(phoneBook.size() - 1, currentRight + jumpLength);

                if (phoneBook.getName(currentRight).compareTo(name) >= 0) {
                    break; // Found a block that may contain the target element
                }
                prevRight = currentRight; // update the previous right block border
            }


            /* If the last block is reached and it cannot contain the target value => not found */
            if ((currentRight == phoneBook.size() - 1) && name.compareTo(phoneBook.getName(currentRight)) > 0) {
                return Optional.empty();
            }

            for (int i = currentRight; i > prevRight; --i) {
                if (Objects.equals(name, phoneBook.getName(i))) {
                    return Optional.of(phoneBook.get(i));
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
