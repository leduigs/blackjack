import java.util.Scanner;

class Bank{
		
		private static int balance = 100;
		private static int stake = 5;
		
		Bank(){
		}
		
		static Scanner input = new Scanner(System.in);
		
		public int getBalance(int balance){
			this.balance=balance;
			return balance;
		}
		
		public static int setStake(int new_stake){
			if(new_stake>25 || new_stake<5){
				System.out.println("Invalid Amount, please re-enter:");
				new_stake = input.nextInt();
			}
			stake = new_stake;
			return stake;
		}
		
		public static int finishBalance(){
			int x = Blackjack.calculateWinnings();
			if (x == 1){
				balance+=stake;
			}else if ( x == -1){
				balance-=stake;
			}else {
				
			}
			return balance;
			}
	}
		

