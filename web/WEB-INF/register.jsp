<%-- 
    Document   : register
    Created on : Jun 20, 2021, 1:22:41 PM
    Author     : 694952
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList">
            <table>
                <td>
                <tr>
                    Username:
                </tr>
                <tr>
                <input type="text" name="username">
                </tr>
                <tr>
                <input type ="submit" value="Register name">
                <input type="hidden" name="action" value="register">
                </tr>
                </td>
            </table>
        </form>
    </body>
</html>
