package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import Dbutil.Dbconnection;
import board.BoardJoinDto;
import member.MemberDto;

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
		
		
		public ArrayList<BoardJoinDto> boardlist(title, content, hit, sql, userid, uname, uemail) {
			
			String sql = "select "
					+ "B.boardnum,"
					+ "B.title,"
					+ "B.content,"
					+ "B.regdate,"
					+ "B.hit,"
					+ "M.userid,"
					+ "M.username,"
					+ "M.email "
					+" from board B "
					+" inner join member M "
					+" on B.userid = M.userid "
					+" order by B.boardnum desc";
			
			
			
			ArrayList<BoardJoinDto> boardList = new ArrayList<BoardJoinDto>();
			
			
			try {
				Connection conn = Dbconnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
			
			
			ResultSet rs= pstmt.executeQuery();
			
			while (rs.next()) {
				
				int boardnum = rs.getInt("boardnum");
				String userid = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				String uname = rs.getString("username");
				String uemail = rs.getString("email");
				Timestamp udate = rs.getTimestamp("userdate"); 
				
				BoardJoinDto BJDto = new BoardJoinDto(title, content, hit, sql, userid, uname, uemail);
				return BJDto;
				
				
				boardlist.add(BJDto);
				
				
			}
			
		}catch(Exception e) {
			
		}
			
		}
	
		
		
		
		
		
		return
	}

}
