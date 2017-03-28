package art.run;

import java.io.IOException;

import art.processor.ARTProcessor;
import art.stat.StatParam;
import art.utils.Utils;
import art.utils.Version;


public class Main {

	public static void main(String[] args) {
		ARTProcessor proc;
		try {
			if (args.length > 0) {
				String statFlag = System.getProperty("stat");
				StatParam statParam = StatParam.getInstance();
				if (statFlag == null) {
					statParam.setStatEnabled(false);
				} else {
					statParam.setStatEnabled(Boolean.parseBoolean(statFlag));
				}

				for (String s : args) {
					if (s.equals("-debug") || s.equals("-d")) {
						Utils.setDebugMode(true);
					}
				}

				System.out.println("ART Processor - " + Version.versionConstant);
				System.out.println("Processing started...");
				proc = new ARTProcessor(args[0]);
				proc.run();
			} else {
				System.out.println("No input file specified.");
			}
		} catch (IOException e) {
			System.err.print("Input file not found.");
		}
	}
}