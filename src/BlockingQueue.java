public class BLockingQueue <T>{
	
	Queue<T> queue = new Queue<T>();
	int limit;
	
	public void enqueue(T t) {
		int size = queue.size();
		while(size >= limit) {
			wait();
			size = queue.size();
		}
		queue.enqueue(t);
		notifyAll();
	}
	
	public T dequeue() {
		int size = queue.size();
		while(size <= 0) {
			wait();
			size = queue.size();
		}
		T t = queue.dequeue();
		notifyAll();
		return t;
	}
	
}