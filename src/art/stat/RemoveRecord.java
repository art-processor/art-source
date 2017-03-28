package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveRecord extends CommandRecord {
	private static final String INSERT_SQL = "Insert into remove_cmd(cmd_id,var_id) values(?,?)";
	private Long varId;
	private String varName;
	
	public RemoveRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_REMOVE);
	}

	public Long getVarId() {
		return varId;
	}

	public void setVarId(Long varId) {
		this.varId = varId;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public void save() throws SQLException {
		VariableRecord vr = VariableRecord.findByVarName(varName);
		
		if (vr != null) {
			varId = vr.getVarId();
			cmdValue = "remove " + varName;
			super.save();
			try (PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {
				insertStmt.setLong(1, cmdId);
				insertStmt.setLong(2, varId);
				int rowCount = insertStmt.executeUpdate();

				if (rowCount == 0) {
					throw new SQLException(
							"Failed to insert into remove_cmd table");
				}
			}
		}	
	}
}
