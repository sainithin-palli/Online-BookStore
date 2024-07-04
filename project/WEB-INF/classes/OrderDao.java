import java.sql.*;
import java.util.*;

public class OrderDao {
    public boolean placeOrder(int userId, List<Book> books) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String query = "INSERT INTO orders (user_id, book_id) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            for (Book book : books) {
                ps.setInt(1, userId);
                ps.setInt(2, book.getId());
                ps.addBatch();
            }
            int[] results = ps.executeBatch();
            return Arrays.stream(results).allMatch(result -> result > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
