package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandRecord extends Record {
	public static final String TABLE_CMD = "cmd";
	private static final String INSERT_SQL = "Insert into cmd(file_id,cmd_type_id,cmd_value,line_no) values(?,?,?,?)";
	protected StatParam statParam = StatParam.getInstance();
	protected Long cmdId = null;
	protected Long fileId;
	protected int lineNo;
	protected int cmdTypeId;
	protected String cmdValue;
	
	public Long getCmdId() {
		return cmdId;
	}
	public void setCmdId(Long cmdId) {
		this.cmdId = cmdId;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public int getLineNo() {
		return lineNo;
	}
	public void setLineNo(int lineNo) {
		if(statParam.isProcessingWhile()) {
			//If it is processing while command, line no. are started from while command's line.
			//So we have to add while's line no. as base line no to get the correct line no. of 
			//commands within while
			lineNo += statParam.getBaseLineNo();
		} else if(statParam.istProcessingInsert()) {
			//If it is processing insert, we can't rely on line no. provided by ANTLR as it starts
			//from insert content, and it will confuse the users. So if it is within insert processing
			//we will just use break command's line no. for those commands inside insert content
			lineNo = statParam.getBreakLineNo();
		}
		this.lineNo = lineNo;
	}
	public int getCmdTypeId() {
		return cmdTypeId;
	}
	public void setCmdTypeId(int cmdTypeId) {
		this.cmdTypeId = cmdTypeId;
	}
	public String getCmdValue() {
		return cmdValue;
	}
	public void setCmdValue(String cmdValue) {
		this.cmdValue = cmdValue;
	}
	
	@Override
	public void save() throws SQLException {
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL);
				Statement selectStmt = StatDB.getConn().createStatement()) {			
			insertStmt.setLong(1, fileId);
			insertStmt.setInt(2, cmdTypeId);
			insertStmt.setString(3, cmdValue);
			insertStmt.setInt(4, lineNo);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into cmd table");
			}
			
			cmdId = getLastInsertedRowId(selectStmt, TABLE_CMD); 
		}
		
	}
}
