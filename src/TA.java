public class TA{
	public synchronized void ma() throws InterruptedException{
		System.out.println("in ma");
		Thread.currentThread().sleep(1000);
		System.out.println("leave ma");
	}
	public synchronized void mb(){
		System.out.println("in mb");
	}
	public static void main(String[] args){
		TA ta = new TA();
		RA ra = new RA(ta);
		RB rb = new RB(ta);
		Thread tra = new Thread(ra);
		Thread trb = new Thread(rb);
		trb.start();
		//tra.start();
		trb.start();
	}
}

class RA implements Runnable{
	TA t;
	public RA(TA t){
		this.t = t;
	}
	@Override
	public void run(){
		try {
			for(int i = 0; i < 1; i++)
			t.ma();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}

class RB implements Runnable{
	TA t;
	public RB(TA t){
		this.t = t;
	}
	@Override
	public void run() {
		for(int i = 0; i < 100; i++)
		t.mb();
	}
	
}