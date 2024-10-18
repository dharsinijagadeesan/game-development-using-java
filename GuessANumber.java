import javax.swing.*;
import java.util.Random;

public class GuessANumber {
    public static void main(String[] args) {
        String play = "yes";

        while (play.equals("yes")) {
            Random rand = new Random();
            int num = rand.nextInt(100) + 1;
            int guess = -1;
            int tries = 0;

            JOptionPane.showMessageDialog(null, "--* Guess a number between 1 to 100 *--");

            while (guess != num) {
                String input = JOptionPane.showInputDialog(null, "Enter your guess:");
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game cancelled.");
                    return;
                }
                try {
                    guess = Integer.parseInt(input);
                    tries++;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                    continue;
                }

                if (guess == num) {
                    JOptionPane.showMessageDialog(null, "You guessed it right!!! It only took you " + tries + " guesses.");
                    play = JOptionPane.showInputDialog(null, "Play again? Yes or No").toLowerCase();
                } else if (guess > num) {
                    JOptionPane.showMessageDialog(null, "Too high!! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too low!! Try again.");
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Thank you for playing!");
    }
}
