package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WhileRecord extends CommandRecord {
	private static final String INSERT_SQL = "Insert into while_cmd(cmd_id,expr) values(?,?)";
	private List<Long> varIdList;
	private String expr;

	public WhileRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_WHILE);
	}

	public List<Long> getVarIdList() {
		return varIdList;
	}

	public void setVarIdList(List<Long> varIdList) {
		this.varIdList = varIdList;
	}

	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}

	@Override
	public void save() throws SQLException {
		cmdValue = "while " + expr;
		super.save();
		try (PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {
			insertStmt.setLong(1, cmdId);
			insertStmt.setString(2, expr);
			int rowCount = insertStmt.executeUpdate();

			if (rowCount == 0) {
				throw new SQLException("Failed to insert into while_cmd table");
			}
			
			for(Long varId : varIdList) {
				WhileVarRecord wvr = new WhileVarRecord(cmdId, varId);
				wvr.save();
			}
			
		}
	}

}
