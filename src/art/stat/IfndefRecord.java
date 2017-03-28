package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IfndefRecord extends CommandRecord {
	private static final String INSERT_SQL = "Insert into ifndef_cmd(cmd_id,var) values(?,?)";
	private String varName;
	
	public IfndefRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_IFNDEF);
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public void save() throws SQLException {
		cmdValue = "ifndef " + varName;
		super.save();
		try (PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {
			insertStmt.setLong(1, cmdId);
			insertStmt.setString(2, varName);
			int rowCount = insertStmt.executeUpdate();

			if (rowCount == 0) {
				throw new SQLException(
						"Failed to insert into ifndef_cmd table");
			}
		}		
	}
}
