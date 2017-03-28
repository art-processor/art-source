package art.stat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BreakPointRecord extends Record {
	private static final String TABLE_BREAK_POINT = "break_point";
	private static final String INSERT_SQL = "Insert into break_point(break_name,insert_type,insert_id) values(?,?,?)";
	private static final String FIND_BY_NAME_AND_TYPE_SQL = "Select * from break_point where break_name = ? and insert_type =?";
	private static final String UPDATE_INSERT_ID_SQL = "Update break_point set insert_id = ? where break_point_id = ?";
	private static final String FIND_BY_NAME_SQL = "Select * from break_point where break_name = ?";
	
	private Long breakPointId;
	private String breakName;
	private int insertType;
	private Long insertId;
	
	public Long getInsertId() {
		return insertId;
	}

	public void setInsertId(Long insertId) {
		this.insertId = insertId;
	}

	public int getInsertType() {
		return insertType;
	}

	public void setInsertType(int insertType) {
		this.insertType = insertType;
	}

	public Long getBreakPointId() {
		return breakPointId;
	}

	public void setBreakPointId(Long breakPointId) {
		this.breakPointId = breakPointId;
	}

	public String getBreakName() {
		return breakName;
	}

	public void setBreakName(String breakName) {
		this.breakName = breakName;
	}

	public void updateInsertId() throws SQLException {
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(UPDATE_INSERT_ID_SQL)) {			
			insertStmt.setLong(1, insertId);
			insertStmt.setLong(2, breakPointId);
			int rowCount = insertStmt.executeUpdate();
	
			if(rowCount == 0) {
				throw new SQLException("Failed to update break_point table for break_point_id : " + breakPointId);
			}
		}	
	}
	
	@Override
	public void save() throws SQLException {
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL);
				Statement selectStmt = StatDB.getConn().createStatement()) {			
			insertStmt.setString(1, breakName);
			insertStmt.setInt(2, insertType);
			insertStmt.setLong(3, insertId);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into break_point table");
			}
			
			breakPointId = getLastInsertedRowId(selectStmt, TABLE_BREAK_POINT);
		}		

	}
	
	public static List<BreakPointRecord> findBreakPoint(String breakName) throws SQLException {
		List<BreakPointRecord> bpList = new ArrayList<>();
		
		try(PreparedStatement selectStmt = StatDB.getConn().prepareStatement(FIND_BY_NAME_SQL)) {			
				selectStmt.setString(1, breakName.trim());
				try(ResultSet rs = selectStmt.executeQuery()) {
					while(rs.next()) {
						BreakPointRecord bp = new BreakPointRecord();
						bp.setBreakPointId(rs.getLong("break_point_id"));
						bp.setBreakName(rs.getString("break_name"));
						bp.setInsertType(rs.getInt("insert_type"));
						bp.setInsertId(rs.getLong("insert_id"));
						bpList.add(bp);
					}
				}
			}
		
		return bpList;
	}
	
	public static BreakPointRecord findBreakPoint(String breakName, int insertType) throws SQLException {
		BreakPointRecord bp = null;
		try(PreparedStatement selectStmt = StatDB.getConn().prepareStatement(FIND_BY_NAME_AND_TYPE_SQL)) {			
			selectStmt.setString(1, breakName);
			selectStmt.setInt(2, insertType);
			try(ResultSet rs = selectStmt.executeQuery()) {
				if(rs.next()) {
					bp = new BreakPointRecord();
					bp.setBreakPointId(rs.getLong("break_point_id"));
					bp.setBreakName(rs.getString("break_name"));
					bp.setInsertType(rs.getInt("insert_type"));
					bp.setInsertId(rs.getLong("insert_id"));
				}
			}
		}
		return bp;
	}
}
