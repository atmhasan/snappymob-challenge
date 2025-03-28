package com.snappymob;

import java.io.*;
import java.nio.file.*;

/*Create a program that will read the generated file above and print to the console the
object and its type. Spaces before and after the alphanumeric object must be
stripped.*/

public class ChallengeB {
	public static void processFile(String inputPath, String outputPath) throws Exception {

		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath));

			StringBuilder sb = new StringBuilder();
			int ch;
			// reading file and verifying data type
			while ((ch = reader.read()) != -1) {
				if (ch == ',') {
					String item = sb.toString().trim();
					writer.write(item + " : " + detectType(item));
					writer.newLine();
					sb.setLength(0);
				} else {
					sb.append((char) ch);
				}
			}
			if (sb.length() > 0) {
				String item = sb.toString().trim();
				writer.write(item + " : " + detectType(item));
				writer.newLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static String detectType(String item) {
		if (item.matches("[a-zA-Z]+"))
			return "Alphabetical";
		else if (item.matches("-?\\d+"))
			return "Integer";
		else if (item.matches("-?\\d+\\.\\d+"))
			return "Real Number";
		else
			return "Alphanumeric";
	}
}