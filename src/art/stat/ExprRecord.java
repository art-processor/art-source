package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ExprRecord extends CommandRecord {
	private static final String INSERT_SQL = "Insert into expr_cmd(cmd_id,expr,value) values(?,?,?)";
	private String expr;
	private String value;
	private List<Long> usedSetIdList;
	
	public ExprRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_EXPR);
	}
	
	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Long> getUsedSetIdList() {
		return usedSetIdList;
	}

	public void setUsedSetIdList(List<Long> usedSetIdList) {
		this.usedSetIdList = usedSetIdList;
	}

	@Override
	public void save() throws SQLException {
		cmdValue = expr;
		super.save();
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {			
			insertStmt.setLong(1, cmdId);
			insertStmt.setString(2, expr);
			insertStmt.setString(3, value);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into expr_cmd table");
			}
			
			for(Long setId : usedSetIdList) {
				ExprSetRecord esr = new ExprSetRecord(cmdId, setId);
				esr.save();
			}
		}		
	}
}
