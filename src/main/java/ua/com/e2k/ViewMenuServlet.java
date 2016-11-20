package ua.com.e2k;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by andre on 11/18/2016.
 */
public class ViewMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MenuDAO menuDAO = MenuDAO.getInstance();


        req.setAttribute("list", menuDAO.getAllMenu());

        req.getRequestDispatcher("/menu.jsp").forward(req,resp);

    }
}
