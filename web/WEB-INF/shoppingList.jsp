<%-- 
    Document   : shoppingList
    Created on : Jun 20, 2021, 1:22:57 PM
    Author     : 694952
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1
        <p>Hello, ${user} <a href="<c:url value="/ShoppingList">
                                 <c:param name="action" value="logout" />
                             </c:url>">
                                 Logout</a></p>
        <h2>List</h2>
        <form method="post" action="">
            <p>Add item: <input type="text" name="item"><input type="submit" Value="Add">
            <input type="hidden" name="action" value="add"></p>
        </form>
        <form method="post" action="">
            <table>
                <c:forEach items="${list}" var="list">
                <tr>
                    <td>
                        <input type="radio" name="listitem" value="${list}">
                        ${list}
                    </td>
                </tr>
                </c:forEach>
                <tr>
                    <td>
                        <input type="submit" value="Delete">
                        <input type="hidden" name="action" value="delete">
                    </td>
                </tr>
            </table>
        </form>
            
    </body>
</html>
