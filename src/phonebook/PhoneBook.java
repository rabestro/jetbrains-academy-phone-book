package phonebook;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneBook {
    private List<PhoneBookEntry> records;

    public PhoneBook() {
        this.records = new ArrayList<>();
    }

    public PhoneBook(final String url) throws IOException {
        load(url);
    }

    void load(final String url) throws IOException {
        records = new Scanner(new URL(url).openStream(), "UTF-8")
                .useDelimiter("\\R")
                .tokens()
                .map(PhoneBookEntry::new)
                .collect(Collectors.toList());
    }
}
