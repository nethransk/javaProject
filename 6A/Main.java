import java.util.Scanner;

interface NumberGame {
    void setNumber(int number);
    void guessNumber(int guess);
}

interface Betting {
    void placeBet(int amount);
}

class BettingGame implements NumberGame, Betting {

    int secretNumber;
    int betAmount;

    public void setNumber(int number) {
        secretNumber = number;
    }

    public void placeBet(int amount) {
        betAmount = amount;
    }

    public void guessNumber(int guess) {
        if (guess == secretNumber) {
            System.out.println("Correct Guess!");
            System.out.println("You Won: ₹" + betAmount);
        } else {
            System.out.println("Wrong Guess!");
            System.out.println("You Lost: ₹" + betAmount);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BettingGame game = new BettingGame();

        System.out.print("Enter the secret number: ");
        int number = sc.nextInt();
        game.setNumber(number);

        System.out.print("Enter the bet amount: ₹");
        int bet = sc.nextInt();
        game.placeBet(bet);

        System.out.print("Guess the number: ");
        int guess = sc.nextInt();

        game.guessNumber(guess);

        sc.close();
    }
}
