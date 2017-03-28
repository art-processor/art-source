package art.stat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SetRecord extends CommandRecord {
	private static final String INSERT_SQL = "Insert into set_cmd(cmd_id,var_id,value,defer,multi_value) values(?,?,?,?,?)";
	private static final String FIND_SET_ID_SQL = "Select cmd_id from set_cmd, variable where set_cmd.var_id = variable.var_id and" +
			" variable.var_name = ? and set_cmd.value = ? and multi_value = 0 order by cmd_id desc";
	private static final String FIND_SET_ID_MULTI_VALUE_SQL = "Select cmd_id from set_cmd,variable, multi_value where set_cmd.var_id = variable.var_id and " +
			"set_cmd.cmd_id = multi_value.set_id and variable.var_name = ? and set_cmd.multi_value = 1 and multi_value.value = ? order by cmd_id desc";
	private String varName;
	private Long varId;
	private String value;
	private boolean defer;
	private boolean multiValue;
	private List<String> valueList;

	public SetRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_SET);
	}
	
	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public Long getVarId() {
		return varId;
	}

	public void setVarId(Long varId) {
		this.varId = varId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isDefer() {
		return defer;
	}

	public void setDefer(boolean defer) {
		this.defer = defer;
	}

	public boolean isMultiValue() {
		return multiValue;
	}

	public List<String> getValueList() {
		return valueList;
	}

	public void setValueList(List<String> valueList) {
		if(valueList == null || valueList.size() == 0) {
			throw new IllegalArgumentException("Invalid value.");
		}
		
		if(valueList.size() > 1) {
			multiValue = true;
			this.valueList = valueList;
		} else {
			multiValue = false;
			value = valueList.get(0);
		}
	}
	
	private String prepareCmdValue() {
		StringBuilder sb = new StringBuilder();
		sb.append("set ");
		sb.append(varName);
		sb.append(" = ");
		
		if(multiValue) {
			for(String v : valueList) {
				sb.append(v);
				sb.append(",");
			}
			sb.setLength(sb.length() - 1);
		} else {
			sb.append(value);
		}
		
		return sb.toString();
	}
	
	@Override
	public void save() throws SQLException {
		cmdValue = prepareCmdValue();
		super.save();
		
		//Creare a new record in variable table if it doesn't exist
		VariableRecord vr = VariableRecord.findByVarName(varName);
		if(vr == null) {
			vr = new VariableRecord();
			vr.setVarName(varName);
			vr.save();
		}
		
		varId = vr.getVarId();
		
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {			
			insertStmt.setLong(1, cmdId);
			insertStmt.setLong(2, varId);
			insertStmt.setString(3, value);
			insertStmt.setInt(4, defer? 1 : 0);
			insertStmt.setInt(5, multiValue? 1 : 0);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into set_cmd table");
			}
			
			if(multiValue) {
				for(int i = 0; i < valueList.size(); i++) {
					MultiValueRecord mvr = new MultiValueRecord(cmdId, i, valueList.get(i));
					mvr.save();
				}
			}
			
			//Update the variable record's set_id to keep track of the last setCommand 
			//which sets value to the variable
			vr.setSetId(cmdId);
			vr.updateSetId();
		}
	}
	
	public static Long findSetId(String var, String value) throws SQLException {
		Long setId = null;
		try(Connection conn = DriverManager.getConnection(StatDB.getConnName());
				PreparedStatement selectStmt = conn.prepareStatement(FIND_SET_ID_SQL)) {			
			selectStmt.setString(1, var);
			selectStmt.setString(2, value);
			
			try(ResultSet rs = selectStmt.executeQuery()) {
				if(rs.next()) {
					setId = rs.getLong(1);
				}
			}
		}
		
		if(setId == null) {
			try(Connection conn = DriverManager.getConnection(StatDB.getConnName());
					PreparedStatement selectStmt = conn.prepareStatement(FIND_SET_ID_MULTI_VALUE_SQL)) {			
				selectStmt.setString(1, var);
				selectStmt.setString(2, value);
				
				try(ResultSet rs = selectStmt.executeQuery()) {
					if(rs.next()) {
						setId = rs.getLong(1);
					}
				}
			}
		}
		
		return setId;
	}
	
}
