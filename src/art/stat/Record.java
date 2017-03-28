package art.stat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Record {
	public abstract void save() throws SQLException;
	
	protected Long getLastInsertedRowId(Statement selectStmt,
			String tableName) throws SQLException {
		Long cmdId = null;
		String query = "Select last_insert_rowid() from " + tableName;
		try (ResultSet rs = selectStmt.executeQuery(query)) {
			if (rs.next()) {
				cmdId = rs.getLong(1);
			}
		}
		return cmdId;
	}

}