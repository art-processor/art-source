package art.stat;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import art.stat.AdaptRecord;
import art.stat.CommandFileRecord;
import art.stat.StatDB;

public class AdaptRecTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		StatDB.setup(true);
	}

	@Test
	public void saveTest() throws SQLException {
		CommandFileRecord adapter = new CommandFileRecord("adapterFile");
		adapter.save();
		
		CommandFileRecord adaptee = new CommandFileRecord("adaptedFile");
		adaptee.save();
		
		AdaptRecord ar = new AdaptRecord();
		ar.setCmdValue("adapt adptedFile");
		ar.setFileId(adapter.getFileId());
		ar.setLineNo(111);
		ar.setAdaptingFileId(adapter.getFileId());
		ar.setAdaptedFileId(adaptee.getFileId());
		ar.setAdaptExpr("adaptedFile");
		ar.save();
		
		assertNotNull(ar.getCmdId());
		assertNotSame(0l, ar.getCmdId());
	}

}
