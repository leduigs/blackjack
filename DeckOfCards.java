
class DeckOfCards{
	
	private static int card_index=0;
	private static int deck_size=52;
	public static String[] card_names = new String[deck_size];
	public static int[] deck = new int[deck_size];{
		for(int i=0;i<deck.length;i++){
			deck[i]=individualValue(i);
			card_names[i]=getFullCard(i);
		}
	}
	
	DeckOfCards(){
		
	}
	
	// Draw card deals the top card of the deck, once shuffled this is random. The card index moves up to avoid the same card being selected twice.
	public static int drawCard(){ // TO DO - Write to the String array too so it stores the String value of the card
		card_index++;
		//System.out.println(card_names[card_index-1] + " had been drawn with a value of " + deck[card_index-1]);
		
		return deck[card_index-1];  // card index is always going to be 1 more than it should be when it enters the method so I want to take -1 for the actual location
	}
	
	public static String drawCardName(){
		return card_names[card_index-1];
	}
		
	public static void shuffle(){
		for (int i = 0; i < deck.length; i++) {
			// Generate an index randomly
			int index = (int)(Math.random() * deck.length);
			int temp = deck[i];
			String temp_string = card_names[i];
			deck[i] = deck[index];
			card_names[i] = card_names[index];
			deck[index] = temp;
			card_names[index] = temp_string;
	    }
	}


	// Method that calls on the suit and the card face names to store them in a String array
	public static String[] cardNames(){
		String[] card_names=new String[52];
		for(int i=0; i<52; i++){
			card_names[i]=getFace(i)+ " of " +getSuit(i);
		}
		return card_names;
	}
	
	public static String getFullCard(int x){
		String face = getFace(x) + " of " + getSuit(x);
		return face;
	}
	// A method to define what suit the card is
	public static String getSuit(int x){	
		String suit = "";
		if(x<13){
			suit = "Spades";
		}else if(x<26){
			suit = "Hearts";
		}else if(x<39){
			suit = "Diamonds";
		}else{
			suit = "Clubs";
		}
		return suit;
	}

	// A method to find out the face value of the card
	public static String getFace(int x){
		x=x%13;

		if(x==0){
			return "Ace";
		}else if(x==1){
			return "2";
		}else if(x==2){
			return "3";
		}else if(x==3){
			return "4";
		}else if(x==4){
			return "5";
		}else if(x==5){
			return "6";
		}else if(x==6){
			return "7";
		}else if(x==7){
			return "8";
		}else if(x==8){
			return "9";
		}else if(x==9){
			return "10";
		}else if(x==10){
			return "Jack";
		}else if(x==11){
			return "Queen";
		}else{
			return "King";
		}
	}

	// This method provides a numeric value of the card
	public static int individualValue(int x){//, int total){
		int value = 0;
		x=x%13;

		if(x==0){
			value = 11;
		}else if(x==1){
			value = 2;
		}else if(x==2){
			value = 3;
		}else if(x==3){
			value = 4;
		}else if(x==4){
			value = 5;
		}else if(x==5){
			value = 6;
		}else if(x==6){
			value = 7;
		}else if(x==7){
			value = 8;
		}else if(x==8){
			value = 9;
		}else if(x==9){
			value = 10;
		}else if(x==10){
			value = 10;
		}else if(x==11){
			value = 10;
		}else if(x==12){
			value = 10;
		}
		return value;				
	}
}
