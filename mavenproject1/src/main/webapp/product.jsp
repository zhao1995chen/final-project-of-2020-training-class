<%@ page contentType="text/html; charset=UTF-8"  %>
<%@ page import="java.util.*,domain.*" %>
<jsp:useBean id="catalog"  scope="application"  class="java.util.ArrayList" />
<%! Iterator itr = null;  %>
<%
    itr = catalog.iterator();
%>
<html>
    <head></head>
    <body>
        <h1>MVC Listener & Beans</h1></br>
        <span>DukeStore MVC-version</span>
        <table border="1">
            <tr>
                <th>Code</th><th>Price</th>
                <th>Description</th><th>Quantity</th>
            </tr>
            <% while (itr.hasNext()) {
                    Product prod = (Product) itr.next();%>
            <tr>
                <td><%=prod.getCode()%></td>
                <td><%=prod.getPrice()%></td>
                <td><%=prod.getDescription()%></td>
                <td><%=prod.getQuantity()%></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
