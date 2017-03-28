package art.run;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import art.processor.ARTProcessor;
import art.testUtils.Utils;


public class LinuxPartTest {

	@Test
	public void notePadTest(){

		ARTProcessor proc;
		try {
			proc = new ARTProcessor("resources/jbdSource/JBD.spc");
			proc.run();
		} catch (IOException e) {
			System.err.print("Input file not found.");
			e.printStackTrace();
		}

		String exp = null;
		String out = null;
		try {
			exp = Utils.readFile("resources/jbdSource/orig/jbd/commit.c");
			out = Utils.readFile("resources/jbdSource/output/jbd/commit.c");
		} catch (IOException e) {
			e.printStackTrace();
		}
//		if (new File("resources/jbdSource/output/jbd/commit.c").exists()){
//			new File("resources/jbdSource/output/jbd/commit.c").delete();
//		}
		assertTrue(null != exp  && null != out && exp.equals(out));
	}

}
