package phonebook;

public class PhoneBookEntry {
    private final String phone;
    private final String name;

    PhoneBookEntry(final String line) {
        var tokens = line.split(" ");
        phone = tokens[0];
        name = tokens[1];
    }
}
