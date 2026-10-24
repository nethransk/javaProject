import java.util.Scanner;
import java.util.Random;
class InvalidBetException extends Exception {
InvalidBetException(String msg) {
super(msg);
}
}
class BettingGame {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Random r = new Random();
int balance = 100;
try {
System.out.println("Balance: Rs." + balance);
System.out.print("Enter bet amount: ");
int bet = sc.nextInt();
if (bet <= 0 || bet > balance)
throw new InvalidBetException("Invalid bet amount!");
int number = r.nextInt(10) + 1;
System.out.print("Guess a number (1-10): ");
int guess = sc.nextInt();
System.out.println("Correct number: " + number);
if (guess == number) {
balance += bet;
System.out.println("You won Rs." + bet);
} else {
balance -= bet;
System.out.println("You lost Rs." + bet);
}
System.out.println("Final balance: Rs." + balance);
} catch (InvalidBetException e) {
System.out.println("Exception: " + e.getMessage());
}
sc.close();
}
}
