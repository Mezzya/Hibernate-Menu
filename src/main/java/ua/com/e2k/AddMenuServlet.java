package ua.com.e2k;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andre on 11/21/2016.
 */
public class AddMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String weight = req.getParameter("weight");
        String discont = req.getParameter("discont");

        if ((name!=null)&&(price!=null)&&(weight!=null))
        {
            int pr = Integer.parseInt(price);
            int we = Integer.parseInt(weight);

            Menu newMenu = new Menu(name,pr,we,"true".equals(discont)?true:false);
            MenuDAO menuDAO = MenuDAO.getInstance();
            menuDAO.addMenu(newMenu);


            req.getRequestDispatcher("/menu").forward(req,resp);
            return;

        }

        resp.sendError(404);




    }
}
