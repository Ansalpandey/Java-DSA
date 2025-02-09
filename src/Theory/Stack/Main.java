package Theory.Stack;

public class Main {
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(5);
		stack.push(5);

		System.out.println("Top element is: " + stack.peek());
		System.out.println("Stack size is " + stack.size());

		System.out.println("Popped element is: " + stack.pop());
		System.out.println("Popped element is: " + stack.pop());

		System.out.println("Top element is: " + stack.peek());
		System.out.println("Stack size is " + stack.size());
	}
}
