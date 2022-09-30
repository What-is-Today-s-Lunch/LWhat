package lwhat.git.test;

import java.sql.Connection;

import lwhat.util.ConnectionManager;

public class TestConnection {

	public static void main(String[] args) {

		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println(conn);
		}

	} // main
	
} // class 
