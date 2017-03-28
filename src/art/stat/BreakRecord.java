package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BreakRecord extends CommandRecord {
	private static final String INSERT_SQL = "Insert into break_cmd(cmd_id,break_name) values(?,?)";
	private String breakName;

	public BreakRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_BREAK);
	}

	public String getBreakName() {
		return breakName;
	}

	public void setBreakName(String breakName) {
		this.breakName = breakName;
	}

	@Override
	public void save() throws SQLException {
		cmdValue = "break: " + breakName;
		super.save();
		
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {			
			insertStmt.setLong(1, cmdId);
			insertStmt.setString(2, breakName);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into break_cmd table");
			}
			
			List<BreakPointRecord> bpList = BreakPointRecord.findBreakPoint(breakName);
			
			for(BreakPointRecord bp : bpList) {
				BreakInsertRecord bi = new BreakInsertRecord(cmdId, bp.getInsertId());
				bi.save();
			}
			
		}	
	}
}
