/*
 * ArrayList에서 remove()한 뒤, 반복문 계속 수행한다.
 */

package jdbc2;

import java.util.ArrayList;

public class test01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("0000");
		list.add("1111");
		list.add("2222");
		list.add("3333");
		list.add("4444");
		list.add("5555");
		
		String item;
		for (int i = 0; i < list.size(); i++) {
			item = list.get(i);
			if (item.equals("3333")) {
				list.remove(i--);
				continue;
			}
			System.out.println(item);
		}
		
	}
}
