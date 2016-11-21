package ua.com.e2k;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andre on 11/21/2016.
 */
public class DelMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId= req.getParameter("id");
        System.out.println(strId);
        if (strId!=null)
        {
            MenuDAO menuDAO = MenuDAO.getInstance();

            if (!menuDAO.delById(Integer.parseInt(strId)))
            {
                req.setAttribute("err","Ошибка удаления блюда");
            }
            req.removeAttribute("id");
            req.getRequestDispatcher("/menu").forward(req,resp);
        }
    }
}
