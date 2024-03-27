package lab.task;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("psw");
        String repeatPassword = request.getParameter("psw-repeat");
        String[] remember = request.getParameterValues("remember");
        
        // Basic email validation
        if (email != null && email.contains("@")) {
            request.setAttribute("email", email);
            request.setAttribute("psw", password);
            request.setAttribute("psw-repeat", repeatPassword);
            request.setAttribute("remember", remember);

            // Forward to ok.jsp
            request.getRequestDispatcher("/ok.jsp").forward(request, response);

        } else {
            response.sendRedirect("err.html");
        }
    }}
    

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


