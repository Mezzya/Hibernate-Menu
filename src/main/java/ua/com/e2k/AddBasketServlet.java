package ua.com.e2k;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andre on 11/21/2016.
 */
public class AddBasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        try{
            int id = Integer.parseInt(strId);

            if (MenuDAO.getInstance().getById(id)!=null)
            {
//                Есть такой в базе. Добавим в корзину
                if (Basket.addMenu(MenuDAO.getInstance().getById(id)))
                {
//                    Получилось
                    req.setAttribute("basket",Basket.getList());
                    req.setAttribute("allWeight", Basket.getAllWeight());
                    req.getRequestDispatcher("/menu").forward(req, resp);
                    return;
                }
                else
                {
//                    Превышен вес
                    req.setAttribute("errb","Невозможно добавить в корзину. Привысится вес");
                    req.setAttribute("basket",Basket.getList());
                    req.setAttribute("allWeight", Basket.getAllWeight());
                    req.getRequestDispatcher("/menu").forward(req, resp);
                    return;
                }
            }




        } catch (NumberFormatException e)
        {
            System.out.println(">> Странный инт");
            req.getRequestDispatcher("/menu").forward(req, resp);
        }

    }
}
