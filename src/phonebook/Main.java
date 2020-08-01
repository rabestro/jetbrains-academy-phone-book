package phonebook;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    static {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
    }

    private static final String DIRECTORY_URL = "https://stepik.org/media/attachments/lesson/197761/directory.txt";
    private static final String FIND_URL = "https://stepik.org/media/attachments/lesson/197761/find.txt";

    public static void main(String[] args) throws IOException {
        log.info("Program started.");
        new Application(
                new PhoneBook(DIRECTORY_URL),
                new Scanner(new URL(FIND_URL).openStream(), StandardCharsets.UTF_8)
                        .useDelimiter("\\R")
                        .tokens()
                        .collect(Collectors.toList())
        ).run();
    }
}
