package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import art.stat.StatDB;
import art.stat.VariableRecord;

public class VariableRecordTest {

	@Before
	public void setUpBefore() throws Exception {
		StatDB.setup(true);
	}

	@Test
	public void test() throws SQLException {
		VariableRecord vr = new VariableRecord();
		vr.setVarName("A");
		vr.save();
		assertNotNull(vr.getVarId());
		assertNotSame(0l, vr.getVarId());
		
		VariableRecord vr2 = VariableRecord.findByVarName("A");
		assertEquals(vr.getVarId(), vr2.getVarId());
		
		vr.setSetId(999l);
		vr.updateSetId();
	}

}
