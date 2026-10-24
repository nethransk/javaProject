import java.util.Scanner;
import java.util.Random;
class BettingGame {
int balance = 100;
int number;
BettingGame() {
Random r = new Random();
number = r.nextInt(10) + 1;
}
synchronized void play(int bet, int guess) {
if (bet > balance || bet <= 0) {
System.out.println("Invalid betting amount!");
return;
}
System.out.println("Bet Amount: Rs." + bet);
System.out.println("Your Guess: " + guess);
if (guess == number) {
balance = balance + bet;
System.out.println("Correct Guess!");
System.out.println("You won Rs." + bet);
} else {
balance = balance - bet;
System.out.println("Wrong Guess!");
System.out.println("Correct Number: " + number);
System.out.println("You lost Rs." + bet);
}
System.out.println("Current Balance: Rs." + balance);
}
}
class Player extends Thread {
BettingGame game;
int bet;
int guess;
Player(BettingGame game, int bet, int guess) {
this.game = game;
this.bet = bet;
this.guess = guess;
}
public void run() {
game.play(bet, guess);
}
}
public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
BettingGame game = new BettingGame();
System.out.println("===== NUMBER GUESSING BETTING GAME =====");
System.out.println("Starting Balance: Rs.100");
System.out.print("Enter betting amount: Rs.");
int bet = sc.nextInt();
System.out.print("Enter your guess (1-10): ");
int guess = sc.nextInt();
Player p1 = new Player(game, bet, guess);
Player p2 = new Player(game, bet, guess);
p1.start();
p2.start();
try {
p1.join();
p2.join();
} catch (InterruptedException e) {
System.out.println(e);
}
System.out.println("Game Over");
System.out.println("Final Balance: Rs." + game.balance);
}
}
