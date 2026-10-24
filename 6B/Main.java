import java.util.Scanner;

abstract class BettingGame {
    int secretNumber;
    int betAmount;

    abstract void setNumber(int number);
    abstract void placeBet(int amount);
    abstract void guessNumber(int guess);
}

class Game extends BettingGame {

    void setNumber(int number) {
        secretNumber = number;
    }

    void placeBet(int amount) {
        betAmount = amount;
    }

    void guessNumber(int guess) {
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
        Game game = new Game();

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
