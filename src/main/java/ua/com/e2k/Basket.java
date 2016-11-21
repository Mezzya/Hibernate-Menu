package ua.com.e2k;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre on 11/21/2016.
 */
public class Basket {

    static private List<Menu> list = new ArrayList<Menu>();
    static private int allWeight=0;

    public Basket() {
    }

    public static List<Menu> getList() {
        return list;
    }

    public static int getAllWeight() {
        return allWeight;
    }

    public static boolean addMenu(Menu menu)
    {
        if ((allWeight+menu.getWeight())>1000)
        {
//            Не могу добавить. слишком много будет
            return false;
        } else
        {
            list.add(menu);
            allWeight+=menu.getWeight();
            return true;

        }
    }

    public static boolean delMenuById(int id)
    {

        for (Menu menu: list) {

            if (menu.getId()==id)
            {
//                Нашли и  удаляем
                allWeight-=menu.getWeight();
                list.remove(menu);

                return true;

            }


        }

//        Нету такого
        return false;

    }


}
