package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import art.stat.SetRecord;
import art.stat.StatDB;

public class SetRecordTest {
	@BeforeClass
	public static void setup() throws SQLException {		
		StatDB.setup(true);
	}

	@AfterClass
	public static void shutdown() throws SQLException {		
		StatDB.shutdown();
	}
	
	@Test
	public void multiValueTest() throws SQLException {
		SetRecord sr = new SetRecord();
		sr.setCmdValue("set C = 1,2,3,4,5,6");
		sr.setFileId(1l);
		sr.setLineNo(99);
		sr.setDefer(false);
		sr.setVarName("C");
		List<String> valueList = Arrays.asList("1", "2", "3", "4", "5", "6");
		sr.setValueList(valueList);
		
		assertTrue(sr.isMultiValue());
		
		sr.save();
		assertNotNull(sr.getCmdId());
		assertNotSame(0l, sr.getCmdId());
	}

	@Test
	public void singleValueTest() throws SQLException {
		SetRecord sr = new SetRecord();
		sr.setCmdValue("set A = 1");
		sr.setFileId(1l);
		sr.setLineNo(99);
		sr.setDefer(false);
		sr.setVarName("A");
		sr.setValue("1");
		
		assertFalse(sr.isMultiValue());
		
		sr.save();
		assertNotNull(sr.getCmdId());
		assertNotSame(0l, sr.getCmdId());
		
		sr.setCmdValue("set A = 2");
		sr.setFileId(1l);
		sr.setLineNo(100);
		sr.setDefer(false);
		sr.setVarName("A");
		sr.setValueList(Arrays.asList("2"));
		
		assertFalse(sr.isMultiValue());
		
		sr.save();
		assertNotNull(sr.getCmdId());
		
	}
	
	@Test
	public void fineSetIdTest() throws SQLException {
		SetRecord sr = new SetRecord();
		sr.setCmdValue("set D = 1");
		sr.setFileId(1l);
		sr.setLineNo(99);
		sr.setDefer(false);
		sr.setVarName("D");
		sr.setValue("1");
		
		assertFalse(sr.isMultiValue());
		
		sr.save();
		
		Long setId = SetRecord.findSetId("D", "1");
		assertEquals(sr.getCmdId(), setId);
		
		sr.setCmdValue("set D = 33");
		sr.setFileId(1l);
		sr.setLineNo(99);
		sr.setDefer(false);
		sr.setVarName("D");
		sr.setValue("33");
		
		assertFalse(sr.isMultiValue());
		
		sr.save();
		
		setId = SetRecord.findSetId("D", "33");
		assertEquals(sr.getCmdId(), setId);
		
		sr.setCmdValue("set E = 1,2,3,4,5,6");
		sr.setFileId(1l);
		sr.setLineNo(999);
		sr.setDefer(false);
		sr.setVarName("E");
		List<String> valueList = Arrays.asList("1", "2", "3", "4", "5", "6");
		sr.setValueList(valueList);
		
		assertTrue(sr.isMultiValue());
		
		sr.save();
		setId = SetRecord.findSetId("E", "6");
		assertEquals(sr.getCmdId(), setId);
	}
}
