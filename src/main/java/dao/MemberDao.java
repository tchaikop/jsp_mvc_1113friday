package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import Dbutil.Dbconnection;
import member.MemberDto;

public class MemberDao {
	
	//회원 가입 메서드
	public void insertMember( String userid, String userpw, String username, String email) {
		String sql="insert into member(userid,userpw,username,email)"
			+"values(?,?,?,?)";	
		
		int result = 0;
				
		try {
			Connection conn = Dbconnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			pstmt.setString(2,userpw );
			pstmt.setString(3,username );
			pstmt.setString(4, email);
			
			int result = pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			
		}
		
		return result;
	}
	
	public MemberDto login(String userid, String userpw) {
		
		String sql= "select * from member where userid=? and userpw=?";
		
		try {
			Connection conn = Dbconnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			pstmt.setString(2,userpw );
		
		ResultSet rs= pstmt.executeQuery();
		
		if(rs.next()) {
			String uid = rs.getString("userid");
			String upw = rs.getString("userpw");
			String uname = rs.getString("username");
			String uemail = rs.getString("email");
			Timestamp udate = rs.getTimestamp("userdate"); 
			
			MemberDto mDto = new MemberDto(uid,upw,uname,uemail,udate);
			return mDto;
			
			
			
			
			
		}
		
	}catch(Exception e) {
		
	}

	}
