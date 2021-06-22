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
        <p>Hello, ${username} <a href></a></p>
        <h2>List</h2>
        <form method="post" action="ShoppingList">
            <p>Add item: <input type="text" name="item"> <input type="submit" name="add" value="Add"></p>
        </form>
        <form method="post" action="ShoppingList">
            <table>
                <tr>
                    <c:forEach items=""
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="delete" value="delete">
                    </td>
                </tr>
            </table>
        </form>
            
    </body>
</html>
