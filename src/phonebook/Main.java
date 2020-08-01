package phonebook;

import java.io.IOException;

public class Main {
    private static final String DIRECTORY_URL = "https://stepik.org/media/attachments/lesson/197761/directory.txt";
    private static final String FIND_URL = "https://stepik.org/media/attachments/lesson/197761/find.txt";

    public static void main(String[] args) throws IOException {
        new Application(
                new PhoneBook(DIRECTORY_URL)
        ).run();
    }
}
