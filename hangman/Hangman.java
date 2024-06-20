import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = randomWord();
        char[] wordArray = word.toCharArray();
        char[] placeholder = new char[wordArray.length];
        ArrayList<Character> missedGuess = new ArrayList<>();
        Arrays.fill(placeholder, '_');
        int countMiss = 0;
        
        while (true) {
            System.out.println();
            System.out.println(gallows[countMiss]);

            System.out.print("Word:\t");
            printPlaceholder(placeholder);

            System.out.print("\n\nMisses: ");
            printMissedGuesses(missedGuess, 0);

            System.out.print("\n\nGuess: ");
            char guess = scan.nextLine().charAt(0);

            boolean checker = checkGuess(wordArray, guess);
            if (checker == true) {
                updatePlaceholder(wordArray, placeholder, guess);
                if (Arrays.equals(wordArray, placeholder)) {
                    System.out.println();
                    System.out.println(gallows[countMiss]); 

                    System.out.print("Word:\t");
                    printPlaceholder(placeholder);

                    System.out.println("\n\nGOOD WORK! You win!");
                    break;
                }
            } else {
                    missedGuess.add(guess);
                    countMiss++;
                    if (countMiss == 6) {
                        System.out.println();
                        System.out.println(gallows[countMiss]);

                        System.out.println("RIP! You Lose.");
                        System.out.println("\nThe word was: " + word);
                        break;
                    }
            } 
        }
        scan.close();
    }

    /**
     * Function name: randomWord()
     *  1. generates a random number from the word array.
     * @return corresponding word
     */
    public static String randomWord() {
        int word = (int) (Math.random() * words.length);
        return words[word];
    }

    public static boolean checkGuess(char[] word, char guess) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guess) {
                return true;
            }
        }
        return false;
    }

    public static void updatePlaceholder(char[] word, char[] placeholder, char guess) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guess) {
                placeholder[i] = guess;
            }
        }
    }

    public static void printPlaceholder(char[] placeholder) {
        for (int i = 0; i < placeholder.length; i++) {
            System.out.print(placeholder[i] + " ");
        }
    }

    public static void printMissedGuesses(ArrayList<Character> missedGuess, int i) {
        for (Character character : missedGuess) {
            System.out.print(character);
        }
    }

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = 
        {"+---+\n" +
        "|   |\n" +
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",

        "+---+\n" +
        "|   |\n" +
        "O   |\n" +
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",

        "+---+\n" +
        "|   |\n" +
        "O   |\n" +
        "|   |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",

        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|   |\n" +
        "     |\n" +
        "     |\n" +
        " =========\n",

        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
        "     |\n" +
        "     |\n" +
        " =========\n",

        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" +
        "/    |\n" +
        "     |\n" +
        " =========\n",

        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" + 
        "/ \\  |\n" +
        "     |\n" +
        " =========\n"};

}





