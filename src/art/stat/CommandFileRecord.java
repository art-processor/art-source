package art.stat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandFileRecord extends Record {
	private static final String TABLE_CMD_FILE = "cmd_file";

	private static final String INSERT_SQL = "Insert into cmd_file(file_name,visit) values(?,?)";
	private static final String VISIT_COUNT_SQL = "Select count(1) from cmd_file where file_name=?";
	
	private Long fileId = null;
	private String fileName;
	private int visit;

	public CommandFileRecord(String fileName) {
		super();
		
		String tmp = fileName;
		if(tmp.startsWith("\"")) {
			tmp = tmp.substring(1);
		}
		if(tmp.endsWith("\"")) {
			tmp = tmp.substring(0, tmp.length() - 1);
		}
		this.fileName = tmp;
	}

	public Long getFileId() {
		return fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getVisit() {
		return visit;
	}
	
	@Override
	public void save() throws SQLException {
		visit = CommandFileRecord.getVisitCount(fileName) + 1;
		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL);
				Statement selectStmt = StatDB.getConn().createStatement()) {			
			insertStmt.setString(1, fileName);
			insertStmt.setInt(2, visit);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into cmd_file table");
			}
						
			fileId = getLastInsertedRowId(selectStmt, TABLE_CMD_FILE);
		}
	}	
	
	public static int getVisitCount(String fileName) throws SQLException {
		int visitCount = 0;
		try(Connection conn = DriverManager.getConnection(StatDB.getConnName());
				PreparedStatement selectStmt = conn.prepareStatement(VISIT_COUNT_SQL)) {
			selectStmt.setString(1, fileName);
			try(ResultSet rs = selectStmt.executeQuery()) {
				if (rs.next()) {
					visitCount = rs.getInt(1);
				}
			} 
		}
		return visitCount;
	}
}
