import java.util.Scanner;
import java.util.Random;
class GuessingGame extends Thread {
public void run() {
Scanner sc = new Scanner(System.in);
Random r = new Random();
int number = r.nextInt(10) + 1;
int balance = 100;
int bet;
System.out.println("===== NUMBER GUESSING BETTING GAME =====");
System.out.println("Starting Balance: ₹" + balance);
System.out.println("Guess a number between 1 and 10");
System.out.print("Enter your bet amount: ₹");
bet = sc.nextInt();
if (bet > balance || bet <= 0) {
System.out.println("Invalid bet amount!");
return;
}
System.out.print("Enter your guess: ");
int guess = sc.nextInt();
if (guess == number) {
balance += bet;
System.out.println("Correct Guess!");
System.out.println("You won ₹" + bet);
} else {
balance -= bet;
System.out.println("Wrong Guess!");
System.out.println("The correct number was: " + number);
System.out.println("You lost ₹" + bet);
}
System.out.println("Final Balance: ₹" + balance);
}
}
public class Main {
public static void main(String[] args) {
GuessingGame game = new GuessingGame();
game.start();
}
}
