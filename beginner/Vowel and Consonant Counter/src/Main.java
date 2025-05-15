import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numOfVowels = 0;
        int numOfConsonants = 0;

        System.out.println("This is a Vowel and Consonant Counter, please enter your word:");

        Scanner scanner = new Scanner(System.in);

        String wordGiven = scanner.next();
        // String input = scanner.nextLine(); Allows the user to type a setence instead of only a word
        wordGiven= wordGiven.toLowerCase();

        for (int i=0; i<wordGiven.length(); i++) {

            char c = wordGiven.charAt(i);
            if (Character.isLetter(c)) {
                switch (c) {
                    case 'a', 'e', 'i', 'o', 'u' -> numOfVowels++;
                    default -> numOfConsonants++;
                }
            }

        }

        System.out.printf("The word Given has %d vowels and %d consonants", numOfVowels,numOfConsonants);

        scanner.close();
    }
}