import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckoutServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        UserDao userDao = new UserDao();
        int userId = userDao.getUserIdByUsername(username);
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart != null && !cart.isEmpty()) {
            OrderDao orderDao = new OrderDao();
            boolean isOrderPlaced = orderDao.placeOrder(userId, cart);
            if (isOrderPlaced) {
                session.removeAttribute("cart");
                out.println("Order placed successfully!");
            } else {
                out.println("Order placement failed!");
            }
        } else {
            out.println("Cart is empty!");
        }
    }
}
