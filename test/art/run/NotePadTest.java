package art.run;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import art.processor.ARTProcessor;
import art.testUtils.Utils;


public class NotePadTest {

	@Test
	public void notePadTest(){

		ARTProcessor proc;
		try {
			proc = new ARTProcessor("resources/notePadExample/start");
			proc.run();
		} catch (IOException e) {
			System.err.print("Input file not found.");
			e.printStackTrace();
		}

		String exp = null;
		String out = null;
		try {
			exp = Utils.readFile("resources/notePadExample/NotePadExcepted.java");
			out = Utils.readFile("resources/notePadExample/NotePad.java");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (new File("resources/notePadExample/NotePad.java").exists()){
			new File("resources/notePadExample/NotePad.java").delete();
		}
		assertTrue(null != exp  && null != out && exp.equals(out));
	}

}
