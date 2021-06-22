
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
        
        if (request.getParameter("logout") != null) {
            session.removeAttribute("user");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else if (session.getAttribute("user") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String user = request.getParameter("username");
        
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("add");
        
        if (user != null || user == "") {
            session.setAttribute("username", user);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            
            if (request.getParameter("add") != null || request.getParameter("add") == "") {
                String item = request.getParameter("add");
                list.add(item);
                
                session.setAttribute("list", list);
            }
        }
        
    }
}
