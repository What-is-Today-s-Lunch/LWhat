package lwhat.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import lwhat.service.LWhatService;

public interface LWhatConnectionDAO extends LWhatService {
// 커넥션 연결 메소드들 뿌림 , 연결도 끊어줌
	public abstract Connection getConnection();

	public abstract void closeConnection(Connection conn);

	public abstract void closeConnection(Statement stmt, Connection conn);

	public abstract void closeConnection(ResultSet rs, Statement stmt, Connection conn);
}
