package art.stat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatDB {
	public static final String CMD_EXPR = "expr";
	public static final String CMD_SETLOOP = "setloop";
	public static final String CMD_MESSAGE = "message";
	public static final String CMD_REMOVE = "remove";
	public static final String CMD_IF = "if";
	public static final String CMD_IFNDEF = "ifndef";
	public static final String CMD_IFDEF = "ifdef";
	public static final String CMD_SELECT = "select";
	public static final String CMD_BREAK = "break";
	public static final String CMD_INSERT = "insert";
	public static final String CMD_ADAPT = "adapt";
	public static final String CMD_OUTPUT = "output";
	public static final String CMD_WHILE = "while";
	public static final String CMD_SET = "set";
	
	private static String DEFAULT_DB_NAME = "cda_trace.db";
	public static final String SQLITE_CLASS_NAME = "org.sqlite.JDBC";
	public static final String SQLITE_CONN_NAME = "jdbc:sqlite:";
	private static String connName = SQLITE_CONN_NAME + DEFAULT_DB_NAME;

	private static List<String> createQueries;
	private static List<String> tables;
	private static Map<String, Integer> cmdTypes;
	private static Connection conn;
	
	static {
		try {
			Class.forName(SQLITE_CLASS_NAME);
			conn = DriverManager.getConnection(connName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tables = Arrays.asList(
				"cmd_file", 
				"cmd",
				"adapt_cmd",
				"cmd_type",
				"set_cmd", 
				"variable", 
				"multi_value",
				"while_cmd",
				"output_cmd",
				"break_point",
				"insert_cmd",
				"break_cmd",
				"break_insert",
				"select_cmd",
				"ifdef_cmd",
				"if_cmd",
				"remove_cmd",
				"message_cmd",
				"setloop_cmd",
				"expr_cmd",
				"ifndef_cmd",
				"expr_set",
				"while_var");

		createQueries = Arrays
						.asList("Create table if not exists cmd_file(file_id integer primary key autoincrement,file_name text,visit integer)",
								"Create table if not exists cmd(cmd_id integer primary key autoincrement,file_id integer,cmd_type_id integer,cmd_value text,line_no integer)",
								"Create table if not exists cmd_type(cmd_type_id integer,cmd_name text)",
								"Create table if not exists adapt_cmd(cmd_id integer, adapt_expr text, adapting_file_id integer,adapted_file_id integer,extended integer,same_level integer)",
								"Create table if not exists set_cmd(cmd_id integer,var_id integer,value text,defer integer,multi_value integer)",
								"Create table if not exists variable(var_id integer primary key autoincrement,var_name text,set_id integer)",								
								"Create table if not exists multi_value(set_id integer,value_no integer,value text)",
								"Create table if not exists while_cmd(cmd_id integer,expr text)",
								"Create table if not exists output_cmd(cmd_id integer,output_file text)",
								"Create table if not exists break_point(break_point_id integer primary key autoincrement,break_name text,insert_type integer,insert_id integer)",
								"Create table if not exists insert_cmd(cmd_id integer,break_id integer)",
								"Create table if not exists break_cmd(cmd_id integer,break_name text)",
								"Create table if not exists break_insert(break_id integer,insert_id integer)",
								"Create table if not exists select_cmd(cmd_id integer,expr text,var_id integer)",
								"Create table if not exists ifdef_cmd(cmd_id integer,var text)",
								"Create table if not exists if_cmd(cmd_id integer,expr text)",
								"Create table if not exists remove_cmd(cmd_id integer,var_id integer)",
								"Create table if not exists message_cmd(cmd_id integer,message text,extended integer)",
								"Create table if not exists setloop_cmd(cmd_id integer,loop text)",
								"Create table if not exists expr_cmd(cmd_id integer,expr text,value text)",
								"Create table if not exists ifndef_cmd(cmd_id integer,var text)",
								"Create table if not exists expr_set(expr_id integer,set_id integer)",
								"Create table if not exists while_var(while_id integer,var_id integer)");
		
		cmdTypes = new HashMap<String, Integer>();
		cmdTypes.put(CMD_SET, 0);
		cmdTypes.put(CMD_WHILE, 1);
		cmdTypes.put(CMD_OUTPUT, 2);
		cmdTypes.put(CMD_ADAPT, 3);
		cmdTypes.put(CMD_INSERT, 4);
		cmdTypes.put(CMD_BREAK, 5);
		cmdTypes.put(CMD_SELECT, 6);
		cmdTypes.put(CMD_IFDEF, 7);
		cmdTypes.put(CMD_IFNDEF, 8);
		cmdTypes.put(CMD_IF, 9);
		cmdTypes.put(CMD_REMOVE, 10);
		cmdTypes.put(CMD_MESSAGE, 11);
		cmdTypes.put(CMD_SETLOOP, 12);
		cmdTypes.put(CMD_EXPR, 13);		
	}
	
	private static void dropExistingTables(Connection conn) throws SQLException {
		try(Statement stmt = conn.createStatement()) {			
			for(String table : tables) {
				stmt.addBatch("Drop table if exists " + table);
			}
			stmt.executeBatch();
		}
	}
	
	private static void truncateTables(Connection conn) throws SQLException {
		try(Statement stmt = conn.createStatement()) {			
			for(String table : tables) {
				stmt.addBatch("Delete from " + table);
			}
			stmt.addBatch("Delete from sqlite_sequence");
			stmt.executeBatch();
		}
	}
	
	public static void setup(Boolean dropIfExists) throws SQLException {				
		try(Statement createStmt = conn.createStatement();
				Statement insertStmt = conn.createStatement()) {	
			
			if(dropIfExists) {
				dropExistingTables(conn);
			}
			
			for(String query : createQueries) {
				createStmt.addBatch(query);
			}
			createStmt.executeBatch();
			
			if(!dropIfExists) {
				truncateTables(conn);
			}
			
			Set<Map.Entry<String, Integer>> entries = cmdTypes.entrySet();
			for(Map.Entry<String, Integer> entry : entries) {
				insertStmt.addBatch("Insert into cmd_type values(" + entry.getValue() + ",'" + entry.getKey() + "')");
			}
			insertStmt.executeBatch();
		}
	}

	public static int getCmdTypeId(String cmdType) {
		return cmdTypes.get(cmdType);
	}
	
	public static String getConnName() {
		return connName;
	}

	public static void setConnName(String connName) {
		StatDB.connName = connName;
	}
	
	public static Connection getConn() {
		return conn;
	}
	
	public static void shutdown() throws SQLException {
		if(conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
}
