package art.run;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import art.processor.ARTProcessor;
import art.testUtils.Utils;


public class AllCommandTest {

	@Test
	public void remove2Test() {
		assertTrue(Utils.generalTest("resources/rem/remove", "resources/rem/output", "resources/rem/expectedOutput"));
	}

	@Test
	public void adaptTest() {
		assertTrue(Utils.generalTest("resources/adapt/adapt", "resources/adapt/output", "resources/adapt/expectedOutput"));
	}

	@Test
	public void dynamicMultiTest() {
		assertTrue(Utils.generalTest("resources/dynamicMulti/while", "resources/dynamicMulti/output", "resources/dynamicMulti/expectedOutput"));
	}

	@Test
	public void ifTest() {
		assertTrue(Utils.generalTest("resources/if/if", "resources/if/J2SEGuide.java", "resources/if/expectedOutput"));
	}

	@Test
	public void ifelifTest() {
		assertTrue(Utils.generalTest("resources/ifElifElse/if", "resources/ifElifElse/output", "resources/ifElifElse/expectedOutput"));
	}

	@Test
	public void multiExpressTest() {
		assertTrue(Utils.generalTest("resources/multiExpress/while", "resources/multiExpress/output", "resources/multiExpress/expectedOutput"));
	}

	@Test
	public void nestedWhileTest() {
		assertTrue(Utils.generalTest("resources/nestedWhile/while", "resources/nestedWhile/output", "resources/nestedWhile/expectedOutput"));
	}

	@Test
	public void orTest() {
		assertTrue(Utils.generalTest("resources/ortest/select", "resources/ortest/output", "resources/ortest/expectedOutput"));
	}

	@Test
	public void whileTest() {
		assertTrue(Utils.generalTest("resources/While/while", "resources/While/output", "resources/While/expectedOutput"));
	}

	@Test
	public void whileInsertTest() {
		assertTrue(Utils.generalTest("resources/whileInsert/while", "resources/whileInsert/output", "resources/whileInsert/expectedOutput"));
	}

	@Test
	public void whileMultiTest() {
		assertTrue(Utils.generalTest("resources/whileMulti/while", "resources/whileMulti/output", "resources/whileMulti/expectedOutput"));
	}

	@Test
	public void insertTest() {
		assertTrue(Utils.generalTest("resources/insert/insert", "resources/insert/output", "resources/insert/expectedOutput"));
	}

	@Test
	public void whileSelectTest() {
		assertTrue(Utils.generalTest("resources/whileSelect/while", "resources/whileSelect/output", "resources/whileSelect/expectedOutput"));
	}

	@Test
	public void selectTest() {
		assertTrue(Utils.generalTest("resources/select/select", "resources/select/output", "resources/select/expectedOutput"));
	}

	@Test
	public void removeTest() {
		assertTrue(Utils.generalTest("resources/remove/remove", "resources/remove/output", "resources/remove/expectedOutput"));
	}

	@Test
	public void outputTest() {
		ARTProcessor proc;
		try {
			proc = new ARTProcessor("resources/output/output");
			proc.run();
		} catch (IOException e) {
			System.err.print("Input file not found.");
			e.printStackTrace();
		}
		assertTrue(new File("resources/output/a").exists());
		assertTrue(new File("resources/output/b").exists());
		assertTrue(new File("resources/output/c").exists());
		assertTrue(new File("resources/output/d").exists());
	}

	@Test
	public void output2Test() {
		ARTProcessor proc;
		try {
			proc = new ARTProcessor("resources/output2/outputCreateFolder");
			proc.run();
		} catch (IOException e) {
			System.err.print("Input file not found.");
			e.printStackTrace();
		}
		assertTrue(new File("resources/output2/a/b/c/1.txt").exists());
	}

	@Test
	public void raiseTest() {
		assertTrue(Utils.generalTest("resources/raise/raise", "resources/raise/output", "resources/raise/expectedOutput"));
	}

	@Test
	public void deferTest() {
		assertTrue(Utils.generalTest("resources/defer/defer", "resources/defer/output", "resources/defer/expectedOutput"));
	}

	@Test
	public void nestedVarTest() {
		assertTrue(Utils.generalTest("resources/nestedVar/nestedVar", "resources/nestedVar/output", "resources/nestedVar/expectedOutput"));
	}

	@Test
	public void varScopeTest() {
		assertTrue(Utils.generalTest("resources/varScope/varScope", "resources/varScope/output", "resources/varScope/expectedOutput"));
	}

	@Test
	public void scopeMiddleLayerScopeTest() {
		assertTrue(Utils.generalTest("resources/scopeMiddleLayer/scopeMiddleLayer", "resources/scopeMiddleLayer/output",
				"resources/scopeMiddleLayer/expectedOutput"));
	}

	@Test
	public void scopeMiddleLayerBreakPointsTest() {
		assertTrue(Utils.generalTest("resources/scopeMiddleLayerBreakPoints/scopeMiddleLayer", "resources/scopeMiddleLayerBreakPoints/output",
				"resources/scopeMiddleLayerBreakPoints/expectedOutput"));
	}

	@Test
	public void isfirstlastTest() {
		assertTrue(Utils.generalTest("resources/isfirstlast/isfirstlast", "resources/isfirstlast/output", "resources/isfirstlast/expectedOutput"));
	}

	@Test
	public void ulcapLlcapTest() {
		assertTrue(Utils.generalTest("resources/ulcapLlcap/ulcapLlcap", "resources/ulcapLlcap/output", "resources/ulcapLlcap/expectedOutput"));
	}

	@Test
	public void quotesTest() {
		assertTrue(Utils.generalTest("resources/quotes/quotes", "resources/quotes/output", "resources/quotes/expectedOutput"));
	}

	@Test
	public void vclvarTest() {
		assertTrue(Utils.generalTest("resources/vclvars/vclvars", "resources/vclvars/output", "resources/vclvars/expectedOutput"));
	}

	@Test
	public void textTest() {
		assertTrue(Utils.generalTest("resources/textTest/textTest", "resources/textTest/output", "resources/textTest/expectedOutput"));
	}
	
	//@Test
	//public void insertSamelevelTest() {
	//	assertTrue(Utils.generalTest("resources/insertSamelevel/f1.vcl", "resources/insertSamelevel/output", "resources/insertSamelevel/expectedOutput"));
	//}
}
