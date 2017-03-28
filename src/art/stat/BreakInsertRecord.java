package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BreakInsertRecord extends Record {
	private static final String INSERT_SQL = "Insert into break_insert(break_id,insert_id) values(?,?)";
	
	private Long breakId;
	private Long insertId;
	
	public BreakInsertRecord(Long breakId, Long insertId) {
		super();
		this.breakId = breakId;
		this.insertId = insertId;
	}


	@Override
	public void save() throws SQLException {
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL);
				Statement selectStmt = StatDB.getConn().createStatement()) {			
			insertStmt.setLong(1, breakId);
			insertStmt.setLong(2, insertId);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into break_insert table");
			}
			
		}		
	}

}
