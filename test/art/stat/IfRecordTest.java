package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import art.stat.IfRecord;
import art.stat.StatDB;

public class IfRecordTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		StatDB.setup(true);
	}

	@Test
	public void test() throws SQLException {
		IfRecord ir = new IfRecord();
		ir.setCmdValue("if(a == 1)");
		ir.setFileId(1l);
		ir.setLineNo(22);
		ir.setExpr("a == 1");
		ir.save();
		
		assertNotNull(ir.getCmdId());
		assertNotSame(0l, ir.getCmdId());
	}

}
