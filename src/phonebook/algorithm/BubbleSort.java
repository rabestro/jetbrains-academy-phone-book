package phonebook.algorithm;

import phonebook.Contact;

public class BubbleSort implements SortAlgorithm {
    @Override
    public void sort(Contact[] phoneBook) {
        for (int i = 0; i < phoneBook.length - 1; i++) {
            for (int j = 0; j < phoneBook.length - i - 1; j++) {
                if (phoneBook[j].getName().compareTo(phoneBook[j + 1].getName()) > 0) {
                    final var temp = phoneBook[j];
                    phoneBook[j] = phoneBook[j + 1];
                    phoneBook[j + 1] = temp;
                }
            }
        }
    }
}
