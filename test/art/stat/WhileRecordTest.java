package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import art.stat.SetRecord;
import art.stat.StatDB;
import art.stat.VariableRecord;
import art.stat.WhileRecord;

public class WhileRecordTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		StatDB.setup(true);
	}

	@Test
	public void test() throws SQLException {
		SetRecord sr = new SetRecord();
		sr.setCmdValue("set loop = 1,2,3,4,5,6");
		sr.setFileId(1l);
		sr.setLineNo(999);
		sr.setDefer(false);
		sr.setVarName("loop");
		List<String> valueList = Arrays.asList("1", "2", "3", "4", "5", "6");
		sr.setValueList(valueList);
		sr.save();
		
		SetRecord sr2 = new SetRecord();
		sr2.setCmdValue("set loop2 = 1,2,3,4,5,6");
		sr2.setFileId(1l);
		sr2.setLineNo(999);
		sr2.setDefer(false);
		sr2.setVarName("loop2");
		sr2.setValueList(Arrays.asList("1", "2", "3", "4", "5", "6"));
		sr2.save();
		
		List<Long> varIdList = new ArrayList<Long>();
		VariableRecord vr1 = VariableRecord.findByVarName("loop");
		varIdList.add(vr1.getVarId());
		VariableRecord vr2 = VariableRecord.findByVarName("loop2");
		varIdList.add(vr2.getVarId());
		WhileRecord wr = new WhileRecord();
		
		//wr.setCmdValue("while loop");
		wr.setFileId(1l);
		wr.setLineNo(22);
		wr.setExpr("loop,loop2");
		wr.setVarIdList(varIdList);
		wr.save();
		
		assertNotNull(wr.getCmdId());
		assertNotSame(0l, wr.getCmdId());
		
		/*WhileRecord wr2 = new WhileRecord();
		wr2.setCmdValue("while loop2");
		wr2.setFileId(1l);
		wr2.setLineNo(22);
		wr2.setExpr("loop2");
		wr2.save();
		
		assertNotNull(wr2.getCmdId());*/
	}

}
