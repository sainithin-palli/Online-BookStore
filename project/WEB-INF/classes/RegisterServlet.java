import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        UserDao userDao = new UserDao();
        boolean isRegistered = userDao.registerUser(username, password, email);
        if (isRegistered) {
            out.println("Registration successful!");
        } else {
            out.println("Registration failed!");
        }
    }
}
