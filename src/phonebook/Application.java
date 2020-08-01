package phonebook;

public class Application implements Runnable {

    private final PhoneBook phoneBook;

    public Application(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void run() {
    }
}
