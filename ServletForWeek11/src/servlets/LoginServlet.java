package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String usernameAdmin = "asd1";
	private static final String passwordAdmin = "asd2";
       
    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        if (session.getAttribute("username") == null) {
        	request.getRequestDispatcher("index.html").include(request, response);
		}
        else {
        	request.getRequestDispatcher("links.html").include(request, response);
			out.println("You are already logged in ,you have to logout first.");
		}
        out.close();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");  
        String password=request.getParameter("password");
        PrintWriter out=response.getWriter();
        
        
        if (username.equals(usernameAdmin) && password.equals(passwordAdmin)) {
        	HttpSession session=request.getSession();
        	session.setAttribute("username", username);
        	out.println("");
        	request.getRequestDispatcher("links.html").include(request, response);
			out.print("Welcome: " + username);
		}
        else {
            request.getRequestDispatcher("index.html").include(request, response);
            out.print("Your username or password is wrong!"); 
		}
        
        out.close();
	}

}
