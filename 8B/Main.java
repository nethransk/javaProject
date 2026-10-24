import java.util.Scanner;
import java.util.Random;
class GuessingGame implements Runnable {
public void run() {
Scanner sc = new Scanner(System.in);
Random r = new Random();
int balance = 100;
int number = r.nextInt(10) + 1;
System.out.println("===== NUMBER GUESSING BETTING GAME =====");
System.out.println("Initial Balance: Rs." + balance);
System.out.print("Enter betting amount: Rs.");
int bet = sc.nextInt();
if (bet <= 0 || bet > balance) {
System.out.println("Invalid betting amount!");
return;
}
System.out.print("Enter your guess (1-10): ");
int guess = sc.nextInt();
if (guess == number) {
balance = balance + bet;
System.out.println("Congratulations! You guessed correctly.");
System.out.println("You won Rs." + bet);
} else {
balance = balance - bet;
System.out.println("Wrong Guess!");
System.out.println("Correct number is: " + number);
System.out.println("You lost Rs." + bet);
}
System.out.println("Final Balance: Rs." + balance);
}
}
public class Main {
public static void main(String[] args) {
GuessingGame game = new GuessingGame();
Thread t = new Thread(game);
t.start();
}
}
