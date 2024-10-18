import java.util.*;
import java.util.Random;
public class Main
{
	public static void main(String[] args) {
		 Scanner reader= new Scanner(System.in);
		 String play="yes";
		 
		 while(play.equals("yes")){
		     Random rand =new Random();
		     int num = rand.nextInt(100)+1;
		     int guess = -1;
		     int tries=0;
		     
		     System.out.println("--* Guess a number between 0 to 100 *--");
		    while(guess!=num){
		        
		        guess=reader.nextInt();
		        tries++;
		        
		        if(guess==num){
		            System.out.println("You guessed it right!!! It only took you "+tries+" guesses");
		            System.out.println("Play again? Yes or No");
		            play=reader.next().toLowerCase();
		        }
		        else if(guess>num){
		            System.out.println("Too high!! Try again");
		        }
		        else {
		            System.out.println("Too low!! Try again");
		        }
		    }
		 }
		 reader.close();
	}
}
