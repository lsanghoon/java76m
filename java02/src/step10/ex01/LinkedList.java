package step10.ex01;

public class LinkedList {
	private Bucket start;
	private Bucket end;
	private int length;
	
	public LinkedList() {
		start = new Bucket();
		end = start;
	}
	
	public int add(Object value) {
		//1) end가 가리키는 버킷에 값을 저장한다.
		end.setValue(value);
		//2) 새로운 버킷을 만들고, 기존 벗킷 뒤에 연결한다.
		end.setNext(new Bucket());
		//3) end는 새 버킷을 가리킨다.
		end = end.getNext();
		//4) length를 하나 증가시킨다.
		length++;

		return 0;
	}
	
	public Object get(int index) {
		//0) index가 0보다 작거나 length보다 크거나 같다면 null을 리턴한다.
		if (index < 0 || index >= length)
			return null;
		//1) start 버킷에서 시작하여 index가 가리키는 버킷까지 이동한다.
		int pos = 0;
		Bucket cursor = start;
		while (pos < index) {
			cursor = cursor.getNext();
			pos++;
		}
		//2) 찾은 버킷에 들어있는 값을 리턴한다.
		return cursor.getValue();
	}
	
	public Object remove(int index) {
		if (index < 0 || index >= length)
			return null;
		
		Object removedValue = null;
		length--;
		
		if (index == 0) {
			removedValue = start.getValue();
			start = start.getNext();
			return removedValue;
		}
		
		int pos=0;
		Bucket cursor = start;
		
		while (pos < index - 1) {
			cursor = cursor.getNext();
			pos++;
		}

		removedValue = cursor.getNext().getValue();
		cursor.setNext(cursor.getNext().getNext());
		
		return removedValue;
	}
	
	public int size() {
		
		return length;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("0000");
		list.add("1111");
		list.add("22222");
		list.add("33333");
		list.add("4444");
		list.add("55555");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("----------------");
		
		System.out.println(list.remove(2));
		
		System.out.println("----------------");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("----------------");
		
		list.add("66666");
		list.remove(0);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("----------------");
		
		list.remove(4);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("----------------");
	}
}
