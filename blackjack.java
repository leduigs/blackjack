import java.util.Scanner;

class Blackjack {
	
	static int dealer_total=0;
	static int player_total=0;
	static int[] player_hand = new int[6]; // 6 is the max cards you can take
	static int[] dealers_hand = new int[6]; // Setting 6 to the limit
	static String[] display_players_hand = new String[6];
	static String[] display_dealers_hand = new String[6];
	
	// TO DO - Deal the names of the cards into String arrays showing the cards
	public void setupNewGame(){
		DeckOfCards new_DeckOfCards =new DeckOfCards();
		new_DeckOfCards.shuffle();
		
		// resets each hand to empty values
		for(int x=0; x<6; x++){
			player_hand[x]=0;
			dealers_hand[x]=0;
			display_dealers_hand[x]=null;
			display_players_hand[x]=null;
		}
		
		//Dealers First Card,  taking in an int and string value Draw card moves the index up so everytime it gets called it is okay to use drawCardName as this will read in the same index, they must be called together for accuracy
		dealers_hand[0] = DeckOfCards.drawCard();
		display_dealers_hand[0] = DeckOfCards.drawCardName();
		
		// Players first card
		player_hand[0] = DeckOfCards.drawCard();
		display_players_hand[0] = DeckOfCards.drawCardName();
		
		// Dealers Second card
		dealers_hand[1] = DeckOfCards.drawCard();
		display_dealers_hand[1] = DeckOfCards.drawCardName();
		
		// Players second hand,
		player_hand[1] = DeckOfCards.drawCard();	
		display_players_hand[1] = DeckOfCards.drawCardName();
		
		// Can remove these two lines in time
		System.out.println("The Dealers hand is \"" + display_dealers_hand[0] + "\" and " + "X");
		printHand(player_hand);
	}
		
	//
	public static void hit(){
		if(calculateScore(player_hand)!=21){

			char answer=' ';
			Scanner input = new Scanner(System.in);
			int i=2; // used to go to third location in the array for hand as the player will already have the first two cards
			
			
			while(player_total<21 && answer != 's'){
				isAce(player_hand);
				System.out.println("You have a total of " + calculateScore(player_hand) + " would you like to play or stick? please hit 'h' for hit and 's' for stick");
				answer = input.next().charAt(0);
				if(answer == 'h'){
					player_hand[i]+=DeckOfCards.drawCard();
					display_players_hand[i]+=DeckOfCards.drawCardName();				
					printHand(player_hand);
					i++;
					calculateScore(player_hand);	// Sets the new value of player_total to ensure still under 21
				}else{
					answer='s';
				} 
				
				if(player_total>21){
					System.out.println("Player Busts!");
				}
			}
		}
		
	}
	
	
	// TO DO - Display the string array of the users hand.
	public static void printHand(int[] player_hand){
		System.out.print("Your hand is : ");
		for(int i=0; i<player_hand.length; i++){
			if(player_hand[i]>0){	// If condition is to stop it printing the extra 0's that are defaulted into the hand
				System.out.print(display_players_hand[i] + " ; ");
			}
		}
		System.out.println();
	}
	
	
	
	public static int calculateScore(int[] hand){
		player_total=0;	// reset the player score to 0 as it will not increment the previous total
		for(int i=0; i<hand.length; i++){
			player_total+=hand[i];
		}
		return player_total;	
	}
	
	
	// Show the dealers second card 
	
	public static void finishDealersPlay(){
		int x = 2; // Mark the next point in the dealer array that a card can be placed into, 0 and 1 gone from the deal.
		
		//for(int i=0; i<dealers_hand.length; i++){
			dealer_total=dealers_hand[0]+dealers_hand[1];
		//}
		
		System.out.println("The Dealers hand is \"" + display_dealers_hand[0] + "\" and " + "\"" + display_dealers_hand[1] + "\"");
		
		// Dealer draws until he has greater than 17. The condition for the user stops the dealer if the player is already bust.
		while(dealer_total<17 && player_total<21){
			
			dealers_hand[x]=DeckOfCards.drawCard();
			display_dealers_hand[x]=DeckOfCards.drawCardName();
			System.out.println("The dealer drew a \"" + display_dealers_hand[x] +"\"");
			x++;
			dealer_total=0; //Reset dealer total to 0 to stop in doubling the score on the previous loop
			
			
			for(int i = 0; i<dealers_hand.length; i++){
				dealer_total+=dealers_hand[i];
			}
			
			if(dealer_total>21){
				for (int i = 0; i<dealers_hand.length; i++){
					if(dealers_hand[x]==11){
						dealers_hand[x]=1;
					}
				}
			}
			
			System.out.println("Dealer now has: " + dealer_total);
			
			
			// Just here to slow down the game for dramatics
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(dealer_total>21){
			System.out.println("Dealer busts");
		}

	}

	public static int calculateWinnings(){
		if(player_total==21 && dealer_total < player_total){
			return 1;
		}else if (player_total<=21 && dealer_total<player_total){
			return 1;
		}else if(dealer_total<=21 && dealer_total>player_total){
			return -1;
		}else if(player_total>21){
			return -1;
		}else if(dealer_total>21){
			return 1;
		}else{
			return 0;
		}
	}
	
	public static void displayWinner(){
		int x=calculateWinnings();
		
		//Display dealers final hand
		System.out.print("The Dealers Hand was: ");
		for(int i=0; i<dealers_hand.length; i++){
			if (display_dealers_hand[i]!=null){
				System.out.print(display_dealers_hand[i] + " ; ");
			}
		}

		System.out.println();
		
		// Display players final hand
		printHand(player_hand);
		
		if(x==1){
			System.out.println("Congrats Player has won");
		}else if (x==-1){
			System.out.println("Hard Luck, dealer wins");
		}else{
			System.out.println("Game was pushed");
		}
		
	}
	
	public static int[] isAce(int[] hand){
		Scanner input = new Scanner(System.in);
		for(int x=0; x<hand.length; x++){
			if (hand[x]==11 || hand[x] == 1){
				System.out.println("Do you want 11 or 1 on the ace?");
				hand[x]=input.nextInt();
			}
		}
		return hand;
	}	
		
}
