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
        String discStr = req.getParameter("discount");
        System.out.println("from="+fromStr+" to="+toStr+" discont=" + discStr);
        req.setAttribute("basket",Basket.getList());
        req.setAttribute("allWeight", Basket.getAllWeight());
        if (fromStr!=null&&toStr!=null)
        {
            MenuDAO menuDAO = MenuDAO.getInstance();

            try{



                if (fromStr.equals("")&&(!toStr.equals("")))
                {
//                   Все от начала и до to
                    System.out.println(">> Фильтр from 0 to TO");
                    int to = Integer.parseInt(toStr);

                    if (discStr.equals("all"))
                        req.setAttribute("list",menuDAO.getMenuTo(to));
                    else
                        req.setAttribute("list", menuDAO.getMenuToDiscount(to,discStr.equals("true")?true:false));
                    req.getRequestDispatcher("/menu.jsp").forward(req, resp);
                    return;


                }

                if (!fromStr.equals("")&&(toStr.equals("")))
                {
//                    Все от from и до конца
                    System.out.println(">> Фильтр FROM to end");
                    int from = Integer.parseInt(fromStr);
                    if (discStr.equals("all"))
                         req.setAttribute("list",menuDAO.getMenuFrom(from));
                    else
                        req.setAttribute("list", menuDAO.getMenuFromDiscount(from,discStr.equals("true")?true:false));
                    req.getRequestDispatcher("/menu.jsp").forward(req, resp);
                    return;

                }

                if (!fromStr.equals("")&&(!toStr.equals("")))
                {
//                    Все с from и до to
                    System.out.println(">> Фильтр FROM to END");
                    int to = Integer.parseInt(toStr);
                    int from = Integer.parseInt(fromStr);
                    if (discStr.equals("all"))
                        req.setAttribute("list",menuDAO.getMenuFromTo(from, to));
                    else
                        req.setAttribute("list", menuDAO.getMenuFromToDiscount(from, to ,discStr.equals("true")?true:false));
                    req.getRequestDispatcher("/menu.jsp").forward(req, resp);
                    return;

                }

                if ((fromStr.equals(""))&&(toStr.equals("")))
                {
//                    Фильтр по скидке
                    if (discStr.equals("all"))
                        req.setAttribute("list",menuDAO.getAllMenu());
                    else
                        req.setAttribute("list", menuDAO.getAllDiscount(discStr.equals("true")?true:false));
                    req.getRequestDispatcher("/menu.jsp").forward(req, resp);
                    return;
                }




            } catch (NumberFormatException e)
            {
                req.setAttribute("err","Ошибка в параметрах фильтра");

                req.getRequestDispatcher("/menu").forward(req, resp);
                return;
            }



        }

    }
}
