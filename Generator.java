import java.math.BigInteger;

/**
 * An implementation of an RSA generator based on command line arguments
 * @author Cody Shafer
 * @version 1.0 Spring 2014
 */
public class Generator {
	
	/**
	 * Uses command line arguments. Pass in P, Q, S0, B and L in that order
	 * 
	 * @param the_args the command line arguments containing all the numbers
	 */
	public static void main(final String[] the_args){
		if (the_args.length != 5){
			System.out.println("Not correct number of arguements. Please try again.");
			System.out.println(the_args.length);
		} else{
			/*
			 * Does not handle case with bad arguments. Will fail
			 * if passed in non-numbers.
			 * Uses BigInteger to allow for the big numbers that are possible.
			 */
			
			//Grab and parse all inputs
			BigInteger p = BigInteger.valueOf(Long.parseLong(the_args[0]));
			BigInteger q = BigInteger.valueOf(Long.parseLong(the_args[1]));
			BigInteger n = (p.multiply(q));
			BigInteger s0 = BigInteger.valueOf(Long.parseLong(the_args[2]));
			int b = (Integer.parseInt(the_args[3]));
			int l = Integer.parseInt(the_args[4]);

			//Output string
			StringBuilder output = new StringBuilder();
			
			/*
			 * Loop for each round of generation based on input L
			 */
			for(int i = 0; i < l; i++){
				BigInteger mid = s0.pow(b);
				s0 = mid.mod(n);
				BigInteger calc = s0.mod(BigInteger.valueOf(2)); //Mod 2 
				output.append(calc.toString());//Since output will have to be 1 or 0 it is safe to append directly
			}
			System.out.println(output.toString());			
		}
	}
}