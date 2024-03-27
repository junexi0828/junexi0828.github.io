package kr.ac.pknu;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    	throws ServletException, IOException {
    	 
    	res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        // HTML 문서를 작성하여 클라이언트에게 전송
        pw.println("<html><body>");
        pw.println("Hello Servlet!");
        pw.println("</body></html>");
        pw.close();
    }
}
