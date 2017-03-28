package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.junit.Test;

import art.stat.CommandRecord;
import art.stat.StatDB;

public class CommandRecordTest {
	private static Logger logger = Logger.getLogger(CommandRecordTest.class.getName());
	
	@Test
	public void insertTest() throws SQLException {
		StatDB.setup(true);
		CommandRecord cmdRec = new CommandRecord();
		cmdRec.setCmdTypeId(0);
		cmdRec.setFileId(1l);
		cmdRec.setCmdValue("set A = 1");
		cmdRec.setLineNo(999);
		cmdRec.save();
		logger.info("insertTest() : cmdId - " + cmdRec.getCmdId());
		assertNotNull(cmdRec.getCmdId());
		assertNotSame(new Long(0), cmdRec.getCmdId());
	}

}
