package lab.task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup2.go")
public class SignUp2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp2() {
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

        // Check if password and repeat password match
        if (password.equals(repeatPassword)) {
            if (email != null && email.contains("@")) {
                request.setAttribute("email", email);
                request.setAttribute("psw", password);
                request.setAttribute("psw-repeat", repeatPassword);
                request.setAttribute("remember", remember);

                // Forward to ok.jsp
                request.getRequestDispatcher("/ok2.jsp").forward(request, response);

            } else {
                response.sendRedirect("err2.html");
            }
        } else {
            response.sendRedirect("err2.html");
        }
    }
}
