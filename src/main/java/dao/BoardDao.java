package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Dbutil.Dbconnection;

public class BoardDao {
	
	public int writeBoard(String userid,String title,String content) {
		
		String sql = "insert into board(userid, title, content, hit)"
				+ "value(?,?,?,0)";
		
		
		
		int result = 0;
		
		try {
			Connection conn = Dbconnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			pstmt.setString(2,title);
			pstmt.setString(3,content );
			
			int result = pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			
		}
		
		return result;
	
		
		
		
		
		
		return
	}

}
