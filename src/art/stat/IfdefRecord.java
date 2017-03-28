package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IfdefRecord extends CommandRecord {
	private static final String INSERT_SQL = "Insert into ifdef_cmd(cmd_id,var) values(?,?)";
	private String varName;
	
	public IfdefRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_IFDEF);
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public void save() throws SQLException {
		cmdValue = "ifdef " + varName;
		super.save();
		try (PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {
			insertStmt.setLong(1, cmdId);
			insertStmt.setString(2, varName);
			int rowCount = insertStmt.executeUpdate();

			if (rowCount == 0) {
				throw new SQLException(
						"Failed to insert into ifdef_cmd table");
			}
		}		
	}
	
}
