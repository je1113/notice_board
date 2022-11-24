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

@WebServlet("/ReplyDelOk")
public class ReplyDelOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReplyDelOk() {
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
		String re_idx= request.getParameter("re_idx");
		try{
			conn = Dbconn.getConnection();
			if(conn != null){
				String sql = "delete from tb_reply where re_idx=?";
				pstmt= conn.prepareStatement(sql);
				pstmt.setString(1,re_idx);
				pstmt.executeUpdate();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		String data = "<script>alert('삭제되었습니다'); location.href='./board/view.jsp?b_idx=";
		data += b_idx;
		data += "';</script>";
		writer.println(data);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
