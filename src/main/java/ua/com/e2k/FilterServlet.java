package ua.com.e2k;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.IllegalFormatException;

/**
 * Created by andre on 11/21/2016.
 */
public class FilterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromStr = req.getParameter("from");
        String toStr = req.getParameter("to");
        String discStr = req.getParameter("discont");
        System.out.println("from="+fromStr+" to="+toStr+" discont=" + discStr);

        if (fromStr!=null&&toStr!=null)
        {
            MenuDAO menuDAO = MenuDAO.getInstance();

            try{

                if (fromStr.equals("")&&(!toStr.equals("")))
                {
//                    Только от и до конца
                    int from = Integer.parseInt(toStr);
                    req.setAttribute("list",menuDAO.getMenuFrom(from));
                    req.getRequestDispatcher("/menu.jsp").forward(req, resp);
                    return;


                }

                if (!fromStr.equals("")&&(toStr.equals("")))
                {
//                    От начала и до
                    int to = Integer.parseInt(fromStr);
                    req.setAttribute("list",menuDAO.getMenuTo(to));
                    req.getRequestDispatcher("/menu.jsp").forward(req, resp);
                    return;

                }

                if (!fromStr.equals("")&&(!toStr.equals("")))
                {
//                    От и до
                    int to = Integer.parseInt(toStr);
                    int from = Integer.parseInt(fromStr);
                    req.setAttribute("list",menuDAO.getMenuFromTo(from, to));
                    req.getRequestDispatcher("/menu.jsp").forward(req, resp);
                    return;

                }




            } catch (NumberFormatException e)
            {
                req.setAttribute("err","Ошибка в настройке фильтра");
                req.getRequestDispatcher("/menu").forward(req, resp);
                return;
            }



        }

    }
}
