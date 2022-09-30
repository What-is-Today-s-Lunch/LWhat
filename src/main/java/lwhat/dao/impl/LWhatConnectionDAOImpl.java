package lwhat.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import lwhat.dao.LWhatConnectionDAO;
import lwhat.util.ConnectionManager;

public class LWhatConnectionDAOImpl implements LWhatConnectionDAO {

	// 연결, 끊기 구현

	@Override
	public Connection getConnection() {
		return ConnectionManager.getConnection();
	}

	@Override
	public void closeConnection(Connection conn) {
		ConnectionManager.closeConnection(conn);
	}

	@Override
	public void closeConnection(Statement stmt, Connection conn) {
		ConnectionManager.closeConnection(stmt, conn);
	}

	@Override
	public void closeConnection(ResultSet rs, Statement stmt, Connection conn) {
		ConnectionManager.closeConnection(rs, stmt, conn);
	}
}
