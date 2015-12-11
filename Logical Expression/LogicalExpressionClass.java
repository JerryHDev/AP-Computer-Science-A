import java.util.*;
import java.util.concurrent.*;


/*
 * Jerry Huang
 * APCS
 * Period 2
 * Logical Expression Final Project
 *
 * Program credits to Gregory Jerian, Sean Chapman, Blake Novak, and Shivum Agarwal for
 * helping with the program and the truth table. We worked together in order to solve the
 * problems that we couldn't solve by ourselves, and were able to figure out a solution as
 * a team and understand how to get the code to produce the expected result.
 * 
 * Video source used to aid in my understanding of the Shunting-Yard Algorithm: https://www.youtube.com/watch?v=QzVVjboyb0s
 */


public class LogicalExpressionClass implements LogicalExpression {
	
	// Initialize variables
	String infix;
	ArrayList<Character> array = new ArrayList<Character>();
    Stack<Character> stack = new Stack<Character>();
    ArrayBlockingQueue<Character> queue;
    ArrayList<Character> varsArray = new ArrayList<Character>();
    int[][] truthTable;
    ArrayList<Integer> answersArray = new ArrayList<Integer>();
    ArrayList<Character> RPN = new ArrayList<Character>();
    
    
    /**
     * Main method to test program.
     * Creates four instances of LogicalExpressionClass 
     * @param args
     */
    public static void main(String[] args) {
    	
    	// Create 4 logical expressions to test
        LogicalExpressionClass logic = new LogicalExpressionClass("A|B&C|d&L|A");
        System.out.println("Contingent: " + logic.contingent());
        System.out.println("Valid: " + logic.valid());
        System.out.println("Satisfiable: " + logic.satisfiable());
        LogicalExpressionClass logic2 = new LogicalExpressionClass("~b|a");
        System.out.println("Contingent: " + logic2.contingent());
        System.out.println("Valid: " + logic2.valid());
        System.out.println("Satisfiable: " + logic2.satisfiable());
        LogicalExpressionClass logic3 = new LogicalExpressionClass("~c|~(b&d)");
        System.out.println("Contingent: " + logic3.contingent());
        System.out.println("Valid: " + logic3.valid());
        System.out.println("Satisfiable: " + logic3.satisfiable());
        LogicalExpressionClass logic4 = new LogicalExpressionClass("((a|b)|~c)");
        System.out.println("Contingent: " + logic4.contingent());
        System.out.println("Valid: " + logic4.valid());
        System.out.println("Satisfiable: " + logic4.satisfiable());
        
        System.out.println("\n-1: False, 1 = True");
        System.out.println("Logic sentence 1 is equivalent to logic sentence 2: " + logic.equivalent(logic2));
        System.out.println("Logic sentence 2 is equivalent to logic sentence 3: " + logic2.equivalent(logic3));
    }
    
    
    /**
     * Arg-constructor
     * @param infix
     */
    public LogicalExpressionClass(String infix) {
    	
    	this.infix = infix;
    	// Prints the original infix form
    	System.out.println("\nOriginal infix form: " + infix);
    	
    	fillArray();
    	getVars();
        queue = new ArrayBlockingQueue<Character>(array.size());
        convertToRPN();
        System.out.println("The RPN form of the logical expression: " + queue);

        queueToArray();
        truthTable();
        System.out.println("All possible true and false solutions: " + answersArray);
    }
    
    
    /**
     * Fills array with all the elements of infix expression
     */
    public void fillArray() {
    	for (int i = 0; i < infix.length(); i++)
            array.add(infix.charAt(i));
    }
    
    
    /**
     * Identifies the variables in the array and adds them to varsArray
     */
    public void getVars() {
        for (int i = 0; i < array.size(); i++) {
                if (array.get(i) != '(' && array.get(i) != ')' && array.get(i) != '|' &&
                                array.get(i) != '&' && array.get(i) != '~' && !varsArray.contains(array.get(i))) {
                                varsArray.add(array.get(i));              
                }
        }
    }
    
    /**
     * Uses the Shunting-Yard algorithm to convert infix form to reverse polish notation
     */
    public void convertToRPN() {
    	for (int i = 0; i < array.size(); i++) {
    		if (isVar(array.get(i))) {
    			Character q = array.get(i);
                //System.out.println("q=" + q);
                queue.add(q);
            }
            else if (isNot(array.get(i)) || isAndOrOr(array.get(i))) {
            	while (!stack.empty() && higherPrecedence(array.get(i), stack.peek())) {
                    Character q3 = stack.pop();
                    queue.add(q3);
            	}
            	Character q2 = array.get(i);
            	stack.add(q2);
            }
            else if (array.get(i) == '(') {
                stack.add(array.get(i));
            }
            else {
            	while (!stack.empty() && stack.peek() != '(') {
                     Character x = stack.pop();
                     queue.add(x);
            	}
	             if (!stack.empty()) {
	            	 stack.pop();
	             }
            }
    	}
	    while(!stack.empty()) {
	    	queue.add(stack.pop());
	    }
	}
    
    
    /**
     * Determines the precedence between two chars.
     * @param a
     * @param b
     * @return boolean
     */
    public static boolean higherPrecedence(char a, char b) {
    	
    	if (b == '(') return false;
    	
    	if (a == '~') {
    		if (b == '~') 
    			return true;
    		else 
    			return false;
    	}
    	else if (a == '&') {
    		if (b == '&' || b == '~')
    			return true;
    		else
    			return false;
    	}
    	else
    		return true;
    }
    
    
    /**
     * Prints the truth table of all the combinations of truths
     */
    public void truthTable() {
    	System.out.println("All possible true and false combinations:");
        int numColumns = varsArray.size();
        int numRows = (int) Math.pow(2,numColumns);
        truthTable = new int[numColumns][numRows];
        for (int i = 0; i < numRows; i++) {
                for (int j = numColumns - 1; j >= 0; j--) {
                        truthTable[j][i] = (i / (int) Math.pow(2, j)) % 2;
                }
        }

        Queue<Character> tempQueue;
        for (int row = 0; row < numRows; row++) {
                tempQueue = new LinkedList<Character>();
                int column = 0;
                for (int index = 0; index < RPN.size(); index++) {
                        if (isVar(RPN.get(index)) && column < numColumns) {
                                column = varsArray.indexOf(RPN.get(index));
                                int num = truthTable[column][row];
                                if (num == 0)
                                        tempQueue.add('0');
                                else if (num == 1)
                                        tempQueue.add('1');
                                else
                                        System.out.println("lol");
                                }
                        else if (isNot(RPN.get(index))) {
                                tempQueue.add('~');
                        }
                        else if (isAndOrOr(RPN.get(index))) {
                                if (RPN.get(index) == '&') {
                                        tempQueue.add('&');
                                }
                                else if (RPN.get(index) == '|') {
                                        tempQueue.add('|');
                                }
                                else {
                                        System.out.println("This should not happen.");
                                }
                        }
                        else {
                                System.out.println("This should not happen.");
                        }
                }
                System.out.println(tempQueue);
                int retval = evaluate(tempQueue);
                answersArray.add(retval);
        }
}
    
        /**
         * Evaluates the logical expression.
         * @param inQueue
         */
        public static int evaluate(Queue<Character> inQueue) {
                Stack<Character> tempStack = new Stack<Character>();
                int size = inQueue.size();
                for (int i = 0; i < size; i++) {
                        if (!inQueue.isEmpty() && isVar(inQueue.peek()))
                                tempStack.add(inQueue.remove());
                        else if (!inQueue.isEmpty() && isNot(inQueue.peek())) {
                                inQueue.remove();
                                char temp = tempStack.pop();
                                if (temp == '0')
                                        tempStack.add('1');
                                else
                                        tempStack.add('0');
                        }
                        else if (!inQueue.isEmpty() && isAndOrOr(inQueue.peek())) {
                                char operator = inQueue.remove();
                                char operand2 = tempStack.pop();
                                char operand1 = tempStack.pop();
                                if (operator == '|') {
                                        if (operand1 == '0') {
                                                if (operand2 == '0')
                                                        tempStack.add('0');
                                                else
                                                        tempStack.add('1');
                                        }
                                        else
                                                tempStack.add('1');
                                }
                                else {
                                        if (operand1 == '0')
                                                tempStack.add('0');
                                        else {
                                                if (operand2 == '0')
                                                        tempStack.add('0');
                                                else
                                                        tempStack.add('1');
                                        }
                                }
                        }
 
                }
                if (tempStack.peek() == '0')
                        return 0;
                else
                        return 1;
        }
        
        /**
         * Converts a queue to array
         */
        public void queueToArray() {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                        RPN.add(queue.remove());
                }
                for (int i = 0; i < size; i++) {
                        queue.add(RPN.get(i));
                }
        }
       
        
        /**
         * Methods that determine what the operator is
         * @param ch
         * @return
         */
        public static boolean isAndOrOr(char ch) {
                return ch == '&' || ch == '|';
        }
        public static boolean isNot(char ch) {
                return ch == '~';
        }
        public static boolean isParentheses(char ch) {
                return ch == '(' || ch == ')';
        }
        public static boolean isVar(char ch) {
                return isParentheses(ch) == false && isAndOrOr(ch) == false && isNot(ch) == false;
        }
       
        
        /**
         * Receives access for answers array
         * @return
         */
        public ArrayList<Integer> getAnswers() {
                return answersArray;
        }
       
        /**
         * Tests if the logical expression is valid
         */
        public boolean valid() {
                for (int i = 0; i < answersArray.size(); i++) {
                        if (answersArray.get(i) == 0)
                                return false;
                }
                return true;
        }
        
        /**
         * Tests if the logical expression is satisfiable
         */
        public boolean satisfiable() {
                return valid() || contingent();
        }
       
        /**
         * Tests if the logical expression is contingent
         */
        public boolean contingent() {
                boolean atLeastOneTrue = false;
                boolean atLeastOneFalse = false;
                for (int i = 0; i < answersArray.size(); i++) {
                        if (answersArray.get(i) == 0)
                                atLeastOneFalse = true;
                        else
                                atLeastOneTrue = true;
                        if(atLeastOneFalse && atLeastOneTrue)
                                return true;
                }
                return false;
        }
       
        /**
         * Tests if the logical expression is equivalent to another logical expression
         */
        public int equivalent(LogicalExpressionClass that) {
                for (int i = 0; i < answersArray.size(); i++) {
                        if (this.answersArray.get(i) != that.getAnswers().get(i))
                                return -1;
                }
                return 1;
        }
       
        /**
         * Tests if the logical expression entails another logical expression
         */
        public int entails(LogicalExpressionClass that) {
                for (int i = 0; i < answersArray.size(); i++) {
                        if (this.answersArray.get(i) == 1) {
                                if (that.answersArray.get(i) == 0)
                                        return -1;
                        }
                }
                return 1;
        }
}