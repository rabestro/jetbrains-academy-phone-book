package phonebook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    private static final Pattern LINE_DELIMITER = Pattern.compile("\\R");
    private static final String DIRECTORY = "/home/jegors/Downloads/directory.txt";
    private static final String NAMES = "/home/jegors/Downloads/find.txt";

    static {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        log.info("Program started.");

        new Application(
                new PhoneBook(Files.readString(Path.of(DIRECTORY))),
                LINE_DELIMITER
                        .splitAsStream(Files.readString(Path.of(NAMES)))
                        .toArray(String[]::new)
        ).run();
    }
}
