import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CatalogServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.getAllBooks();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/catalog.jsp");
        dispatcher.forward(request, response);
    }
}
