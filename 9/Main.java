import java.util.Scanner;
import java.util.Random;
class Game {
int guess;
int number;
boolean available = false;
synchronized void enterGuess(int g) {
while (available) {
try {
wait();
} catch (InterruptedException e) {
System.out.println(e);
}
}
guess = g;
available = true;
notifyAll();
}
synchronized void checkGuess() {
while (!available) {
try {
wait();
} catch (InterruptedException e) {
System.out.println(e);
}
}
if (guess == number) {
System.out.println("Correct Guess!");
System.out.println("You won the bet!");
} else {
System.out.println("Wrong Guess!");
System.out.println("Correct number was: " + number);
}
available = false;
notify();
}
}
class Player extends Thread {
Game game;
Scanner sc;
Player(Game game, Scanner sc) {
this.game = game;
this.sc = sc;
}
public void run() {
System.out.print("Enter your guess (1-10): ");
int guess = sc.nextInt();
game.enterGuess(guess);
}
}
class Dealer extends Thread {
Game game;
Dealer(Game game) {
this.game = game;
}
public void run() {
game.number = new Random().nextInt(10) + 1;
game.checkGuess();
}
}
public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Game game = new Game();
System.out.println("===== NUMBER GUESSING BETTING GAME =====");
System.out.println("Starting Balance: Rs.100");
System.out.print("Enter betting amount: Rs.");
int bet = sc.nextInt();
if (bet <= 0 || bet > 100) {
System.out.println("Invalid betting amount!");
return;
}
Player player = new Player(game, sc);
Dealer dealer = new Dealer(game);
dealer.start();
player.start();
try {
player.join();
dealer.join();
} catch (InterruptedException e) {
System.out.println(e);
}
System.out.println("Game Over");
}
}
