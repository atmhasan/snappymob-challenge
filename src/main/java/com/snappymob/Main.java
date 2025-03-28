package com.snappymob;

/*Create a program that will read the generated file above and print to the console the
object and its type. Spaces before and after the alphanumeric object must be
stripped.*/

public class Main {
	public static void main(String[] args) {
		
		String inputFile = args.length > 0 ? args[0] : "data.txt";	//input data from args[0] or the static file
		
		String outputFile = args.length > 1 ? args[1] : "result.txt";	//output result to args[1] or the result file
		
		try {
			ChallengeB.processFile(inputFile, outputFile);
			System.out.println("Processing completed. Output written to: " + outputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
