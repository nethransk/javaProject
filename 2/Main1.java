class BettingGame1 {
    int secretNumber;
    int betAmount;
    static int totalGames = 0;

    BettingGame1() {
        secretNumber = 5;
        betAmount = 100;
        totalGames++;
    }

    BettingGame1(int number, int bet) {
        secretNumber = number;
        betAmount = bet;
        totalGames++;
    }

    void playGame() {
        int guess = 8;

        System.out.println("\n=== Number Guessing Betting Game ===");
        System.out.println("Guessed Number: " + guess);
        System.out.println("Bet Amount: ₹" + betAmount);

        if (guess == secretNumber) {
            System.out.println("Congratulations! You won ₹" + (betAmount * 2));
        } else {
            System.out.println("Wrong Guess!");
            System.out.println("Correct Number was: " + secretNumber);
            System.out.println("You lost ₹" + betAmount);
        }
    }

    void playGame(int guess) {
        System.out.println("\n=== Number Guessing Betting Game ===");
        System.out.println("Guessed Number: " + guess);
        System.out.println("Bet Amount: ₹" + betAmount);

        if (guess == secretNumber) {
            System.out.println("Congratulations! You won ₹" + (betAmount * 2));
        } else {
            System.out.println("Wrong Guess!");
            System.out.println("Correct Number was: " + secretNumber);
            System.out.println("You lost ₹" + betAmount);
        }
    }

    static void showTotalGames() {
        System.out.println("\nTotal Games Created: " + totalGames);
    }
}

public class Main1 {
    public static void main(String[] args) {
        BettingGame1 game1 = new BettingGame1();
        game1.playGame();

        BettingGame1 game2 = new BettingGame1(8, 200);
        game2.playGame(8);

        BettingGame1.showTotalGames();
    }
}
