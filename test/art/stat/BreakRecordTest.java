package art.stat;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.sql.SQLException;

import org.junit.Test;

import art.stat.BreakRecord;
import art.stat.InsertRecord;
import art.stat.StatDB;

public class BreakRecordTest {
		
	@Test
	public void test() throws SQLException {
		StatDB.setup(true);
		
		InsertRecord ir = new InsertRecord();
		ir.setCmdValue("insert-before b1");
		ir.setFileId(1l);
		ir.setLineNo(11);
		ir.setBreakName("b1");
		ir.setInsertType(InsertRecord.INSERT_BEFORE);
		ir.save();
		
		ir.setCmdValue("insert b1");
		ir.setFileId(1l);
		ir.setLineNo(11);
		ir.setBreakName("b1");
		ir.setInsertType(InsertRecord.INSERT_INTO);
		ir.save();
		
		BreakRecord br = new BreakRecord();
		br.setCmdValue("break b1");
		br.setFileId(1l);
		br.setLineNo(22);
		br.setBreakName("b1");
		br.save();
		
		assertNotNull(br.getCmdId());
		assertNotSame(0l, br.getCmdId());
		
		StatDB.shutdown();
	}

}
