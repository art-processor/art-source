package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultiValueRecord extends Record {
	private static final String INSERT_SQL = "Insert into multi_value(set_id,value_no,value) values(?,?,?)";
	
	private Long setId;
	private int valueNo;
	private String value;
	
	public MultiValueRecord(Long setId, int valueNo, String value) {
		this.setId = setId;
		this.valueNo = valueNo;
		this.value = value;
	}
	
	public Long getSetId() {
		return setId;
	}

	public void setSetId(Long setId) {
		this.setId = setId;
	}

	public int getValueNo() {
		return valueNo;
	}

	public void setValueNo(int valueNo) {
		this.valueNo = valueNo;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void save() throws SQLException {
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {			
			insertStmt.setLong(1, setId);
			insertStmt.setInt(2, valueNo);
			insertStmt.setString(3, value);
			
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into output table");
			}
		}		

	}

}
