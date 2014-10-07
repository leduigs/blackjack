import java.util.Scanner;

public class TestBlackJack {

	public static void main(String[] args) {
		
			//DeckOfCards new_deck= new DeckOfCards();
			//new_deck.shuffle();
			Bank new_bank = new Bank();
			char play_again = 'y';
			Scanner input = new Scanner(System.in);
			
			do{
				System.out.println("Please enter your stake between €5 & €25:");
				int stake = input.nextInt();
				Bank.setStake(stake); 
				Blackjack game = new Blackjack();
				game.setupNewGame();
				Blackjack.hit();
				Blackjack.finishDealersPlay();
				Blackjack.calculateWinnings();
				Blackjack.displayWinner();
				System.out.println("Your current balance is: €" + Bank.finishBalance());
				
				System.out.println("Would you like to play again y/n:");

				play_again = input.next().charAt(0);
				
			}while(play_again!='n');
			
	}
}


