package art.testUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import art.processor.ARTProcessor;


public class Utils {

	public static String readFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();

		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
		}

		reader.close();
		return stringBuilder.toString();
	}

	public static boolean generalTest(String input, String output, String expected) {
		ARTProcessor proc;
		try {
			proc = new ARTProcessor(input);
			proc.run();
		} catch (IOException e) {
			System.err.print("Input file not found.");
		}

		String exp = null;
		String out = null;
		try {
			exp = Utils.readFile(expected);
			out = Utils.readFile(output);
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean ret = (null != exp && null != out && exp.equals(out));
//		 if (new File(output).exists()) {
//			 new File(output).delete();
//		 }
		return ret;
	}
}
