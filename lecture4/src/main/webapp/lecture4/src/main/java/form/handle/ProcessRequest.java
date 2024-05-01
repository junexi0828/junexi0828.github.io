package form.handle;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.Enumeration;



/**
 * Servlet implementation class ProcessRequest
 */
public class ProcessRequest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public ProcessRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Handles GET request and forwards to JSP.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()) {
            String param = params.nextElement();
            if ("reason".equals(param)) {
                String[] values = request.getParameterValues(param);
                request.setAttribute(param, String.join(", ", values)); // Join array and set as attribute
            } else {
                String value = request.getParameter(param);
                request.setAttribute(param, value); // Set single value as attribute
            }
        }

        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("formResponse.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles POST request by forwarding to doGet method.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
