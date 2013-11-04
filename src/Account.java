public class Account {
	private double balance;
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public synchronized void addAmount(double amount){
		double temp = balance; 
		System.out.println(Thread.currentThread().getName() + " : add "+amount+"from "+ this.getBalance());
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		temp += amount;
		balance = temp;
		System.out.println("F Add to "+ this.getBalance());
		notifyAll();
		this.notify();
	}
	public synchronized void subtractAmount(double amount){
		System.out.println(Thread.currentThread().getName() + " : sub "+amount+"from "+ this.getBalance());
		while(balance <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		double temp = balance;
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		temp -= amount;
		balance = temp;
		System.out.println("F sub to "+ this.getBalance());
		notifyAll();
	}
}