package art.stat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VariableRecord extends Record {
	private static final String TABLE_VARIABLE = "variable";
	private static final String INSERT_SQL = "Insert into variable(var_name,set_id) values(?,?)";
	private static final String FIND_VAR_ID_SQL = "Select * from variable where var_name = ?";
	private static final String UPDATE_SET_ID_SQL = "Update variable set set_id = ? where var_id = ?";
	
	private String varName;
	private Long setId = 0l;
	private Long varId;
	
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public Long getSetId() {
		return setId;
	}
	public void setSetId(Long setId) {
		this.setId = setId;
	}
	public Long getVarId() {
		return varId;
	}
	public void setVarId(Long varId) {
		this.varId = varId;
	}
	
	@Override
	public void save() throws SQLException {
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL);
				Statement selectStmt = StatDB.getConn().createStatement()) {			
			insertStmt.setString(1, varName);
			insertStmt.setLong(2, setId);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into variable table");
			}
			
			varId = getLastInsertedRowId(selectStmt, TABLE_VARIABLE);
		}		
		
	}
	
	public void updateSetId() throws SQLException {
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(UPDATE_SET_ID_SQL)) {			
			insertStmt.setLong(1, setId);
			insertStmt.setLong(2, varId);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to update variable table for var_id : " + varId);
			}
		}	
	}
	
	public static VariableRecord findByVarName(String varName) throws SQLException {
		VariableRecord vr = null;
		try(PreparedStatement selectStmt = StatDB.getConn().prepareStatement(FIND_VAR_ID_SQL)) {			
			selectStmt.setString(1, varName);
			
			try(ResultSet rs = selectStmt.executeQuery()) {
				if(rs.next()) {
					vr = new VariableRecord();
					vr.setVarId(rs.getLong("var_id"));
					vr.setVarName(rs.getString("var_name"));
					vr.setSetId(rs.getLong("set_id"));
				}
			}
		}
		return vr;
	}
	
}
