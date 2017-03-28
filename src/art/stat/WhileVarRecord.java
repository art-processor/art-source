package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WhileVarRecord extends Record {
	private static final String INSERT_SQL = "Insert into while_var(while_id,var_id) values(?,?)";
	private Long whileId;
	private Long varId;
	
	public WhileVarRecord(Long whileId, Long varId) {
		super();
		this.whileId = whileId;
		this.varId = varId;
	}

	@Override
	public void save() throws SQLException {
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {			
			insertStmt.setLong(1, whileId);
			insertStmt.setLong(2, varId);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into while_var table");
			}
		}	

	}

}
