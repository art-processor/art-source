package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import art.stat.OutputRecord;
import art.stat.StatDB;

public class OutputRecordTest {

	@Test
	public void test() throws SQLException {
		StatDB.setup(true);
		OutputRecord outRec = new OutputRecord();
		outRec.setFileId(1l);
		outRec.setCmdValue("output \"resources/adapt/output\"");
		outRec.setLineNo(1);
		outRec.setOutputFile("resources/adapt/output");
		outRec.save();
		assertNotNull(outRec.getCmdId());
		assertNotSame(0l, outRec.getCmdId());
	}

}
