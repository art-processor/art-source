package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecord extends CommandRecord {
	public static final int INSERT_INTO = 0;
	public static final int INSERT_BEFORE = 1;
	public static final int INSERT_AFTER = 2;
	private static final String INSERT_SQL = "Insert into insert_cmd(cmd_id,break_id) values(?,?)";
	
	private Long breakId;
	private int insertType;
	private String breakName;	

	public InsertRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_INSERT);
		insertType = INSERT_INTO;
	}
	
	public String getBreakName() {
		return breakName;
	}

	public void setBreakName(String breakName) {
		this.breakName = breakName;
	}

	public Long getBreakId() {
		return breakId;
	}

	public void setBreakId(Long breakId) {
		this.breakId = breakId;
	}
	
	public int getInsertType() {
		return insertType;
	}


	public void setInsertType(int insertType) {
		this.insertType = insertType;
	}

	@Override
	public void save() throws SQLException {
		cmdValue = prepareCmdValue();
		
		super.save();
		BreakPointRecord bp = BreakPointRecord.findBreakPoint(breakName, insertType);
		
		if(bp == null) {
			bp = new BreakPointRecord();
			bp.setBreakName(breakName);
			bp.setInsertType(insertType);
			bp.setInsertId(cmdId);
			bp.save();
		} else {
			bp.setInsertId(cmdId);
			bp.updateInsertId();
		}
		
		breakId = bp.getBreakPointId();
		
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {			
			insertStmt.setLong(1, cmdId);
			insertStmt.setLong(2, breakId);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into insert_cmd table");
			}

		}	
	}

	private String prepareCmdValue() {
		StringBuilder sb = new StringBuilder();
		sb.append("insert");
		if(insertType == INSERT_BEFORE) {
			sb.append("-before ");
		} else if(insertType == INSERT_AFTER) {
			sb.append("-after ");
		} else {
			sb.append(" ");
		}
		sb.append(breakName);
		return sb.toString();
	}
}
