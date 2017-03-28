package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectRecord extends CommandRecord {
	private static final String INSERT_SQL = "Insert into select_cmd(cmd_id,expr,var_id) values(?,?,?)";
	private Long varId;
	private String varName;
	private String expr;
	
	public SelectRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_SELECT);
	}

	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
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
			cmdValue = "select " + expr;
			super.save();
			try (PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {
				insertStmt.setLong(1, cmdId);
				insertStmt.setLong(2, varId);
				insertStmt.setString(2, expr);
				int rowCount = insertStmt.executeUpdate();

				if (rowCount == 0) {
					throw new SQLException(
							"Failed to insert into select_cmd table");
				}
			}
		}	
	}
}
