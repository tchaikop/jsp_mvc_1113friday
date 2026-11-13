package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import member.MemberDto;

import java.io.IOException;
import java.util.ArrayList;

import board.BoardJoinDto;
import dao.BoardDao;
import dao.MemberDao;


@WebServlet("*.do")
public class frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		String context = request.getContextPath();
		String command = uri.substring(context.length());
		
		request.setCharacterEncoding("utf-8");
		
		if(command.equals("/memberjoin.do")) {
			request.getRequestDispatcher("memberjoin.jsp").forward(request, response);
		}else if(command.equals("/memberJoinAction.do")) {
			String userid = request.getParameter("userid");
			String userpw = request.getParameter("userpw");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			
			MemberDao dao = new MemberDao();
		int result =  dao.insertMember(userid,userpw,username,email);
		
		if (result == 1) {
			request.setAttribute("userid",userid);
			request.setAttribute("userpw",userpw);
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			
			
		}else {
			response.sendRedirect("memberjoin.do");
			 
			
		}
		
		
		
	}else if(command.equals("/loginAction.do")) {
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		MemberDao dao =new MemberDao();
		MemberDto mDto = dao.login(userid, userpw);
		
		if(mDto != null ) {
			HttpSession session = null;
			session = request.getSession();
			session.setAttribute("loginId",userid);
			
			
			
			request.getRequestDispatcher("/loginSuccess.do").forward(request, response);
			
		}else {
			request.setAttribute("errorMsg","비밀번호가 잘못 되었다");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}else if(command.equals("/logout.do")) {
		request.getSession().invalidate();  //로그아웃
		response.sendRedirect("login.do");
	}else if(command.equals("/boardWriteAction.do")) {
		
		// 로그인한 유저만 글쓰기 가능하게 한다
		String sid = (String)request.getSession().getAttribute("loginId"); //세션에서 아이디를 가져온다
		
		if(sid == null) {
			request.setAttribute("errorMsg",로그인 되는 놈만);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDao dao = new BoardDao();
		int result = dao.writeBoard(sid, title, content);
		
		if(result == 1) {
			response.sendRedirect("boardlist.do");
		}else {
			response.sendRedirect("boardWrite.do");
		}
		
	}else if (command.equals("/boardlist.do")) {
		BoardDao dao = new BoardDao();
		ArrayList<BoardJoinDto> boardlist = dao.boardlist();
		
		request.setAttribute("boardlist", boardlist);
		request.getRequestDispatcher("boardlist.jsp").forward(request, response);
	}
		
	}

}
