import java.util.Scanner;

public class RockPaperScissorsCopy {
    public static void main(String[] args) {
        RockPaperScissorsCopy app = new RockPaperScissorsCopy();
        app.startGame();
    }

    public void startGame() {
        try (var scan = new Scanner(System.in)) {
            System.out.println("Let's play Rock Paper Scissors!");
            System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
            System.out.println("Are you ready? Write 'yes' if you are.");
            var playerResponse = scan.nextLine();
            
            if (playerResponse.equals("yes")) {
                System.out.println("Great!");
                System.out.println("rock - paper - scissors, shoot!");
                String playerChoice = scan.next();
                String computerChoice = computerChoice();
                printResult(playerChoice, computerChoice);
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
     *         Inside the function:
     *         1. Picks a random number between 0 and 2.
     *         2. if 0: returns the choice 'rock'
     *         if 1: returns the choice 'paper'
     *         if 2: returns the choice 'scissors'
     */
    public String computerChoice() {
        int randomNumber = (int) (Math.random() * 3);
        switch (randomNumber) {
            case 0 : return "rock";
            case 1 : return "paper";
            default: return "scissors";
        }
    }

    /**
     * Function name: result - It returns the result of the game.
     * 
     * @param yourChoice     (String)
     * @param computerChoice (String)
     * @return result (String)
     * 
     *         Inside the function:
     * 
     *         1. result is "You win!" if:
     *
     *         You: "rock" Computer: "scissors"
     *         You: "paper" Computer: "rock"
     *         You: "scissors" Computer: "paper"
     *
     *         2. result is "You lose" if:
     * 
     *         Computer: "rock" You: "scissors"
     *         Computer: "paper" You: "rock"
     *         Computer: "scissors" You: "paper"
     *
     *         3. result is "It's a tie" if: Your choice equals computer choice.
     * 
     * 
     *         4. Otherwise, print "INVALID CHOICE" and exit the program.
     *
     *
     */

    public String result(String yourChoice, String computerChoice) {
        if ((yourChoice.equals("rock") && computerChoice.equals("scissors"))
                || (yourChoice.equals("paper") && computerChoice.equals("rock"))
                || (yourChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "You Win!";
        } else if ((computerChoice.equals("rock") && yourChoice.equals("scissors"))
                || (computerChoice.equals("paper") && yourChoice.equals("rock"))
                || (computerChoice.equals("scissors") && yourChoice.equals("paper"))) {
            return "You Lose";
        } else if (yourChoice.equals(computerChoice)) {
            return "It's a tie";
        } else {
            return "INVALID CHOICE";
        }
    }

    /**
     * Name: printResult - It prints everything (your choice, computer choice,
     * result)
     * 
     * @param yourChoice     (String)
     * @param computerChoice (String)
     * @param result         (String)
     * 
     *                       Inside the function:
     * 
     *                       1. prints everything:
     *                       – prints: You chose: <your choice>
     *                       – prints: The computer chose: <computer choice>
     *                       – prints: <result>
     */

    public void printResult(String yourChoice, String computerChoice) {
        System.out.println("\nYou chose: " + yourChoice);
        System.out.println("The computer chose: " + computerChoice);
        System.out.println(result(yourChoice, computerChoice));
    }
}
