package com.koreait.db;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.db.Dbconn;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		PrintWriter writer =response.getWriter();
		Connection conn = null;
		PreparedStatement pstmt;
		ResultSet rs = null;
		try {
			conn = Dbconn.getConnection();
			if(conn != null){
				
				String sql = "select mem_idx, mem_name from tb_member where mem_userid=? and mem_userpw=sha2(?,256)";	//세션에 idx, name을 저장하기 위해
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setString(2,userpw);
				rs=pstmt.executeQuery();
				if(rs.next()){
					session.setAttribute("userid",userid);
					session.setAttribute("idx",rs.getInt("mem_idx"));
					session.setAttribute("name",rs.getString("mem_name"));
					writer.println("<script>alert('로그인 되었습니다'); location.href='login.jsp';</script>");
				}else {
					writer.println("<script>alert('아이디/비밀번호를 확인해주세요'); history.back(); </script>");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
