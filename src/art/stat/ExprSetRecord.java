package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExprSetRecord extends Record {
	private static final String INSERT_SQL = "Insert into expr_set(expr_id,set_id) values(?,?)";
	private Long exprId;
	private Long setId;
	
	public ExprSetRecord(Long exprId, Long setId) {
		super();
		this.exprId = exprId;
		this.setId = setId;
	}

	@Override
	public void save() throws SQLException {
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {			
			insertStmt.setLong(1, exprId);
			insertStmt.setLong(2, setId);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into expr_set table");
			}
		}	
	}

}
