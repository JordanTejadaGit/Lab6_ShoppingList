package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        if (action != null) {
                if (action.equals("logout")) {
                    session.removeAttribute("user");
                    session.removeAttribute("list");
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    return;
                }
            }
        else if (session.getAttribute("user") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String item = request.getParameter("item");

        ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");

        if (action != null) {
            if (action.equals("register")) {
                if (username != null && !username.equals("")) {
                    session.setAttribute("user", username);
                    response.sendRedirect("ShoppingList");
                    return;
                } else {
                    response.sendRedirect("ShoppingList");
                    return;
                }
            } else if (action.equals("add") && !item.equals("")) {
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(item);
                    session.setAttribute("list", list);
                    response.sendRedirect("ShoppingList");
                    return;
                } else {
                    list.add(item);
                    session.setAttribute("list", list);
                    response.sendRedirect("ShoppingList");
                    return;
                }
            } else if (action.equals("delete") && request.getParameter("listitem") != null && !request.getParameter("listitem").equals("")) {
                String remove = request.getParameter("listitem");
                for (int i = 0; i < list.size(); i++) {
                    if (remove.equals(list.get(i))) {
                        list.remove(i);
                    }
                }
                response.sendRedirect("ShoppingList");
                return;
            }
            else {
                response.sendRedirect("ShoppingList");
            }

        }
        else {
            response.sendRedirect("ShoppingList");
        }
    }
}
