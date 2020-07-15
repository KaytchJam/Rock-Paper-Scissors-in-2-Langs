import java.util.Scanner;
import java.util.Random;

public class Sequence {
	Random rand = new Random();
	Scanner input = new Scanner(System.in);
	
	Setup player1 = new Setup();
	Setup comp1 = new Setup();
	
	final static String intro_txt = "\nWelcome to Rock, Paper, Scissors; the game will soon begin!";
	final static String spacing_txt = "---------------";
	final static String inquire_txt = "Choose the following: \na) Rock \nb) Paper \nc) Scissors";
	final static String p_win_txt = "The player wins!";
	final static String comp_win_txt = "The computer wins!";
	final static String replay_txt = "\nWould you like to play again? (y/n): ";
	
	public void compChoice() { // Computer choice (randomized)
		int num1 = rand.nextInt(3);
		comp1.choice = comp1.move[num1];
		comp1.pick = comp1.moveset[num1];
	}
	
	public int getChoice() { // Get player choice
		System.out.print("Enter your choice: ");
		String p_choice = input.next();
		p_choice.toLowerCase();
		if (p_choice.contains("a") || p_choice.contains("rock")) { return 0; } 
		else if (p_choice.contains("b") || p_choice.contains("paper")) { return 1; } 
		else if (p_choice.contains("c")|| p_choice.contains("scissors") || p_choice == "3") { return 2; }
		else { 
			System.out.println("Choice randomized.");
			return rand.nextInt(3); 
			}
	}
	
	public void assignChoice(int p1_choice) { // Set choices
		player1.choice = player1.move[p1_choice];
		player1.pick = player1.moveset[p1_choice];
	}
	
	public void compareMove(int p_move, int cpu_move) { // Compare rock, paper, or scissors
		int m_product = p_move * cpu_move;
		if (m_product < 0) {
			if (p_move < cpu_move) { player1.wins = true; }
			else if (p_move > cpu_move) { comp1.wins = true; }
		} else if (m_product >= 0) {
			if (p_move > cpu_move) { player1.wins = true; }
			else if (p_move < cpu_move) { comp1.wins = true; }
		}
	}
	
	public static void main(String[] args) { // The game runs here
		Sequence game = new Sequence();
		
		int round = 1;
		System.out.println(intro_txt);
		
		while (true) {
			
			System.out.println("\nROUND " + round);
			System.out.println(spacing_txt);
			System.out.println(inquire_txt);
			System.out.println(spacing_txt);
			
			game.player1.user = "Player";
			game.comp1.user = "Computer";
			game.assignChoice(game.getChoice());
			game.compChoice();
			
			System.out.println("\nThe player chose " + game.player1.pick + ", the computer chose " + game.comp1.pick + ".");
			
			game.compareMove(game.player1.choice, game.comp1.choice);
			
			if (game.player1.wins) {
				System.out.println(p_win_txt);
				game.player1.score++;
				game.player1.wins = false;
			} else if (game.comp1.wins) {
				System.out.println(comp_win_txt);
				game.comp1.score++;
				game.comp1.wins = false;
			} else { System.out.println("It's a tie!"); }
			
			System.out.println("\n" + spacing_txt);
			System.out.println("Player score: " + game.player1.score + "\nComputer score: " + game.comp1.score);
			System.out.println(spacing_txt);
			System.out.print(replay_txt);
			
			String try_again = game.input.next();
			try_again.toLowerCase();
			if (try_again.contains("y")) { round++; } // Do nothing
			else if (try_again.contains("n")) { break; } else { break; }
		}
	}
}
