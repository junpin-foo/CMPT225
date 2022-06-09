package arithmetic;

import java.util.*;

import binarytree.BTNode;
import binarytree.BinaryTree;
import org.w3c.dom.Node;

public class ArithmeticExpressions {

	final public static int PLUS = 0;
	final public static int MINUS = 1;
	final public static int MULT = 2;
	final public static int DIV = 3;
	static final List<String> opsStr = Arrays.asList("+", "-", "*", "/");

	public static boolean isOperation(String str) {
		return opsStr.contains(str);
	}

	public static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * converts infix notation to prefix notation
	 * @param infixExpression
	 * @return
	 */
	public static int order(String s) {   // * / + -
		if (s.equals("+") || s.equals("-"))
			return 1;
		else if (s.equals("/") || s.equals("*"))
			return 2;
		else
			return 0;
	}

	public static String infix2Prefix(String infixExpression) {
		Stack<String> OpStack = new Stack<String>(); // operator stack
		Stack<String> ObStack = new Stack<String>(); // object stack
		StringTokenizer infixTokenizer = new StringTokenizer(infixExpression);


		while (infixTokenizer.hasMoreTokens()) {
			String token = infixTokenizer.nextToken();

			if (token.equals("(")) {
				OpStack.push(token + " ");
			}

			else if (token.equals(")")) {
				while (!OpStack.isEmpty() && !OpStack.peek().equals("( ")) {
					String ob1 = ObStack.pop(); //object 1

					String ob2 = ObStack.pop(); // object 2

					String op = OpStack.pop(); // operator

					String temp = op + " " + ob2 + " " + ob1;
					ObStack.push(temp);
				}
				OpStack.pop();
			}
			else if (!isOperation(token)) {
				ObStack.push(token);
			}
			else {
				while (!OpStack.isEmpty() && order(token) <= order(OpStack.peek())) {
					String ob1 = ObStack.pop();

					String ob2 = ObStack.pop();

					String op = OpStack.pop();

					String temp = op + " " + ob2 + " " + ob1; // op + op2 + op1
					ObStack.push(temp);
				}
				OpStack.push(token);
			}
		}

		while (!OpStack.isEmpty()) {
			String ob1 = ObStack.pop();

			String ob2 = ObStack.pop();

			String op = OpStack.pop();

			String temp = op + " " + ob2 + " " + ob1;
			ObStack.push(temp);

		}

		return (ObStack.peek());
	}

	/**
	 * converts postfix notation to binary tree representation of an arithmetic expression
	 * @param infixExpression
	 * @return
	 */
	public static Double retArth(String s) {

		if (s.equals("+"))
			return 0.0;
		else if (s.equals("-"))
			return 1.0;
		else if (s.equals("/"))
			return 3.0;
		else if	(s.equals("*"))
			return 2.0;
		else
			return -1.0;
	}

	public static BTNode<Double> postfix2BinaryTree(String postfixExpression) {
		Stack<BTNode> NodeStack = new Stack<BTNode>();
		StringTokenizer postfixTokenizer = new StringTokenizer(postfixExpression);


		while (postfixTokenizer.hasMoreTokens()) {
			String token = postfixTokenizer.nextToken();

			if(isNumber(token)){
				Double value = Double.parseDouble(token);
				BTNode<Double> node = new BTNode(value);
				NodeStack.push(node);
			}
			else if(isOperation(token)){
				Double operator = retArth(token);
				BTNode<Double> temp = new BTNode<Double>(operator);

				temp.setRightChild(NodeStack.pop());
				temp.setLeftChild(NodeStack.pop());

				NodeStack.push(temp);
			}
		}

		return NodeStack.peek();
	}
}
