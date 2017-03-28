package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import art.stat.ExprRecord;
import art.stat.SetRecord;
import art.stat.StatDB;

public class ExprRecordTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		StatDB.setup(true);
	}
	
	@Test
	public void saveTest() throws SQLException {
		SetRecord sr = new SetRecord();
		sr.setCmdValue("set A = 1");
		sr.setFileId(1l);
		sr.setLineNo(99);
		sr.setDefer(false);
		sr.setVarName("A");
		sr.setValue("1");
		sr.save();
		
		SetRecord sr2 = new SetRecord();
		sr2.setCmdValue("set B = \"A\"");
		sr2.setFileId(1l);
		sr2.setLineNo(100);
		sr2.setDefer(false);
		sr2.setVarName("A");
		sr2.setValueList(Arrays.asList("2"));	
		sr2.save();
		
		ExprRecord er = new ExprRecord();
		er.setCmdValue("?@@B?");
		er.setFileId(1l);
		er.setLineNo(123);
		er.setExpr("?@@B?");
		er.setValue("1");
		List<Long> usedSetIdList = Arrays.asList(sr.getCmdId(), sr2.getCmdId());
		er.setUsedSetIdList(usedSetIdList);
		er.save();
		
		assertNotNull(er.getCmdId());
		assertNotSame(0l, er.getCmdId());
	}
}
