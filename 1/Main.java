class BettingGame {
    int secretNumber;
    int betAmount;

    BettingGame() {
        secretNumber = 5;
        betAmount = 100;
    }

    BettingGame(int number, int bet) {
        secretNumber = number;
        betAmount = bet;
    }

    void playGame() {
        int guess = 5;

        System.out.println("=== Number Guessing Betting Game ===");
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
}

public class Main {
    public static void main(String[] args) {
        BettingGame game1 = new BettingGame();
        game1.playGame();

        BettingGame game2 = new BettingGame(8, 200);
        game2.playGame();
    }
}
