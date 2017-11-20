package eecs2030.lab6;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A utility class containing several recursive methods (Lab 6, F2017)
 * 
 * <pre>
 * 
 * For all methods in this API, you are forbidden to use any loops, nor 
 * String or List based methods such as "contains", or methods that use regular expressions
 * </pre>
 * 
 * @author 
 *
 */
public final class RecursiveTasks {

	private RecursiveTasks() {}
	
	
	/**
	 * getParenthesis returns the component within a given string that is
	 * enclosed in parenthesis
	 * 
	 * <br>
	 * The method assumes there is only a single pair of parenthesis in the
	 * string, and computes the new string recursively, such that the new string
	 * is only made of the parenthesis and their contents.
	 * 
	 * E.g. 
	 * <pre>
	 * <code>getParenthesis("abcd(xyz)qrst")</code> will return "(xyz)"
	 * </pre>
	 * 
	 * @param str the input string (with one pair of parenthesis embedded within)
	 * @return a string made only of the parenthesis and their contents (from str)
	 */
	public static String getParenthesis(String str) {
		if(str.length() == 0) {
			return null;
		}		
		if(str.startsWith("(") && str.endsWith(")"))
		{
		return str;
		}
		if (!str.startsWith("("))
		{
			str = str.substring(1, str.length());
			//System.out.println(str);
			return RecursiveTasks.getParenthesis(str);

		}
		else if(!str.endsWith(")"))
		 {
			 str = str.substring(0, str.length() - 1);
				//System.out.println(str);
			return  RecursiveTasks.getParenthesis(str);
		 }		
		
			return str;

			}
	

	/**
	 * Count the number of co-occurrances of a non-empty sub-string
	 * <code>sub</code> within the string <code>str</code>
	 * 
	 * E.g. 
	 * <pre>
	 * <code>numOccurances("dogmonkeydog","dog")</code> will return 2
	 * <code>numOccurances("dogmonkeydog","mon")</code> will return 1
	 * <code>numOccurances("dogmonkeydog","cow")</code> will return 0
	 * </pre>
	 * 
	 * @param str the given string
	 * @param sub a non-empty sub-string
	 * @return the number of times sub occurs in str, without overlap
	 * 
	 */
	public static int numOccurrences(String str, String sub) {
		if (str.equals(sub))
		{			
			return 1;
		}
		if (str.length() < sub.length() )
		{
			 return 0;
		}
		if(str.startsWith(sub))
			{
				return 1+ RecursiveTasks.numOccurrences(str.substring(sub.length(), str.length()), sub);
				
			}
		if(str.endsWith(sub))
		{
			return 1+ RecursiveTasks.numOccurrences(str.substring(0, str.length()-sub.length()), sub);
			
		}
		else 
		{	
			return RecursiveTasks.numOccurrences(str.substring(1, str.length()), sub);
		}
		

	}

	
	/**
	 * Given a string, return true if it is a nesting of zero or more pairs of
	 * balanced parenthesis, like "(())" or "((()))".
	 * 
	 * If the parenthesis are unbalanced, or the string includes characters
	 * other than parenthesis, return false
	 * 
	 * E.g.
	 * <pre>
	 * <code>parenthIsNested("(())")</code> will return true
	 * <code>parenthIsNested("((()))")</code> will return true
	 * <code>parenthIsNested("(((x))")</code> will return false
	 * </pre>
	 * 
	 * Hint: check the first and last chars, and then recur on what's inside
	 * them.
	 * 
	 * @param str
	 *            - the string (includes zero or more pairs of parenthesis)
	 * @return a boolean value indicating true if the string contains nested and balanced parenthesis, false otherwise
	 */
	public static boolean parenthIsNested(String str) {
	
		if(str.startsWith("(") && str.endsWith(")"))
				{
						return RecursiveTasks.parenthIsNested(str.substring(1, str.length()-1));
				}
		if (str.startsWith("(") && !str.endsWith(")"))
		{
			return false;
		}
		if (!str.startsWith("(") && str.endsWith(")"))
		{
			return false;
		}
		if (str.startsWith("(") && str.endsWith(")") && str.length() == 2)
		{
			return true;
		}
		if (str.length() % 2 != 0)	// if the size is  odd then mostlikely a base case 
		{
			return false;
		}
		return true;

	}



	
	
	
	/**
	 * Generates a list of Circles to be used in drawing a fractal pattern
	 * 
	 * <pre>
	 * This method accepts a List of Circles (see Helper classes Circle.java and
	 * FractalPatterns.java To see how the list of Circles is generated, and how
	 * this method is envoked). You do not to perform any drawing operations in
	 * this task (they are done for you).
	 * 
	 * The method computes the position of, and creates 4 new circles at each
	 * recursion step. Each circle is positioned at the vertical (top and
	 * bottom) and horizontal (left and right) intercepts with a imaginary
	 * circle (centred on x,y and with radius = <code>radius</code>). The radius
	 * of each circle created, is radius/2.
	 * 
	 * The centre position of each newly generated circle will form the centre
	 * of a new set of 4 circles in the next recursive step, each with a reduced
	 * radius of (radius/4), and drawn on the vertical and horizontal intercepts
	 * of its parent circle, and so on (see diagram in lab description).
	 *
	 * </pre>
	 * 
	 * 
	 * @param circles a list in which to store circles as they are generated
	 * @param x the x coord of the centre of the current set of circles
	 * @param y the y coord of the centre of the current set of circles
	 * @param radius the radius of the parent circle
	 * @param n number of recursive steps to generate circles for
	 * @param mode a boolean array [left right up down] indicating which of the 4 circles will be recursed on
	 */
	public static void genFractal(List<Circle> circles, int x, int y, int radius, int n, boolean [] mode) {

		// CODE HERE

		return;

	}
	
	
	/**
	 * Calculate and determine if there exists a sum of (some) of the elements in an integer
	 * array that is equal to a target value.  If there exists a sum, then return true, otherwise false.
	 * 
	 * Given an array of ints, is it possible to choose a group of some of the ints, such that the 
	 * group sums to the given target? 
	 * 
	 * Assume this method is always called with a starting index of 0 and a sum of 0
	 * Recursion traverses the array and explores alternative sums
	 * 
	 * <pre>
	 * e.g.
	 * sumSome(0, [2, 4, 8], 10) will return true
	 * sumSome(0, [2, 4, 8], 14) will return true
	 * sumSome(0, [2, 4, 8], 9) will return false
	 * </pre>
	 * 
	 * @param index the current position in nums
	 * @param nums an array of integers to be considered in the sum
	 * @param sum the current sum
	 * @param target the value some of the integers in nums should add up to
	 * @return a boolean value indicating that a sum of some of the integers in nums equals the target
	 */
	public static boolean sumSome(int index, int[] nums, int sum, int target) {
	
	
	
		return false;
	}

	
	

			



}
