package com.jpm.numbers;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * This is not a problem from the book.
 * 
 * Write code to read a math operation (ex: 1 + 2 * 3 / 4 ) from a string and display the result.
 * 
 * @author JPMagalhaes
 *
 */
public class ExpressionEvaluation {

	public static double evaluateExpression(String in) {
		if(in == null || in.length() == 0)
			return 0;
		
		StringTokenizer tokenizer = new StringTokenizer(in);
		
		Stack<Double> values = new Stack<>();
		Stack<String> operators = new Stack<>();
		
		while(tokenizer.hasMoreTokens()){
			String arg = tokenizer.nextToken();
			if(")".equals(arg)) {
				evaluate(values, operators);
			} else if(isOperator(arg)) {
				if(operators.size() > 0 && hasPrecedence(operators.peek(), arg))
					evaluate(values, operators);
				operators.push(arg);
			} else
				values.push(Double.parseDouble(arg));
		}
		while (values.size() > 1) {
			evaluate(values, operators);
		}
		
		return values.pop();
	}

	private static boolean hasPrecedence(String in1, String in2) {
		if((in1.equals("*") || in1.equals("/")) && (in2.equals("+") || in2.equals("-") || in2.equals("*")))
			return true;
		else
			return false;
	}

	private static void evaluate(Stack<Double> values, Stack<String> operators) {
		double v = values.pop();
		String op = operators.pop();
		if("+".equals(op)) v += values.pop();
		else if("-".equals(op)) v = values.pop() - v;
		else if("*".equals(op)) v *= values.pop();
		else if("/".equals(op)) v = values.pop() / v;
		values.push(v);
	}
	
	private static boolean isOperator(String arg){
		if("(".equals(arg) ||
			"+".equals(arg) || 
			"-".equals(arg) || 
			"*".equals(arg) || 
			"/".equals(arg)) {
				return true;
			} else {
				return false;
			}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] expressions = { "1 + 2 * 3 / 4", null, "", "1234", "1 + 1", "1 + 2 - 3", "4 / 2", "2 * 4 / 2", "( 4 / 2 ) * 2", "( 4 / 2 ) + 1", "1 + ( 4 / 2 )", "1 + ( 3 * 3 )", "1 + ( 3 * 3 ) + 2",
								 "1 + 1", "1 + 2 - 3", "4 / 2", "2 * 4 / 2", "4 / 2 * 2", "4 / 2 + 1", "1 + 4 / 2", "1 + 3 * 3", "1 + 3 * 3 + 2", "51 + 54 * ( 2 + 3 )"};
		double[] results = { 2.5, 0, 0, 1234, 2, 0, 2, 4, 4, 3, 3, 10, 12,
							 2, 0, 2, 4, 4, 3, 3, 10, 12, 321};
		int c = 0;
		for (int i = 0; i < results.length; i++) {
			double r = evaluateExpression(expressions[i]);
			System.out.println(expressions[i] + " = " + results[i] + " = " + r + "\t(" + (r == results[i] ? ++c : c) + "/" + (i+1) + ")" );
		}

	}

}
