package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.dao.UserDao;

/**
 * Servlet implementation class register
 */
@WebServlet("/Register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
		UserDao dao = new UserDao();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.print("Register:"+username+" "+password);  

		          
		try{  
			if (dao.insert(username, password)){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("welcome.jsp");
			}
			else {
				response.sendRedirect("register.jsp");
			}
			          
		}catch (Exception e2) {
			System.out.println(e2);
		}       
	}
}
