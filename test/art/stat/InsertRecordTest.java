package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import art.stat.InsertRecord;
import art.stat.StatDB;

public class InsertRecordTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		StatDB.setup(true);
	}

	@Test
	public void test() throws SQLException {
		InsertRecord ir = new InsertRecord();
		ir.setCmdValue("insert b1");
		ir.setFileId(1l);
		ir.setLineNo(11);
		ir.setBreakName("b1");
		ir.setInsertType(InsertRecord.INSERT_AFTER);
		ir.save();
		
		assertNotNull(ir.getCmdId());
		assertNotSame(0l, ir.getCmdId());
		
		assertNotNull(ir.getBreakId());
		assertNotSame(0l, ir.getBreakId());
	}

}
