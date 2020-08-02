package phonebook.search;

import phonebook.PhoneBook;
import phonebook.PhoneBookEntry;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class LinearSearch implements SearchAlgorithm {

    @Override
    public long getNamesFound(PhoneBook phoneBook, String[] names) {

        final Function<String, Optional<PhoneBookEntry>> linearSearch = name -> {
            for (int i = phoneBook.size(); i-- > 0; ) {
                if (Objects.equals(name, phoneBook.getName(i))) {
                    return Optional.of(phoneBook.get(i));
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
