package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import art.stat.IfndefRecord;
import art.stat.StatDB;

public class IfndefRecordTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		StatDB.setup(true);
	}

	@Test
	public void test() throws SQLException {
		IfndefRecord br = new IfndefRecord();
		br.setCmdValue("ifndef b1");
		br.setFileId(1l);
		br.setLineNo(22);
		br.setVarName("b1");
		br.save();
		
		assertNotNull(br.getCmdId());
		assertNotSame(0l, br.getCmdId());
	}

}
