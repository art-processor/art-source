package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import art.stat.RemoveRecord;
import art.stat.SetRecord;
import art.stat.StatDB;

public class RemoveRecordTest {
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
		
		RemoveRecord rr = new RemoveRecord();
		rr.setCmdValue("remove D");
		rr.setFileId(1l);
		rr.setLineNo(11);
		rr.setVarName("D");
		rr.save();
		
		assertNotNull(rr.getCmdId());
		assertNotSame(0l, rr.getCmdId());
		
		RemoveRecord rr2 = new RemoveRecord();
		rr2.setCmdValue("remove E");
		rr2.setFileId(1l);
		rr2.setLineNo(22);
		rr2.setVarName("E");
		rr2.save();
		
		assertNull(rr2.getCmdId());
	}

}
