package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter(); 
        HttpSession session=request.getSession();
        
        if (session.getAttribute("username") != null) {
        	session.invalidate();  
        	request.getRequestDispatcher("index.html").include(request, response);
            out.print("You are successfully logged out!");
		}
        else {
        	request.getRequestDispatcher("index.html").include(request, response);
            out.print("You are not logged in!"); 
		}  
          
        out.close(); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
