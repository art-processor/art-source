package art.stat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.sql.SQLException;

import org.junit.Test;

import art.stat.BreakPointRecord;
import art.stat.InsertRecord;
import art.stat.StatDB;

public class BreakPointRecordTest {

	@Test
	public void test() throws SQLException {
		StatDB.setup(true);
		BreakPointRecord bp = new BreakPointRecord();
		bp.setBreakName("b1");
		bp.save();
		
		assertNotNull(bp.getBreakPointId());
		assertNotSame(0l, bp.getBreakPointId());
		
		BreakPointRecord bp2 = BreakPointRecord.findBreakPoint("b1", InsertRecord.INSERT_INTO);
		assertNotNull(bp2);
		assertNotNull(bp2.getBreakPointId());
		assertNotNull(bp2.getBreakName());
		
		assertEquals(bp.getBreakPointId(), bp2.getBreakPointId());
		assertEquals(bp.getBreakName(), bp2.getBreakName());
		StatDB.shutdown();
	}

}
