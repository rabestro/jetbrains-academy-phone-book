package phonebook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

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
                new PhoneBook(
                        Files.readString(Path.of("/home/jegors/Downloads/directory.txt"))),
                new Scanner(Files.readString(Path.of("/home/jegors/Downloads/find.txt")))
                        .useDelimiter("\\R")
                        .tokens()
                        .toArray(String[]::new)
        ).run();
    }
}
