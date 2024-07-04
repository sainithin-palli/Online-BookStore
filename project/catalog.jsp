<!DOCTYPE html>
<html>
<head>
    <title>Book Catalog</title>
</head>
<body>
    <h1>Book Catalog</h1>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td><form action="cart" method="post">
                    <input type="hidden" name="bookId" value="${book.id}">
                    <input type="submit" value="Add to Cart">
                </form></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
