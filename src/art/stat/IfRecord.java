package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IfRecord extends CommandRecord {
	private static final String INSERT_SQL = "Insert into if_cmd(cmd_id,expr) values(?,?)";
	private String expr;
	
	public IfRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_IF);
	}

	
	public String getExpr() {
		return expr;
	}


	public void setExpr(String expr) {
		this.expr = expr;
	}


	@Override
	public void save() throws SQLException {
		cmdValue = "if " + expr;
		super.save();
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {			
			insertStmt.setLong(1, cmdId);
			insertStmt.setString(2, expr);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into if_cmd table");
			}
		}	
	}
}
