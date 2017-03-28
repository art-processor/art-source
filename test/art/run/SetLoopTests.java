package art.run;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import art.testUtils.Utils;


public class SetLoopTests {
  
	@Test
	public void setloopTest() {  
		assertTrue(Utils.generalTest("resources/setloop/setloop", "resources/setloop/output", "resources/setloop/expectedOutput"));
	}
	
	@Test
	public void setloopRemoveRedefinition() {  
		assertTrue(Utils.generalTest("resources/setloopRemove/setloopRemove", "resources/setloopRemove/output", "resources/setloopRemove/expectedOutput"));
	}
	
	@Test
	public void setloopInsert() {  
		assertTrue(Utils.generalTest("resources/setloopInsert/setloopInsert", "resources/setloopInsert/output", "resources/setloopInsert/expectedOutput"));
	}
	
	@Test
	public void setloopInsert2() {  
		assertTrue(Utils.generalTest("resources/setloopInsert2/setloopInsert", "resources/setloopInsert2/output", "resources/setloopInsert2/expectedOutput"));
	}
}
