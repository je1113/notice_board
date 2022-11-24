package com.koreait.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.db.Dbconn;

@WebServlet("/DeleteOk")
public class DeleteOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteOk() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		PrintWriter writer =response.getWriter();
		
		String b_idx= request.getParameter("b_idx");
		String userid = (String)session.getAttribute("userid");
		try{
			conn = Dbconn.getConnection();
			if(conn != null){
				String sql = "delete from tb_reply where re_boardidx=?";
				pstmt= conn.prepareStatement(sql);
				pstmt.setString(1,b_idx);
				pstmt.executeUpdate();
				
				sql = "delete from tb_board where b_idx=? and b_userid=?";
				pstmt= conn.prepareStatement(sql);
				pstmt.setString(1,b_idx);
				pstmt.setString(2,userid);
				pstmt.executeUpdate();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		String data = "<script>alert('삭제되었습니다'); location.href='./board/list.jsp';</script>";

		writer.println(data);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
