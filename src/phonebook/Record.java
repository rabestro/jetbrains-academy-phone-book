package phonebook;

public class Record {
    private final String phone;
    private final String name;

    public Record(final String line) {
        var tokens = line.split(" ", 2);
        phone = tokens[0];
        name = tokens[1];
    }

    public String getName() {
        return name;
    }

}
