import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        BookDao bookDao = new BookDao();
        Book book = bookDao.getBookById(bookId);
        if (book != null) {
            cart.add(book);
            out.println("Book added to cart!");
        } else {
            out.println("Book not found!");
        }
    }
}
