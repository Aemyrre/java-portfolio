import java.io.IOException;

public class Pokerito {

    private int playerMatches = 0;
    private int computerMatches = 0;
    private String playerCard = randomCard();
    private String computerCard = randomCard();

    public static void main(String[] args) throws IOException {
        var app = new Pokerito();
        app.run();
    }

    public void run() throws IOException {
        promptMessage();
        drawGameCards();
        drawFiveCards();
        gameResults();
    }

    public void promptMessage() throws IOException {
        System.out.println("Let's play Pokerito. Type anything when you're ready.");
        System.in.read();
        System.out.println("It's like Poker, but a lot simpler.");
        System.in.read();
        System.out.println("> There are two players, you and the computer.");
        System.out.println("> The dealer will give each player one card.");
        System.out.println("> Then, the dealer will draw five cards (the river)");
        System.out.println("> The player with the most river matches wins!");
        System.out.println("> If the matches are equal, everyone's a winner!");
        System.out.println("> Ready? Type anything if you are.");
        System.in.read();
    }

    public void drawGameCards() throws IOException{
        System.out.println("\nHere's your card:");
        System.out.println(playerCard);
        System.in.read(); System.in.read();
        System.out.println("\nHere's the computer's card:");
        System.out.println(computerCard);
    }

    public void drawFiveCards()  throws IOException{
        System.out.println("\nNow the dealer will draw five cards. Press enter to continue.");
        System.in.read(); System.in.read();

        for (int i = 1; i < 6; i++) {
            String drawnCard = randomCard();

            System.out.println("Card " + i + "\n\n");
            System.out.println(drawnCard + "\n");
            System.in.read();System.in.read();
            if (playerCard.equals(drawnCard)) {
                playerMatches++;
            }
            if (computerCard.equals(drawnCard)) {
                computerMatches++;
            }
        }
    }

    public void gameResults() {
        System.out.println("\nYour number of matches: " + playerMatches);
        System.out.println("Computer number of matches: " + computerMatches);
        if (playerMatches > computerMatches) {
            System.out.println("You win!");
        } else if (playerMatches < computerMatches) {
            System.out.println("The Computer wins!");
        } else {
            System.out.println("Everyone wins!");
        }
    }

    public String randomCard() {
        int number = (int) (Math.random() * 13) + 1;
        switch (number) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";
            case 2:
                return "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";
            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";
            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";
            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
            case 7:
                return "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
            case 8:
                return "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";
            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
            case 11:
                return "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";
            case 12:
                return "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";
            default:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";
        }
    }

}
