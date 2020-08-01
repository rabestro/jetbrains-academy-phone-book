package phonebook;

import java.util.List;

public class Application implements Runnable {

    private final PhoneBook phoneBook;
    private final List<String> names;

    public Application(final PhoneBook phoneBook, final List<String> names) {
        this.phoneBook = phoneBook;
        this.names = names;
    }

    @Override
    public void run() {


    }
}
