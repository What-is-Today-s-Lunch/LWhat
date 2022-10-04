package lwhat.git.test;

import lwhat.dao.impl.board.BoardDeleteDAOImpl;

public class TestDelete {
	
	public static void main(String[] args) {
		
		try {
			new BoardDeleteDAOImpl().deleteBoard(35);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
