package ua.com.e2k;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.BitSet;

/**
 * Created by andre on 11/22/2016.
 */
public class DellBasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId= req.getParameter("id");
        System.out.println(strId);
        if (strId!=null)
        {


            if (!Basket.delMenuById(Integer.parseInt(strId)))
            {
                req.setAttribute("errb","Ошибка удаления блюда");
            }
            req.removeAttribute("id");
            req.getRequestDispatcher("/menu").forward(req,resp);
        }
    }
}
