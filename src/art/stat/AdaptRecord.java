package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdaptRecord extends CommandRecord {
	private static final String INSERT_SQL = "Insert into adapt_cmd(cmd_id,adapt_expr,adapting_file_id,adapted_file_id,extended,same_level) values(?,?,?,?,?,?)";
	
	private String adaptExpr;
	private Long adaptingFileId;
	private Long adaptedFileId;
	private boolean extended;
	private boolean sameLevel;

	public AdaptRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_ADAPT);
	}
	
	public String getAdaptExpr() {
		return adaptExpr;
	}

	public void setAdaptExpr(String adaptExpr) {
		this.adaptExpr = adaptExpr;
	}

	public Long getAdaptingFileId() {
		return adaptingFileId;
	}

	public void setAdaptingFileId(Long adaptingFileId) {
		this.adaptingFileId = adaptingFileId;
	}

	public Long getAdaptedFileId() {
		return adaptedFileId;
	}

	public void setAdaptedFileId(Long adaptedFileId) {
		this.adaptedFileId = adaptedFileId;
	}

	public boolean isExtended() {
		return extended;
	}

	public void setExtended(boolean extended) {
		this.extended = extended;
	}

	public boolean isSameLevel() {
		return sameLevel;
	}

	public void setSameLevel(boolean sameLevel) {
		this.sameLevel = sameLevel;
	}
	
	@Override
	public void save() throws SQLException {
		cmdValue = "adapt " + adaptExpr;
		super.save();
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {			
			insertStmt.setLong(1, cmdId);
			insertStmt.setString(2, adaptExpr);
			insertStmt.setLong(3, adaptingFileId);
			insertStmt.setLong(4, adaptedFileId);
			insertStmt.setInt(5, extended? 1 : 0);
			insertStmt.setInt(6, sameLevel? 1 : 0);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into adapt_cmd table");
			}
		}
	}
}
