package lab.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("psw");
        String repeatPassword = request.getParameter("psw-repeat");

        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();

        // 입력값 체크
        if (email == null || email.isEmpty() || !email.contains("@")) {
            isValid = false;
            errorMessage.append("이메일 주소가 유효하지 않습니다.<br>");
        }
        if (password == null || password.isEmpty() || !password.equals(repeatPassword)) {
            isValid = false;
            errorMessage.append("비밀 번호가 서로 일치하지 않습니다.<br>");
        }

        if (isValid) {
            // 유효한 경우 처리
            response.sendRedirect("sample.ok.html");
        } else {
            // 오류가 있는 경우 처리
            response.setContentType("text/html");
            response.getWriter().println("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>가입처리 에러</title></head><body>");
            response.getWriter().println("<div style=\"width:400px;\" align=\"center\"><strong>입력값에 오류가 있습니다.</strong><br><br></div>");
            response.getWriter().println(errorMessage.toString());
            response.getWriter().println("<br><a href='signup.html'>다시 가입신청하러 가기</a>");
            response.getWriter().println("</body></html>");
        }
    }
}
