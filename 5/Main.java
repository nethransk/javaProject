import java.util.Scanner;

class BettingGame {
    int secretNumber;
    int betAmount;
    static int totalGames = 0;

    BettingGame() {
        secretNumber = 5;
        betAmount = 100;
        totalGames++;
    }

    BettingGame(int number, int bet) {
        secretNumber = number;
        betAmount = bet;
        totalGames++;
    }

    void playGame(Scanner sc) {
        System.out.println("\n=== Number Guessing Betting Game ===");
        System.out.println("Bet Amount: ₹" + betAmount);
        System.out.print("Enter your guess (1-10): ");

        int guess = sc.nextInt();

        if (guess == secretNumber) {
            System.out.println("🎉 You Won ₹" + (betAmount * 2));
        } else {
            System.out.println("❌ Wrong Guess!");
            System.out.println("Correct Number: " + secretNumber);
        }
    }

    void playGame(String name, Scanner sc) {
        System.out.println("\nWelcome " + name);
        playGame(sc);
    }

    void showType() {
        System.out.println("Game Type: Normal Betting Game");
    }

    static void displayGames() {
        System.out.println("\nTotal Games Created: " + totalGames);
    }
}

class PremiumBettingGame extends BettingGame {
    PremiumBettingGame(int number, int bet) {
        super(number, bet);
    }

    @Override
    void showType() {
        System.out.println("Game Type: Premium Betting Game");
    }
}

class RegularBettingGame extends BettingGame {
    RegularBettingGame(int number, int bet) {
        super(number, bet);
    }

    @Override
    void showType() {
        System.out.println("Game Type: Regular Betting Game");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Secret Number (1-10): ");
        int number = sc.nextInt();

        System.out.print("Enter Bet Amount: ");
        int bet = sc.nextInt();

        System.out.print("Enter Player Name: ");
        String name = sc.next();

        PremiumBettingGame game =
                new PremiumBettingGame(number, bet);

        game.showType();
        game.playGame(name, sc);

        BettingGame.displayGames();

        sc.close();
    }
}
