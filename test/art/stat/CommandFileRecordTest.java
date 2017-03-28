package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import art.stat.CommandFileRecord;
import art.stat.StatDB;

public class CommandFileRecordTest {
	private static Logger logger = Logger.getLogger(CommandFileRecordTest.class.getName());
	@Before
	public void setup() throws Exception {
		StatDB.setup(true);
	}
	
	@Test
	public void saveTest() throws SQLException {
		CommandFileRecord cmdFileRec = new CommandFileRecord("test");
		cmdFileRec.save();
		logger.info("insertTest() : fileId - " + cmdFileRec.getFileId());
		assertNotNull(cmdFileRec.getFileId());
		assertNotSame(new Long(0), cmdFileRec.getFileId());
		assertEquals(1, cmdFileRec.getVisit());
		
		CommandFileRecord cmdFileRec2 = new CommandFileRecord("test");
		cmdFileRec2.save();
		logger.info("insertTest() : fileId - " + cmdFileRec2.getFileId());
		assertNotNull(cmdFileRec2.getFileId());
		assertNotSame(new Long(0), cmdFileRec2.getFileId());
		assertEquals(2, cmdFileRec2.getVisit());
	}

}
