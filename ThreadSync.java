class Callme {
	void call(String msg){
		System.out.print("["+msg);
		try{
			Thread.sleep(1000);

			System.out.print("]");
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
	}
}

class Caller implements Runnable{
	String text;
	Callme target;
	Thread t;
	
	public Caller(Callme cm, String st){
		target=cm;
		text=st;
		Thread t= new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(target){
			target.call(text);
		}
		
	}
	
}
public class ThreadSync {

	public static void main(String[] args) {
		Callme target =new Callme();
		Caller cl1 = new Caller(target,"Hi");
		Caller cl2 = new Caller(target,"Yogesh");
		Caller cl3 = new Caller(target,"Khot");
	

	}

}
