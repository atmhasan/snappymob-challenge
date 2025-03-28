package com.snappymob;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/*Write a program that will generate four (4) types of printable random objects and
store them in a single file, each object will be separated by a ",". These are the 4
objects: alphabetical strings, real numbers, integers, alphanumerics. The
alphanumerics should contain a random number of spaces before and after it (not
exceeding 10 spaces). The output should be 10MB in size.*/

public class ChallengeA {

	static String filePath = "data.txt"; // output file

	static int fileSize = 10 * 1024 * 1024; // max size 10MB

	static Random random = new Random(); // random object generator

	public static void main(String[] args) throws IOException {

		try {
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
			int totalBytes = 0;

			while (totalBytes < fileSize) {
				String obj = generateRandomObject(); // getting random number
				if (totalBytes > 0)
					obj = "," + obj; // add comma before every object
				writer.write(obj); // writing in the data.txt
				totalBytes += obj.getBytes().length;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("File generated: " + filePath);
	}

	/* generates random numbers or object */
	private static String generateRandomObject() {
		int type = random.nextInt(4);
		return switch (type) {
		case 0 -> generateAlphabetical();
		case 1 -> generateRealNumber();
		case 2 -> generateInteger();
		default -> generateAlphaNumericWithSpaces();
		};
	}

	/* generates alphabetical strings */
	private static String generateAlphabetical() {
		int length = random.nextInt(5, 15);
		String alphabetical = "";
		alphabetical = random.ints('a', 'z' + 1).limit(length)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return alphabetical;
	}

	/* generates real numbers */
	private static String generateRealNumber() {
		double realNumber = random.nextDouble() * 1000;
		String sRealNumber = "";
		sRealNumber = String.format(Locale.US, "%.4f", realNumber);
		return sRealNumber;
	}

	/* generates integers */
	private static String generateInteger() {
		int integerNumber = random.nextInt(100000);
		String sIntegerNumber = "";
		sIntegerNumber = Integer.toString(integerNumber);
		return sIntegerNumber;
	}

	/* generates alphanumerics */
	private static String generateAlphaNumericWithSpaces() {
		int len = random.nextInt(5, 15);
		String core = random.ints(len, 0, 36).mapToObj(i -> (char) (i < 10 ? '0' + i : 'a' + (i - 10)))
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
		int leftSpaces = random.nextInt(0, 11);
		int rightSpaces = random.nextInt(0, 11);
		String alphaNumaric = " ".repeat(leftSpaces) + core + " ".repeat(rightSpaces);
		return alphaNumaric;
	}
}