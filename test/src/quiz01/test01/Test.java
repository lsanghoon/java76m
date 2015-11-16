/*
 * 문자열이 주어지면 괄호를 검사하여 잘 못되었을 경우 
 * false를 리턴하는 함수를 만들어라.
 */

package quiz01.test01;

import java.util.Stack;

public class Test {

	static boolean check(String content) {
		Stack<Character> stack = new Stack<Character>();
		char c;

		for (int i = 0; i <content.length(); i++) {
			c = content.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			else if (c == ')') {
				if (stack.peek() == '(')
					stack.pop();
				else
					return false;
			}
			else if (c == '}') {
				if (stack.peek() == '{')
					stack.pop();
				else
					return false;
			}
			else if (c == ']') {
				if (stack.peek() == '[')
					stack.pop();
				else
					return false;
			}
			//System.out.println(content.charAt(i));
		}

		if (stack.size() > 0) 
			return false;

		return true;
	}

	public static void main(String[] args) {
		String str = "tes( okik ()dd()ok { dkdkdkd [] dkddkk) sdkdfd)";
		check(str);
	}
}
