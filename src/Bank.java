public class Bank implements Runnable{
	private Account account; 
	public Bank(Account account){
		this.account = account; 
	}
	@Override
	public void run(){
		for(int i = 0 ; i < 10; i++){
			System.out.print("bank : ");
			account.addAmount(2);
		}
	}
	public static void main(String[] args){
		Account acc = new Account();
		Bank bank = new Bank(acc);
		Company com = new Company(acc);
		acc.setBalance(0);
		Thread tb = new Thread(bank);
		Thread tc = new Thread(com);
		System.out.println("Bank name : "+ tb.getName() + " " + tb.getId());
		System.out.println("Comany name : "+ tc.getName() + " " + tc.getId());

		tb.start();
		tc.start();
		try {
			tb.join();
			System.out.println("finished bank");
			tc.join();
			System.out.println("finished company");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Company implements Runnable{
	private Account account; 
	public Company(Account account){
		this.account = account; 
	}
	@Override
	public void run(){
		for(int i = 0; i < 10 ; i++){
			System.out.print("company : ");
			account.subtractAmount(2);
		}
	}
}