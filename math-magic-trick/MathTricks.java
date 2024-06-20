import java.io.IOException;
import java.lang.Math;
import java.util.Scanner;

public class MathTricks {

    public static void main(String[] args) throws IOException {
        var app = new MathTricks();
        app.run();
    }

    public void run() throws IOException {
        try (var scan = new Scanner(System.in)) {
            this.promptMessage();
            while (true) {
                this.startMagic();
                System.out.println("\nType 'yes' to play again.");
                scan.nextLine();
                var playerResponse = scan.nextLine();
                System.out.println();

                if (playerResponse.equalsIgnoreCase("yes")) {
                    continue;
                } else {
                    System.out.println("\nThank you for playing! (: ");
                    break;
                }

            }
        }
    }

    public void promptMessage() throws IOException {
        System.out.println("\nWelcome to mind-reading magic!");
        System.out.println("Before we start, if you're not great at math, you may want to use a calculator for this magic.");
        System.out.println("Are you ready? Press 'ENTER' key to be amazed!");
        System.in.read();
    }

    public int randomNumber() {
        return (int) (Math.random() * 5) + 1;
    }

    public void startMagic() throws IOException {
        switch (this.randomNumber()) {
            case 1:
                System.out.println("Think of a whole number from 1 to 10. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Multiply your number by 2. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Add 9 to the result. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Subtract 3 to the result. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Divide the result by 2. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Subtract the result using your original number. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Your result is 3!");
                break;
            case 2:
                System.out.println("Think of a whole number from 1 to 10. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Add the next higher number to your number. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Add 9 to the result. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Divide the result by 2. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Subtract the result using your original number. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Your result is 5!");
                break;
            case 3:
                System.out.println("Think of a whole number from 1 to 10. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Add 5 to your number. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Multiply 3 to the result. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Subtract 15 to the result. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Divide the result by your original number. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Add 7 to the result");
                System.in.read();
                System.in.read();
                System.out.println("Your result is 10!");
                break;
            case 4:
                System.out.println("Think of a whole number from 1 to 10. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Multiply your number by 2. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Multiply 5 to the result. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Divide the result by your original number. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Subtract 7 to the result");
                System.in.read();
                System.in.read();
                System.out.println("Your result is 3!");
                break;
            default:
                System.out.println("Think of a whole number from 1 to 10. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Multiply your number by 9. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Add the first and second digits of the result. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Add 4 to the result. Press 'enter' to continue.");
                System.in.read();
                System.in.read();
                System.out.println("Your result is 13!");
                break;
        }
    }
}