package phonebook;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final String DIRECTORY_URL = "https://stepik.org/media/attachments/lesson/197761/directory.txt";
    private static final String FIND_URL = "https://stepik.org/media/attachments/lesson/197761/find.txt";

    public static void main(String[] args) throws IOException {

        new Application(
                new PhoneBook(DIRECTORY_URL),
                new Scanner(new URL(FIND_URL).openStream(), "UTF-8")
                        .useDelimiter("\\R")
                        .tokens()
                        .collect(Collectors.toList())
        ).run();
    }
}
