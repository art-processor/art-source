package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import art.stat.SelectRecord;
import art.stat.SetRecord;
import art.stat.StatDB;

public class SelectRecordTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		StatDB.setup(true);
	}

	@Test
	public void test() throws SQLException {
		SetRecord sr = new SetRecord();
		sr.setCmdValue("set D = 1");
		sr.setFileId(1l);
		sr.setLineNo(99);
		sr.setDefer(false);
		sr.setVarName("D");
		sr.setValue("1");
		sr.save();
		
		SelectRecord slr = new SelectRecord();
		slr.setCmdValue("select D");
		slr.setFileId(1l);
		slr.setLineNo(11);
		slr.setExpr("D");
		slr.setVarName("D");
		slr.save();
		
		assertNotNull(slr.getCmdId());
		assertNotSame(0l, slr.getCmdId());
		
		/*SelectRecord slr2 = new SelectRecord();
		slr2.setCmdValue("select E");
		slr2.setFileId(1l);
		slr2.setLineNo(22);
		slr2.setVarName("E");
		slr2.save();
		
		assertNull(slr2.getCmdId());*/
	}

}
