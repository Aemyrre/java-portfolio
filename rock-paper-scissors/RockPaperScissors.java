import java.util.Scanner;

public class RockPaperScissors {

    private int playerScore = 0;
    private int computerScore = 0;
    private int gameRound = 1;

    public static void main(String[] args) {
        RockPaperScissors app = new RockPaperScissors();
        app.run();
    }

    /**
     * Function Name: run
     * Inside the function:
     *  1. Provides insstruction to player
     *  2. Runs the game
     */
    public void run() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Let's play three (3) rounds of Rock Paper Scissors!");
            System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
            System.out.println("Are you ready? Write 'yes' if you are.");
            String playerResponse = scan.nextLine();

            if (playerResponse.equals("yes")) {
                System.out.println("Great!");

                while (gameRound <= 3) {
                    System.out.println("\nRound: " + gameRound);
                    System.out.println("rock - paper - scissors, shoot!");
                    String playerChoice = scan.next();
                    String computerChoice = computerChoice();
                    printResult(playerChoice, computerChoice);
                    gameRound++;
                }

                gameResult();
            } else {
                System.out.println("Darn, some other time...!");
            }
        }
    }

    /**
     * Function name: computerChoice - picks randomly between rock paper and
     * scissors
     * 
     * @return a choice (String).
     * 
     *  Inside the function:
     * 
     *  1. Picks a random number between 0 and 2.
     *  2. if 0: returns the choice 'rock'
     *  if 1: returns the choice 'paper'
     *  if 2: returns the choice 'scissors'
     */
    public String computerChoice() {
        int randomNumber = (int) (Math.random() * 3);
        switch (randomNumber) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            default:
                return "scissors";
        }
    }

    /**
     * Function name: result - It returns the result of the game.
     * 
     * @param yourChoice     (String)
     * @param computerChoice (String)
     * @return result (String)
     * 
     *  Inside the function:
     *  1. result is "You win!" if:
     *
     *  You: "rock" Computer: "scissors"
     *  You: "paper" Computer: "rock"
     *  You: "scissors" Computer: "paper"
     *
     *  2. result is "You lose" if:
     * 
     *  Computer: "rock" You: "scissors"
     *  Computer: "paper" You: "rock"
     *  Computer: "scissors" You: "paper"

     *  3. result is "It's a tie" if: Your choice equals computer choice.
     *  4. Otherwise, print "INVALID CHOICE" and exit the program.
     */

    public String result(String yourChoice, String computerChoice) {
        if ((yourChoice.equalsIgnoreCase("rock") && computerChoice.equalsIgnoreCase("scissors"))
                || (yourChoice.equalsIgnoreCase("paper") && computerChoice.equalsIgnoreCase("rock"))
                || (yourChoice.equalsIgnoreCase("scissors") && computerChoice.equalsIgnoreCase("paper"))) {
            playerScore++;
            return "You Win!";
        } else if ((computerChoice.equalsIgnoreCase("rock") && yourChoice.equalsIgnoreCase("scissors"))
                || (computerChoice.equalsIgnoreCase("paper") && yourChoice.equalsIgnoreCase("rock"))
                || (computerChoice.equalsIgnoreCase("scissors") && yourChoice.equalsIgnoreCase("paper"))) {
            computerScore++;
            return "You Lose";
        } else if (yourChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a tie";
        } else {
            return "INVALID CHOICE";
        }
    }

    /**
     * Function Name: printResult - It prints everything (your choice, computer choice,
     * result)
     * 
     * @param yourChoice     (String)
     * @param computerChoice (String)
     * @param result         (String)
     * 
     * Inside the function:
     *  1. prints everything:
     *  – prints: You chose: <your choice>
     *  – prints: The computer chose: <computer choice>
     *  – prints: <result>
     */

    public void printResult(String playerChoice, String computerChoice) {
        System.out.println("\nYou chose: " + playerChoice);
        System.out.println("The computer chose: " + computerChoice);
        System.out.println(result(playerChoice, computerChoice));
    }

    /**
     * Function Name: gameResult
     * Inside the function:
     * 
     *  1. prints: The score board.
     *  2. prints: The winner of the game.
     */
    public void gameResult() {
        System.out.println("\nScore Board:");
        System.out.println("Player Score: " + playerScore);
        System.out.println("Computer Score: " + computerScore + "\n");
        if (playerScore > computerScore) {
            System.out.println("Player wins!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

}
