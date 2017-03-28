package art.stat;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OutputRecord extends CommandRecord {
	private String outputFile;
	private static final String INSERT_SQL = "Insert into output_cmd(cmd_id,output_file) values(?,?)";
	
	public OutputRecord() {
		super();
		cmdTypeId = StatDB.getCmdTypeId(StatDB.CMD_OUTPUT);
	}
	
	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
	
	@Override
	public void save() throws SQLException {
		cmdValue = "output " + outputFile;
		super.save();

		try(PreparedStatement insertStmt = StatDB.getConn().prepareStatement(INSERT_SQL)) {			
			insertStmt.setLong(1, cmdId);
			insertStmt.setString(2, outputFile);
			int rowCount = insertStmt.executeUpdate();
			
			if(rowCount == 0) {
				throw new SQLException("Failed to insert into output_cmd table");
			}
		}				
	}
}
