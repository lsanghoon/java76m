package step10.ex03;

public class Queue {
	Bucket front;
	Bucket rear;
	int length;
	
	public Queue() {
		front = new Bucket();
		rear = front;
	}
	
	public int put(Object value) {
		rear.setValue(value);
		rear.setNext(new Bucket());
		rear = rear.getNext();
		length++;
		return 0;
	}
	
	public Object get() {
		//Object getValue = null;
		if (length == 0)
			return null;
		Object value = front.getValue();
		front = front.getNext();
		length--;
		return value;
		
	}
	
	public int size() {
		return length;
	}
	
	public static void main(String[] args) {
		Queue list = new Queue();
		list.put("0000");
		list.put("1111");
		list.put("22222");
		list.put("33333");
		list.put("4444");
		list.put("55555");
		
		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(list.get());
		}
	}
}
